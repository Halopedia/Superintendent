package superintendent.adapters.common;

import java.util.Arrays;
import java.util.Collection;

public interface Listenable<T extends ApiEvent> {
  
  /**
   * Adds a listener to be notified when an event takes place, unless some
   * other object consumes the event beforehand.
   * 
   * @param listener the listener add
   */
  public void addListener(Listener<T> listener);

  /**
   * Adds a number of listeners, which will each be notified when an event
   * takes place, unless some object consumes the event beforehand.
   * 
   * @param listeners the listeners to add
   */
  public default void addListeners(Collection<Listener<T>> listeners) {
    for (Listener<T> listener : listeners) {
      addListener(listener);
    }
  }
  
  /**
   * Adds a number of listeners, which will each be notified when an event
   * takes place, unless some object consumes the event beforehand.
   * 
   * @param listeners the listeners to add
   */
  public default void addListeners(Listener<T>[] listeners) {
    addListeners(Arrays.asList(listeners));
  }
}
