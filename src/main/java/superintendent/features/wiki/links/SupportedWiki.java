package superintendent.features.wiki.links;

public interface SupportedWiki {
  
  /**
   * Returns the name of the supported wiki represented by this object.
   * 
   * @return the name of the wiki
   */
  public String getName();
  
  /**
   * Returns the base URL of the wiki, which can be used to construct the URLs
   * of pages on the wiki by appending the name of the page.
   * 
   * @return the base URL of the wiki
   */
  public String getBaseUrl();
  
  /**
   * Returns the link prefix that indicates the link should lead to this wiki.
   * If the prefix is terminated by a colon, this should be included in the
   * string itself. The link prefix is not case sensitive - thus, "Wikipedia:"
   * should be interpreted as identical to "WIKIPEDIA:". If the wiki is intended
   * to be the default wiki, it should return an empty string for the link
   * prefix.
   * 
   * @return the link prefix
   */
  public String getPrefix();

}
