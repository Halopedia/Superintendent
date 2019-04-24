package superintendent.adapters.discord;

import java.util.List;
import java.util.Map;

import superintendent.adapters.discord.channels.DiscordTextChannel;

public interface DiscordMessage {
  
  /**
   * Returns the text content of the message as a String.
   * 
   * @return the content of the message
   */
  public String getText();
  
  /**
   * Returns a DiscordUser object representing the user who wrote the message.
   * 
   * @return the user who wrote the message
   */
  public DiscordUser getAuthor();
  
  /**
   * Returns a DiscordTextChannel object representing the channel where the
   * message was posted.
   * 
   * @return the channel where the message was posted
   */
  public DiscordTextChannel getChannel();
  
  /**
   * Returns a list of DiscordEmoticon objects representing all the reactions to
   * the message.
   * 
   * @return a list of all the reactions to the message.
   */
  public List<DiscordEmoticon> getReactions();

  /**
   * Returns a map from DiscordEmoticons to the DiscordUsers who reacted with
   * those emoticons.
   * 
   * @return a map from DiscordEmoticons to DiscordUsers
   */
  public Map<DiscordEmoticon, List<DiscordUser>> getReactors();
  
  /**
   * Adds a DiscordEmoticon as a reaction to the message.
   * 
   * @param reaction the DiscordEmoticon to react with
   * @throws InsufficientPermissionsException if the bot isn't allowed to react
   */
  public void addReaction(DiscordEmoticon reaction)
      throws InsufficientPermissionsException;
  
  /**
   * Deletes the message, so that it will no longer be visible.
   * 
   * @throws InsufficientPermissionsException if the bot isn't allowed to delete
   */
  public void delete() throws InsufficientPermissionsException;
}
