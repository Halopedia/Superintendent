package superintendent;

import superintendent.adapters.javacord.Javacord;
import superintendent.apis.discord.DiscordServer;
import superintendent.features.Feature;
import superintendent.features.SupportedFeatures;

public class Main {

  public static final String PROGRAM_NAME = "Superintendent";
  public static final String VERSION_NICKNAME = "Alpha";
  public static final int VERSION_NUMBER = 0;
  public static final int PATCH_NUMBER = 1;
  public static final String VERSION_NAME = VERSION_NICKNAME + " ("
      + VERSION_NUMBER + '.' + PATCH_NUMBER + ')';
  
  public static final String TOKEN = "TODO: Replace this with token!";

  public static void main(String[] args) {
    System.out.println("Starting " + PROGRAM_NAME + " - " + VERSION_NAME);
    Javacord api = new Javacord();
    api.login(TOKEN);
    for (SupportedFeatures f : SupportedFeatures.values()) {
      Feature feature = f.get();
      feature.init();
      for (DiscordServer server : api.getServers()) {
        feature.initServer(server);
      }
      if (feature.getMessageListener().isPresent()) {
        System.out.println("Adding message listener for " + feature.getName());
        api.addGlobalMessageCreateListener(feature.getMessageListener().get());
      }
    }
  }

}
