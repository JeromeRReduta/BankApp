package views.pages;

import views.pages.Page;

public abstract class AbstractPageRouter<E> {

    private E model;

    public AbstractPageRouter(E model) {
        this.model = model;
    }

    public void loadPage(Page<E> page) {
        page.renderUsing(model);
    }

}
