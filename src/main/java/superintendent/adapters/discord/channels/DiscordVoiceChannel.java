package superintendent.adapters.discord.channels;

public interface DiscordVoiceChannel extends DiscordChannel {
  
  @Override
  public default boolean isTextChannel() {
    return false;
  }
  
  @Override
  public default boolean isVoiceChannel() {
    return true;
  }

}
