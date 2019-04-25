package superintendent.adapters.javacord;

import java.util.List;
import java.util.stream.Collectors;

import org.javacord.api.entity.user.User;

import superintendent.apis.discord.DiscordRole;
import superintendent.apis.discord.DiscordServer;
import superintendent.apis.discord.DiscordUser;
import superintendent.apis.discord.InsufficientPermissionsException;
import superintendent.apis.discord.channels.DiscordTextChannel;

public class JavacordUser implements DiscordUser {
  
  private final User user;
  
  protected JavacordUser(User user) {
    this.user = user;
  }
  
  protected User getRaw() {
    return user;
  }

  @Override
  public String getUsername() {
    return user.getName();
  }

  @Override
  public String getNickname(DiscordServer server) {
    return user.getDisplayName(((JavacordServer) server).getRaw());
  }

  @Override
  public String getTag() {
    return user.getMentionTag();
  }

  @Override
  public DiscordTextChannel getPmChannel()
      throws InsufficientPermissionsException {
    return new JavacordTextChannel(user.openPrivateChannel().join());
  }

  @Override
  public List<DiscordServer> getCommonServers() {
    return user.getMutualServers()
        .stream()
        .map(server -> new JavacordServer(server))
        .collect(Collectors.toList());
  }

  @Override
  public List<DiscordRole> getRoles(DiscordServer server) {
    return user.getRoles(((JavacordServer) server).getRaw())
        .stream()
        .map(role -> new JavacordRole(role))
        .collect(Collectors.toList());
  }

  @Override
  public boolean isBotOwner() {
    return user.isBotOwner();
  }

  @Override
  public boolean isBot() {
    return user.isBot();
  }
  
  @Override
  public boolean isAdminOnServer(DiscordServer server) {
    return ((JavacordServer) server).getRaw().isAdmin(user);
  }

  @Override
  public boolean isFriend() {
    // TODO: Implements friends!
    return false;
  }

  @Override
  public void addAsFriend() {
    // TODO: Implements friends!
  }

  @Override
  public void removeAsFriend() {
    // TODO: Implements friends!
  }

}
