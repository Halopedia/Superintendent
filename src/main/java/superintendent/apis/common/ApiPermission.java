package superintendent.apis.common;

public interface ApiPermission {
  
  /**
   * Returns true if and only if the bot has the permission associated with
   * this class.
   * 
   * @return true iff the bot has the permission
   */
  public boolean hasPermission();

}
