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
        computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain(brain)
                .build();
        guess = computer.guessWhat(someTokenIWant);
        return this;
    }

    public ComputerAsserter messageIsPresent() {
        assert guess != null;

        assertNotNull(guess.message());
        return this;
    }
    public ComputerAsserter messageIs(String expectedMessage) {
        assert guess != null;

        assertEquals(expectedMessage, guess.message());
        return this;
    }

    public ComputerAsserter resultIsNotEmpty() {
        assert guess != null;

        assertNotNull(guess.guess());
        return this;
    }

    public ComputerAsserter resultIsEmpty() {
        assert guess != null;

        assertNull(guess.guess());
        return this;
    }

    public ComputerAsserter evidencesAreOk() {
        assert guess != null;
        assertFalse(Double.isNaN(guess.alpha()));
        assertFalse(Double.isNaN(guess.beta()));
        assertFalse(Double.isNaN(guess.gamma()));

        assertEquals(1.0, guess.alpha() + guess.beta() + guess.gamma(), 0.001);
        return this;
    }

    public ComputerAsserter evidencesAreInfinite() {
        assert guess != null;
        assertTrue(Double.isNaN(guess.alpha()));
        return this;
    }
}
