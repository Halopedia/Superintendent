package superintendent.apis.discord;

import java.util.List;

import superintendent.apis.common.Listener;
import superintendent.apis.common.events.CreateEvent;

public interface DiscordApi {
  
  /**
   * Logs in to Discord using the given token.
   * 
   * @param token the token of the bot account to log in with
   */
  public void login(String token);
  
  /**
   * Logs out of Discord.
   */
  public void logout();
  
  /**
   * Returns true if and only if the bot is currently logged in.
   * 
   * @return true iff the bot is logged in
   */
  public boolean loggedIn();
  
  /**
   * Gets a DiscordUser object representing the bot itself.  This can only be
   * done while the bot is logged in.
   * 
   * @return a DiscordUser representing the bot
   */
  public DiscordUser getSelf();
  
  /**
   * Gets a DiscordUser object representing the owner of the bot.  This can only
   * be done while the bot is logged in.
   * 
   * @return a DiscordUser representing the bot's owner
   */
  public DiscordUser getOwner();
  
  /**
   * Gets a list of all the DiscordServers the bot is in. This can only be done
   * while the bot is logged in.
   * 
   * @return a list of all the DiscordServers the bot is in
   */
  public List<DiscordServer> getServers();
  
  /**
   * Gets a list of DiscordUsers representing all of the users on the bot's
   * friend list. This can only be done while the bot is logged in.
   * 
   * @return a list of all the users the bot is friends with
   */
  public List<DiscordUser> getFriends();
  
  /**
   * Adds a global listener for message creation events.  This can only be done
   * while the bot is logged in.
   * 
   * @param listener the listener to add
   */
  public void addGlobalMessageCreateListener(
      Listener<CreateEvent<DiscordMessage>> listener);

}
