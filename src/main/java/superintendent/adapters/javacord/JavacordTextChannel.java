package superintendent.adapters.javacord;

import java.util.List;
import java.util.Optional;

import org.javacord.api.entity.channel.TextChannel;

import superintendent.apis.discord.DiscordMessage;
import superintendent.apis.discord.DiscordPermission;
import superintendent.apis.discord.DiscordServer;
import superintendent.apis.discord.InsufficientPermissionsException;
import superintendent.apis.discord.channels.DiscordTextChannel;

public class JavacordTextChannel implements DiscordTextChannel {
  
  private final TextChannel channel;
  
  protected JavacordTextChannel(TextChannel channel) {
    this.channel = channel;
  }

  protected TextChannel getRaw() {
    return channel;
  }

  @Override
  public String getName() {
    if (channel.asServerTextChannel().isPresent()) {
      return channel.asServerTextChannel().get().getName();
    } else {
      return "Private Messages";
    }
  }

  @Override
  public Optional<DiscordServer> getServer() {
    if (channel.asServerTextChannel().isPresent()) {
      return Optional.of(new JavacordServer(
          channel.asServerTextChannel().get().getServer()));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public List<DiscordPermission> getPermissions() {
    // TODO: Implement permissions!
    return null;
  }

  @Override
  public List<DiscordMessage> getPreviousMessages(int numOfMessages) {
    // TODO: Implement getting previous messages!
    return null;
  }

  @Override
  public void post(String content) throws InsufficientPermissionsException {
    channel.sendMessage(content).join();
  }

}
