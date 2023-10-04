package controllers;

import models.BankAccount;
import views.BankAccountView;

import java.util.Scanner;

public abstract class AbstractBankAccountFiniteStateMachine {

    private State current;

    public enum State {

        LOGIN {
            @Override
            public void enter(BankAccountView view) {
                view.displayLoginPage();
            }

            @Override
            public State update(Scanner scan) {
                while (true) {
                    System.out.println("Username:");
                    String input = scan.nextLine().trim();

                }
            }


        },

        DISPLAY {

            @Override
            public void enter(BankAccountView view) {
                view.displayDisplayPage();
            }

            @Override
            public State update(Scanner scan) {
                System.out.println("Enter any input to go back to menu page:");
                String input = scan.nextLine();
                return MENU;
                }
            },

        MENU {

        }

        public abstract void enter(BankAccountView view);

        public abstract State update(Scanner scan);
    };

    private final BankAccountView view;

    public AbstractBankAccountFiniteStateMachine(BankAccountView view) {
        this.view = view;
        this.current = State.LOGIN;
    }

    public void run() {
        while (current != State.EXIT) {
            current.enter();
            current = current.update();
        }
        /* Final state run - for when we're exiting */
        current.enter();
        current.update();
    }

}
