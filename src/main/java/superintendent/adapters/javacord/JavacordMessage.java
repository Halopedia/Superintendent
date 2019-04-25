package superintendent.adapters.javacord;

import java.util.List;
import java.util.Map;

import org.javacord.api.entity.message.Message;

import superintendent.apis.discord.DiscordEmoticon;
import superintendent.apis.discord.DiscordMessage;
import superintendent.apis.discord.DiscordUser;
import superintendent.apis.discord.InsufficientPermissionsException;
import superintendent.apis.discord.channels.DiscordTextChannel;

public class JavacordMessage implements DiscordMessage {
  
    private final Message message;
    
    protected JavacordMessage(Message message) {
      this.message = message;
    }

    protected Message getRaw() {
      return message;
    }

    @Override
    public String getText() {
      return message.getContent();
    }

    @Override
    public DiscordUser getAuthor() {
      return new JavacordUser(message.getAuthor().asUser().get());
    }

    @Override
    public DiscordTextChannel getChannel() {
      return new JavacordTextChannel(message.getChannel());
    }

    @Override
    public List<DiscordEmoticon> getReactions() {
      // TODO: Implement emoticons!
      return null;
    }

    @Override
    public Map<DiscordEmoticon, List<DiscordUser>> getReactors() {
   // TODO: Implement emoticons!
      return null;
    }

    @Override
    public void addReaction(DiscordEmoticon reaction) throws InsufficientPermissionsException {
   // TODO: Implement emoticons!
    }

    @Override
    public void delete() throws InsufficientPermissionsException {
      message.delete().join();
    }

}
