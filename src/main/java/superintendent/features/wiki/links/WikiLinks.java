package superintendent.features.wiki.links;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import superintendent.apis.common.ApiPermission;
import superintendent.apis.common.Listener;
import superintendent.apis.common.events.CreateEvent;
import superintendent.apis.discord.DiscordMessage;
import superintendent.features.Feature;
import superintendent.features.FeatureCategory;

public class WikiLinks implements Feature {

  @Override
  public String getName() {
    return "Wiki Links";
  }

  @Override
  public int getVersionNum() {
    return 0;
  }

  @Override
  public int getPatchNum() {
    return 1;
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.WIKI;
  }

  @Override
  public String getDescription() {
    return "This feature will automatically post links to Halopedia pages"
        + " whenever it detects the syntax for a wiki link. Supports Wikipedia,"
        + " MediaWiki and Wikia links with the prefixes \"Wikipedia:\","
        + " \"mw:\", and \"w:c:WIKI_NAME\" respectively.";
  }

  @Override
  public boolean isEnabledByDefault() {
    return true;
  }

  @Override
  public Set<ApiPermission> getMinPermissions() {
    return new HashSet<>();
  }
  
  public Optional<Listener<CreateEvent<DiscordMessage>>>
      getMessageListener() {
    return Optional.of(new WikiLinkListener());
  }

}
