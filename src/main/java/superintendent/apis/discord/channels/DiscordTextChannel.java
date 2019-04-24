package superintendent.apis.discord.channels;

import java.util.List;

import superintendent.apis.discord.DiscordMessage;
import superintendent.apis.discord.InsufficientPermissionsException;

public interface DiscordTextChannel extends DiscordChannel {
  
  static final int DEFAULT_PREV_MESSAGE_LIST_SIZE = 50;
  
  /**
   * Gets a list of previous DiscordMessages posted in the channel, with the
   * default number of entries. This list will be ordered from most to least
   * recent.
   * 
   * @return a list of messages
   */
  public default List<DiscordMessage> getPreviousMessages() {
    return getPreviousMessages(DEFAULT_PREV_MESSAGE_LIST_SIZE);
  };
  
  /**
   * Gets a list of previous DiscordMessages posted in the channel, with a
   * specified number of entries. This list will be ordered from most to least
   * recent.
   * 
   * @param numOfMessages the number of messages to get
   * @return a list of messages
   */
  public List<DiscordMessage> getPreviousMessages(int numOfMessages);
  
  /**
   * Posts a message with the given content on the channel.
   * 
   * @param content the text content of the message
   * @throws InsufficientPermissionsException if the bot can't post here
   */
  public void post(String content) throws InsufficientPermissionsException;
  
  @Override
  public default boolean isTextChannel() {
    return false;
  }
  
  @Override
  public default boolean isVoiceChannel() {
    return true;
  }

}
