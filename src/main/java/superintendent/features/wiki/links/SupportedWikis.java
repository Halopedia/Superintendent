package superintendent.features.wiki.links;

public enum SupportedWikis implements SupportedWiki {
  
  WIKIPEDIA("Wikipedia", "Wikipedia:", "https://en.wikipedia.org/wiki/"),
  MEDIAWIKI("MediaWiki", "mw:", "https://www.mediawiki.org/wiki/"),
  WIKIA("Wikia", "w:c:", "https://community.wikia.com/wiki/w:c:"),
  HALOPEDIA("Halopedia", "", "https://www.halopedia.org/");
  
  public static final SupportedWiki DEFAULT = HALOPEDIA;
  
  private final String name;
  private final String prefix;
  private final String url;
  
  private SupportedWikis(String name, String prefix, String url) {
    this.name = name;
    this.prefix = prefix;
    this.url = url;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getBaseUrl() {
    return url;
  }

  @Override
  public String getPrefix() {
    return prefix;
  }

}
