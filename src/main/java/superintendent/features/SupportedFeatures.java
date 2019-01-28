package superintendent.features;

import superintendent.features.core.commands.Commands;
import superintendent.features.wiki.links.WikiLinks;

public enum SupportedFeatures {
  
      /* CORE FEATURES */
  COMMANDS(new Commands()),
  
      /* UTILITY FEATURES */
  
      /* WIKI FEATURES */
  WIKILINKS(new WikiLinks());
  
      /* FUN FEATURES */
  
      /* MODERATION FEATURES */
  
      /* MISCELLANEOUS FEATURES */
  
  private final Feature feature;
  
  private SupportedFeatures(Feature feature) {
    this.feature = feature;
  }
  
  public Feature get() {
    return feature;
  }

}
