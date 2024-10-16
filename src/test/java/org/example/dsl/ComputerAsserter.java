package org.example.dsl;


import org.example.Guess;
import org.example.MyLLMMagicComputer;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerAsserter {
    private String brain;
    private MyLLMMagicComputer computer;
    private Guess guess;

    public static ComputerAsserter assertThatWhenCalled() {
        return new ComputerAsserter();
    }

    public ComputerAsserter withBrain(String brain) {
        this.brain = brain;
        return this;
    }

    public ComputerAsserter on(String someTokenIWant) {
         // TODO !!!!
        return this;
    }

    public ComputerAsserter messageIsPresent() {
        assert guess != null;

        // TODO !!!!
        return this;
    }
    public ComputerAsserter messageIs(String expectedMessage) {
        assert guess != null;

        // TODO !!!!
        return this;
    }

    public ComputerAsserter resultIsNotEmpty() {
        assert guess != null;

        // TODO !!!!
        return this;
    }

    public ComputerAsserter resultIsEmpty() {
        assert guess != null;

        // TODO !!!!
        return this;
    }

    public ComputerAsserter evidencesAreOk() {
        assert guess != null;

        // TODO !!!!
        return this;
    }

    public ComputerAsserter evidencesAreInfinite() {
        assert guess != null;
        // TODO !!!!
        return this;
    }
}
