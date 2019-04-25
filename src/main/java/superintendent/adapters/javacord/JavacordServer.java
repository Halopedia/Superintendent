package superintendent.adapters.javacord;

import java.util.List;
import java.util.stream.Collectors;

import org.javacord.api.entity.server.Server;

import superintendent.apis.discord.DiscordRole;
import superintendent.apis.discord.DiscordServer;
import superintendent.apis.discord.channels.DiscordChannel;
import superintendent.apis.discord.channels.DiscordTextChannel;
import superintendent.apis.discord.channels.DiscordVoiceChannel;

public class JavacordServer implements DiscordServer {
  
  private final Server server;
  
  protected JavacordServer(Server server) {
    this.server = server;
  }

  protected Server getRaw() {
    return server;
  }

  @Override
  public String getName() {
    return server.getName();
  }

  @Override
  public List<DiscordChannel> getChannels() {
    return server.getChannels()
        .stream()
        .map(channel -> channel.asTextChannel().isPresent() ?
            new JavacordTextChannel(channel.asTextChannel().get()) :
            new JavacordVoiceChannel(channel.asVoiceChannel().get()))
        .collect(Collectors.toList());
  }

  @Override
  public List<DiscordTextChannel> getTextChannels() {
    return server.getTextChannels()
        .stream()
        .map(channel -> new JavacordTextChannel(channel))
        .collect(Collectors.toList());
  }

  @Override
  public List<DiscordVoiceChannel> getVoiceChannels() {
    return server.getVoiceChannels()
        .stream()
        .map(channel -> new JavacordVoiceChannel(channel))
        .collect(Collectors.toList());  }

  @Override
  public List<DiscordRole> getRoles() {
    return server.getRoles()
        .stream()
        .map(role -> new JavacordRole(role))
        .collect(Collectors.toList());
  }
}
