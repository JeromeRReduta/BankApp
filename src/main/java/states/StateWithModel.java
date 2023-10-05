package states;

public interface StateWithModel<E> {

    void handle(StateContextWithModel<E> context);

}
