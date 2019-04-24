package superintendent.adapters.common.events;

import superintendent.adapters.common.ApiEvent;

public class DestroyEvent<T> extends ApiEvent {
  
  private final T trigger;
  
  /**
   * Creates an event representing the destruction or deletion of a given
   * object.
   * 
   * @param trigger the object whose destruction triggered the event
   */
  public DestroyEvent(T trigger) {
    this.trigger = trigger;
  }
  
  /**
   * Gets the object whose destruction or deletion triggered the event.
   * 
   * @return the object whose destruction triggered the event.
   */
  public T getTrigger() {
    return trigger;
  }


}
