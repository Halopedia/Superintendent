package superintendent.features;

public enum FeatureCategory {
  
  CORE("Core"),
  UTILITY("Utility"),
  WIKI("Wiki"),
  FUN("Entertainment"),
  MODERATION("Moderation"),
  MISCELLANEOUS("Miscellaneous");

  private final String name;
  
  private FeatureCategory(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
}
