package superintendent.features.wiki.links;

public interface LinkType {
  
  /**
   * Returns the name of the type of link represented by this object.
   * 
   * @return the name of the type of link
   */
  public String getName();
  
  /**
   * Returns a regex which should match every instance of this type of link in
   * a body of text, and no other strings. It should include any leading and
   * terminating characters.
   * 
   * @return a regex matching the type of link
   */
  public String getSearchRegex();
  
  /**
   * Returns a regex which should match all of the parts of a link of this
   * type that are superfluous to the meaning. After these parts are removed,
   * all that should be left is the intended destination.
   * 
   * @return a regex matching all superfluous characters in the link
   */
  public String getCleanupRegex();
  
  /**
   * Returns the string name of the default namespace that this type of link
   * should lead to. If the default namespace is the main namespace, then this
   * should return an empty string.
   * 
   * @return the name of the default namespace
   */
  public String getDefaultNamespace();

}
