package superintendent.adapters.discord;

import java.util.Optional;

public interface DiscordEmoticon {
  
  /**
   * Gets the name of the emoticon represented by this object.
   * 
   * @return the name of the emoticon
   */
  public String getName();
  
  /**
   * Gets a string that can be used to embed the emoticon in a text message.
   * 
   * @return a string used to embed it in a message
   */
  public String getEmbedString();
  
  /**
   * Gets a DiscordServer object representing the server where this emoticon is
   * available if it is exclusive to a single server, or otherwise returns an
   * empty optional
   * 
   * @return the server this emoticon is exclusive to
   */
  public Optional<DiscordServer> getServer();

}
