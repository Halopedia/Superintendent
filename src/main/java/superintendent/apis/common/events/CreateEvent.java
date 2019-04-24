package superintendent.apis.common.events;

import superintendent.apis.common.ApiEvent;

public class CreateEvent<T> extends ApiEvent {
  
  private final T trigger;
  
  /**
   * Creates an event representing the creation of a given object.
   * 
   * @param trigger the object whose creation triggered the event
   */
  public CreateEvent(T trigger) {
    this.trigger = trigger;
  }
  
  /**
   * Gets the object whose creation triggered the event.
   * 
   * @return the object whose creation triggered the event.
   */
  public T getTrigger() {
    return trigger;
  }

}
