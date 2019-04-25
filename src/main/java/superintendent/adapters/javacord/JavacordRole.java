package superintendent.adapters.javacord;

import java.util.List;
import java.util.stream.Collectors;

import org.javacord.api.entity.permission.Role;

import superintendent.apis.discord.DiscordPermission;
import superintendent.apis.discord.DiscordRole;
import superintendent.apis.discord.DiscordServer;
import superintendent.apis.discord.DiscordUser;

public class JavacordRole implements DiscordRole {
  
  private final Role role;
  
  protected JavacordRole(Role role) {
    this.role = role;
  }

  protected Role getRaw() {
    return role;
  }

  @Override
  public String getName() {
    return role.getName();
  }

  @Override
  public DiscordServer getServer() {
    return new JavacordServer(role.getServer());
  }

  @Override
  public List<DiscordPermission> getPermissions() {
    // TODO: Implement permissions!
    return null;
  }

  @Override
  public List<DiscordUser> getUsers() {
    return role.getUsers()
        .stream()
        .map(user -> new JavacordUser(user))
        .collect(Collectors.toList());
  }

}
