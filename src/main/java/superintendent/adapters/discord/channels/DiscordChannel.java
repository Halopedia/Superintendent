package superintendent.adapters.discord.channels;

import java.util.List;
import java.util.Optional;

import superintendent.adapters.discord.DiscordPermission;
import superintendent.adapters.discord.DiscordServer;

public interface DiscordChannel {
  
  /**
   * Gets the name of the Discord channel represented by this object.
   * 
   * @return the name of the channel
   */
  public String getName();
  
  /**
   * Gets the DiscordServer object representing the server that this channel is
   * a part of, or returns an empty optional if it is not part of a server.
   * 
   * @return the DiscordServer that this channel is part of, if it's part of one
   */
  public Optional<DiscordServer> getServer();
  
  /**
   * Gets a list of DiscordPermission objects representing the permissions which
   * the bot has in this channel.
   * 
   * @return a list of DiscordPermissions that the bot has in the channel
   */
  public List<DiscordPermission> getPermissions();
  
  /**
   * Returns true if and only if the channel is a text channel.
   * 
   * @return true iff the channel is a text channel
   */
  public boolean isTextChannel();
  
  /**
   * Returns true if and only if the channel is a voice channel.
   * 
   * @return true iff the channel is a voice channel
   */
  public boolean isVoiceChannel();

}
