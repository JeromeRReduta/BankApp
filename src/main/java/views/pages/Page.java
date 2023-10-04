package views.pages;

public interface Page<E> {

    void renderUsing(E model);
}
