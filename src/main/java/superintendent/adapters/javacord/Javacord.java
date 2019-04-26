package superintendent.adapters.javacord;

import java.util.List;
import java.util.stream.Collectors;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import superintendent.apis.common.Listener;
import superintendent.apis.common.events.CreateEvent;
import superintendent.apis.discord.DiscordMessage;
import superintendent.apis.discord.DiscordServer;
import superintendent.apis.discord.DiscordUser;

public class Javacord implements superintendent.apis.discord.DiscordApi {
  
  private DiscordApi api;

  @Override
  public void login(String token) {
    api = new DiscordApiBuilder().setToken(token).login().join();
  }

  @Override
  public void logout() {
    api.disconnect();
    api = null;
  }

  @Override
  public boolean loggedIn() {
    return api == null;
  }

  @Override
  public DiscordUser getSelf() {
    return new JavacordUser(api.getYourself());
  }

  @Override
  public DiscordUser getOwner() {
    return new JavacordUser(api.getOwner().join());
  }

  @Override
  public List<DiscordServer> getServers() {
    return api.getServers()
        .stream()
        .map(server -> new JavacordServer(server))
        .collect(Collectors.toList());
  }

  @Override
  public void addGlobalMessageCreateListener(Listener<CreateEvent<DiscordMessage>> listener) {
    api.addMessageCreateListener(new MessageCreateListener() {
      @Override
      public void onMessageCreate(MessageCreateEvent event) {
        listener.heard(new CreateEvent<>(
            new JavacordMessage(event.getMessage())));
      }
    });
  }

}
