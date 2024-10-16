package org.example;


import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyLLMMagicComputerTest {
    @Test
    public void testSomething_HappyPath() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat("Some token I want");
        assertEquals("Perfect", guess.message());
        assertEquals("some token i want", guess.guess());
        assertEquals(0.5, guess.alpha());
        assertEquals(0.25, guess.beta());
        assertEquals(0.25, guess.gamma());
    }

    @Test
    public void testSomething_Hacked() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat(null);
        assertEquals("You tried to hacked me", guess.message());
        assertNull(guess.guess());
        assertEquals(Double.NaN, guess.alpha());
        assertEquals(Double.NaN, guess.beta());
        assertEquals(Double.NaN, guess.gamma());
    }

    @Test
    public void testSomething_NotEnoughInputs() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat(" ");
        assertEquals("No much stuff to work on", guess.message());
        assertNull(guess.guess());
        assertEquals(Double.NaN, guess.alpha());
        assertEquals(Double.NaN, guess.beta());
        assertEquals(Double.NaN, guess.gamma());
    }

    @Test
    public void testSomething_You_forgot_to_give_something_to_eat() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat("");
        assertEquals("You could be smarter", guess.message());
        assertNull(guess.guess());
        assertEquals(Double.NaN, guess.alpha());
        assertEquals(Double.NaN, guess.beta());
        assertEquals(Double.NaN, guess.gamma());
    }

    @Test
    public void testSomething_lack_of_imagination() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat("yellow stones are yellow");
        assertEquals("You could use upper cases sometime", guess.message());
        assertEquals("yellow stones are yellow", guess.guess());
        assertEquals(1.0, guess.alpha());
        assertEquals(0., guess.beta());
        assertEquals(0., guess.gamma());
    }

    @Test
    public void testSomething_lack_of_surprise() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat("YELLOW STONES ARE YELLOW");
        assertEquals("You could use lower cases sometime", guess.message());
        assertEquals("YELLOW STONES ARE YELLOW", guess.guess());
        assertEquals(0.0, guess.alpha());
        assertEquals(1.0, guess.beta());
        assertEquals(0., guess.gamma());
    }

    @Test
    public void testSomething_jack_daniels() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat("You love Jack Daniels");
        assertEquals("Perfect Jack", guess.message());
        assertEquals("you love jack daniels", guess.guess());
        assertEquals(0.25, guess.alpha());
        assertEquals(0.25, guess.beta());
        assertEquals(0.5, guess.gamma());
    }

    @Test
    public void testSomething_jack_daniels_bis() {
        MyLLMMagicComputer computer = MyLLMMagicComputer.builder()
                .useUrl("http://themagicbrain.io/demo")
                .useApiKey(UUID.fromString("1a139f7e-7e97-44fc-8321-3db48c3c0cdc"))
                .useBrain("io/1-sp3")
                .build();

        Guess guess = computer.guessWhat("You love Jack Daniels or Jack eChan");
        assertEquals("Jack lacks of humility", guess.message());
        assertEquals("you love jack daniels or jack echan", guess.guess());
        assertEquals(0.25, guess.alpha());
        assertEquals(0.5, guess.beta());
        assertEquals(0.25, guess.gamma());
    }
}
