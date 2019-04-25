package superintendent.features.wiki.links;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import superintendent.apis.common.Listener;
import superintendent.apis.common.events.CreateEvent;
import superintendent.apis.discord.DiscordMessage;
import superintendent.apis.discord.InsufficientPermissionsException;

public class WikiLinkListener implements Listener<CreateEvent<DiscordMessage>> {
  
  private static final Map<String, SupportedWiki> wikis;
  private static final List<LinkType> linkTypes;
  
  static {
    Map<String, SupportedWiki> map = new HashMap<>();
    for (SupportedWiki wiki : SupportedWikis.values()) {
      if (!wiki.equals(SupportedWikis.DEFAULT)) {
        map.put(wiki.getPrefix(), wiki);
      }
    }
    wikis = Collections.unmodifiableMap(map);
    linkTypes = Arrays.asList(LinkTypes.values());
  }
  
  @Override
  public void heard(CreateEvent<DiscordMessage> event) {
    String text = event.getTrigger().getText();
    Map<LinkType, List<String>> linkMap = new HashMap<>();
    for (LinkType type : linkTypes) {
      List<String> links = getLinks(text, type)
          .stream()
          .map(l -> generateUrl(l, type))
          .collect(Collectors.toList());
      if (!links.isEmpty()) {
        linkMap.put(type, links);
      }
    }
    if (!linkMap.isEmpty()) {
      try {
        event.getTrigger().getChannel().post(generateMessage(linkMap));
      } catch (InsufficientPermissionsException e) {
        // No error correction needed here - it just means the bot didn't have
        // the right permissions
      }
    }
  }
  
  private List<String> getLinks(String text, LinkType type) {
    List<String> result = new ArrayList<>();
    Matcher matcher = Pattern.compile(type.getSearchRegex()).matcher(text);
    while (matcher.find()) {
      result.add(matcher.group().replaceAll(type.getCleanupRegex(), ""));
    }
    return result;
  }
  
  private String generateUrl(String link, LinkType type) {
    StringBuilder url = new StringBuilder();
    SupportedWiki wiki = SupportedWikis.DEFAULT;
    for (String prefix : wikis.keySet()) {
      if (link.toLowerCase().startsWith(prefix.toLowerCase())) {
        wiki = wikis.get(prefix);
        break;
      }
    }
    url.append(wiki.getBaseUrl());
    link = link.substring(wiki.getPrefix().length());
    if (!(link.matches("[^:]*:.*") || type.getDefaultNamespace().equals(""))) {
      url.append(type.getDefaultNamespace());
      url.append(':');
    } else if (link.startsWith(":")) {
      link = link.substring(1);
    }
    url.append(link.replaceAll("\\p{Space}", "_"));
    return url.toString();
  }
  
  private String generateMessage(Map<LinkType, List<String>> links) {
    StringBuilder message = new StringBuilder();
    for (LinkType type : links.keySet()) {
      if (links.get(type).isEmpty()) {
        continue;
      }
      message.append("**");
      message.append(type.getName());
      message.append(" links detected!**\n\n");
      for (String link : links.get(type)) {
        message.append('*');
        message.append(link);
        message.append('*');
        message.append('\n');
      }
      message.append('\n');
    }
    return message.toString();
  }

}