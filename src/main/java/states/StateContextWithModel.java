package states;

/**
 * Finite state machine for a state with model
 * @param <E> model type
 */
public interface StateContextWithModel<E> {

    /**
     * Runs the context
     */
    void run();

    /**
     * Ends the context. Note that the context will be unusable
     * after calling this method
     */
    void close();

    /**
     * Returns the current state
     * @return current state
     */
    StateWithModel<E> getState();

    /**
     * sets the context's state
     * @param state new state
     */
    void setState(StateWithModel<E> state);

    /**
     * Returns the context's underlying model
     * @return the context's model
     */
    E getModel();
}
