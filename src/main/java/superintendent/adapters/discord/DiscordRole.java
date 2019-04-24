package superintendent.adapters.discord;

import java.util.List;

public interface DiscordRole {
  
  /**
   * Gets the name of the role.
   * 
   * @return the name of the role
   */
  public String getName();
  
  /**
   * Gets the DiscordServer where the role exists.
   * 
   * @return the server where the role exists
   */
  public DiscordServer getServer();
  
  /**
   * Gets a list of DiscordPermissions that the role grants.
   * 
   * @return a list of permissions granted by the role
   */
  public List<DiscordPermission> getPermissions();
  
  /**
   * Gets a list of all the DiscordUsers with this role
   * 
   * @return a list of all users with the role
   */
  public List<DiscordUser> getUsers();

}
