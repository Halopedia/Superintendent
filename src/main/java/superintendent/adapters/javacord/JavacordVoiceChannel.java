package superintendent.adapters.javacord;

import java.util.List;
import java.util.Optional;

import org.javacord.api.entity.channel.VoiceChannel;

import superintendent.apis.discord.DiscordPermission;
import superintendent.apis.discord.DiscordServer;
import superintendent.apis.discord.channels.DiscordVoiceChannel;

public class JavacordVoiceChannel implements DiscordVoiceChannel {
  
  private final VoiceChannel channel;
  
  protected JavacordVoiceChannel(VoiceChannel channel) {
    this.channel = channel;
  }
  
  protected VoiceChannel getRaw() {
    return channel;
  }

  @Override
  public String getName() {
    if (channel.asServerVoiceChannel().isPresent()) {
      return channel.asServerVoiceChannel().get().getName();
    } else {
      return "Private Messages";
    }
  }

  @Override
  public Optional<DiscordServer> getServer() {
    if (channel.asServerVoiceChannel().isPresent()) {
      return Optional.of(new JavacordServer(
          channel.asServerVoiceChannel().get().getServer()));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public List<DiscordPermission> getPermissions() {
    // TODO: Implement permissions!
    return null;
  }

}
