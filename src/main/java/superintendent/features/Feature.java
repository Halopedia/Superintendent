package superintendent.features;

import java.util.Optional;
import java.util.Set;

import superintendent.apis.common.ApiPermission;
import superintendent.apis.common.Listener;
import superintendent.apis.common.events.CreateEvent;
import superintendent.apis.discord.DiscordMessage;
import superintendent.apis.discord.DiscordServer;

public interface Feature {
  
  public static final String DEFAULT_CATEGORY = "miscellaneous";

      /* FEATURE INFO */
  
  /**
   * Returns the name of the feature. Defaults to class name if not specified.
   * 
   * @return the feature's name
   */
  public String getName();
  
  /**
   * Returns the version number of the feature. Negative version numbers will
   * be treated as unknown versions.
   * 
   * @return the version number
   */
  public int getVersionNum();
  
  /**
   * Returns the patch number of the feature. This should be reset to zero when
   * a new version of the feature is released. Negative numbers will be treated
   * as unknown numbers.
   * 
   * @return the patch number
   */
  public int getPatchNum();
  
  /**
   * Gets the category the feature is in.
   * 
   * @return the feature's category
   */
  public FeatureCategory getCategory();
  
  /**
   * Gets a brief description of the feature's function. This must be between
   * three and 100 characters in length.
   * 
   * @return a description of the feature
   */
  public String getDescription();
  
  /**
   * Returns true if and only if a feature is enabled by default when the bot
   * joins a new server.
   * 
   * @return true iff the feature should be enabled by default
   */
  public boolean isEnabledByDefault();
  
  /**
   * Returns true if and only if a feature should be possible to manually
   * disable. If this method is not overridden, it will default to true.
   * 
   * @return true iff the feature can be disabled
   */
  public default boolean canBeDisabled() {
    return true;
  }
  
      /* FEATURE PERMISSIONS */
  
  /**
   * Gets a set of minimum permissions that the feature requires in order to
   * function as intended.
   * 
   * @return a set of permissions required for the feature to work
   */
  public Set<ApiPermission> getMinPermissions();
  
  /**
   * Gets a set of permissions that the feature ideally should have in order
   * to function at its best. Defaults to the minimum permissions if not set.
   * 
   * @return a set of ideal permissions
   */
  public default Set<ApiPermission> getIdealPermissions() {
    return getMinPermissions();
  }
  
  /**
   * Handles any initialisation necessary for the feature to work as intended.
   * This function is called once during the life cycle of a Feature instance.
   * If initialisation fails, the feature will be disabled until either it or
   * the bot is rebooted. No actions will be performed if this method is not
   * overridden.
   * 
   * @return true if and only if initialisation was successful
   */
  public default boolean init() {
    return true;
  }

  /**
   * Handles any initialisation necessary when the feature is first added to a
   * Discord server.  If initialisation fails, the feature will be
   * automatically disabled for the server. No actions will be performed if
   * this method is not overridden.
   * 
   * @param server the Discord server the feature is added to
   * @return true if and only if the initialisation succeeded
   */
  public default boolean initServer(DiscordServer server) {
    return true;
  }
  
  /**
   * Optionally gets a DiscordMessageListener that will be called for every
   * message to every Discord channel where the bot has the necessary
   * permissions to run the feature, and the feature is enabled. If the feature
   * does not need to listen to messages, it should return an empty Optional.
   * If this function is not overridden, it will return an empty Optional.
   * 
   * @return an optional DiscordMessageListener to listen for messages
   */
  public default Optional<Listener<CreateEvent<DiscordMessage>>>
      getMessageListener() {
    return Optional.empty();
  }
}
