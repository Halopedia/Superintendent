package superintendent.adapters.discord;

import superintendent.adapters.common.ApiPermission;
import superintendent.adapters.discord.channels.DiscordChannel;

public interface DiscordPermission extends ApiPermission {
  
  /**
   * Returns the name of the permission represented by this object.
   * 
   * @return the name of the permission
   */
  public String getName();
  
  /**
   * Returns true if and only if the bot has the permission associated with
   * this object, on a given DiscordServer.
   * 
   * @param server the server on which the permissions are to be checked
   * @return true iff the bot has the permission on the server
   */
  public boolean hasPermissionOnServer(DiscordServer server);
  
  /**
   * Returns true if and only if the bot has the permission associated with
   * this object, in a given DiscordChannel.
   * 
   * @param channel the channel in which the permissions are to be checked
   * @return true iff the bot has the permission on the channel
   */
  public boolean hasPermissionInChannel(DiscordChannel channel);
  
  /**
   * Returns true if and only if the given DiscordUser has this permission on
   * the given DiscordServer.
   * 
   * @param user the user whose permissions are being checked
   * @param server the server on which the permissions are to be checked
   * @return true iff the user has the permission in the server
   */
  public boolean userHasPermissionOnServer(DiscordUser user,
      DiscordServer server);
  
  /**
   * Returns true if and only if the given DiscordUser has this permission in
   * the given DiscordChannel.
   * 
   * @param user the user whose permissions are being checked
   * @param channel the channel in which the permissions are to be checked
   * @return true iff the user has the permission in the server
   */
  public boolean userHasPermissionInChannel(DiscordUser user,
      DiscordChannel channel);
}
