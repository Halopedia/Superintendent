package superintendent.adapters.discord;

import java.util.List;

import superintendent.adapters.discord.channels.DiscordChannel;
import superintendent.adapters.discord.channels.DiscordTextChannel;
import superintendent.adapters.discord.channels.DiscordVoiceChannel;

public interface DiscordServer {
  
  /**
   * Gets the name of the Discord server represented by this object.
   * 
   * @return the name of the server
   */
  public String getName();
  
  /**
   * Gets a list of DiscordChannels representing all the channels on the server
   * represented by this object.
   * 
   * @return a list of all the channels on the server
   */
  public List<DiscordChannel> getChannels();
  
  /**
   * Gets a list of DiscordTextChannels representing all the text channels on
   * the server represented by this object.
   * 
   * @return a list of all the text channels on the server
   */
  public List<DiscordTextChannel> getTextChannels();
  
  /**
   * Gets a list of DiscordVoiceChannels representing all the voice channels on
   * the server represented by this object.
   * 
   * @return a list of all the voice channels on the server
   */
  public List<DiscordVoiceChannel> getVoiceChannels();
  
  /**
   * Gets a list of all the DiscordRoles on the Discord server represented by
   * this object. This list will be ordered in decreasing order of precedence.
   * 
   * @return a list of all the roles on this server
   */
  public List<DiscordRole> getRoles();

}
