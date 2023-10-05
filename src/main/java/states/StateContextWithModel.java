package states;

public interface StateContextWithModel<E> {

    void run();

    void close();

    StateWithModel<E> getState();

    void setState(StateWithModel<E> state);

    E getModel();
}
