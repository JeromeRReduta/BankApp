package states;

/**
 * Represents a logical state using an underlying data model
 * @param <E> model type
 */
public interface StateWithModel<E> {

    /**
     * Performs some logic, which may or may not use the provided context
     * @param context context
     */
    void handle(StateContextWithModel<E> context);
}
