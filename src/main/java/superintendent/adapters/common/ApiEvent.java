package superintendent.adapters.common;

public abstract class ApiEvent {
  
  private boolean consumed;
  
  protected ApiEvent() {
    consumed = false;
  }
  
  /**
   * Consumes an event so that it cannot be used again by any other listeners
   * or other classes.
   */
  public final void consume() {
    consumed = true;
  }
  
  /**
   * Returns true if and only if the event has been consumed.
   * 
   * @return true iff the event has been consumed
   */
  public final boolean isConsumed() {
    return consumed;
  }

}
