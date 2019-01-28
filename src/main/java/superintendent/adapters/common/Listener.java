package superintendent.adapters.common;

public interface Listener<T extends ApiEvent> {
  
  /**
   * This method is called every time a given event takes place, unless another
   * object consumes the event first.
   * 
   * @param event the event which triggered the listener
   */
  public void heard(T event);

}
