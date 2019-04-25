package superintendent.apis.discord;

import java.util.List;

import superintendent.apis.discord.channels.DiscordTextChannel;

public interface DiscordUser {
  
  /**
   * Gets the full username of the user represented by this object.
   * 
   * @return the user's username
   */
  public String getUsername();
  
  /**
   * Gets the nickname used by the user in a given DiscordServer.
   * 
   * @param server the server in which to check the user's nickname
   * @return the user's nickname
   */
  public String getNickname(DiscordServer server);
  
  /**
   * Gets the string used to tag the user in a message.
   * 
   * @return the string used to tag the user
   */
  public String getTag();
  
  /**
   * Gets a DiscordChannel object representing the private message channel
   * between the bot and the user.
   * 
   * @return the DiscordChannel representing PMs between the bot and user
   * @throws InsufficientPermissionsException if the user does not accept PMs
   */
  public DiscordTextChannel getPmChannel()
      throws InsufficientPermissionsException;
  
  /**
   * Gets a list of DiscordServer objects representing all the servers that the
   * user and bot are both simultaneously in.
   * 
   * @return a list of DiscordServers that both the bot and user are in
   */
  public List<DiscordServer> getCommonServers();
  
  /**
   * Gets a list of DiscordRoles representing the roles that the user has on a
   * given server.
   * 
   * @param server the server to check
   * @return a list of DiscordRoles that the user has
   */
  public List<DiscordRole> getRoles(DiscordServer server);
  
  /**
   * Returns true if and only if the user is the owner of the bot.
   * 
   * @return true iff the user is the bot's owner
   */
  public boolean isBotOwner();
  
  /**
   * Returns true if and only if the user is a bot.
   * 
   * @return true iff the user is a bot
   */
  public boolean isBot();
  
  /**
   * Returns true if and only if the user is an admin on the given
   * DiscordServer.
   * 
   * @return true iff the user is an admin on the server
   */
  public boolean isAdminOnServer(DiscordServer server);
  
  /**
   * Returns true if and only if the user is on the bot's friend list.
   * 
   * @return true iff the user is a friend of the bot's
   */
  public boolean isFriend();
  
  /**
   * Accepts a friend request from the user if one exists, or otherwise sends
   * one.
   */
  public void addAsFriend();
  
  /**
   * Removes the user from the bot's friend list, if the user is on it.
   */
  public void removeAsFriend();

}
