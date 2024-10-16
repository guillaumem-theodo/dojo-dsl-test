package org.example.dsl;


import org.junit.jupiter.api.Test;

class AnotherWayOfTestingMyLLMMagicComputerTest {
    @Test
    public void testSomething_HappyPath() {

        ComputerAsserter.assertThatWhenCalled()
                .withBrain("io/1-sp3")
                .on("Some token I want")
                .messageIsPresent()
                .messageIs("Perfect")
                .resultIsNotEmpty()
                .evidencesAreOk();

    }

    @Test
    public void testSomething_Hacked() {
        ComputerAsserter.assertThatWhenCalled()
                .on(null)
                .messageIsPresent()
                .messageIs("You tried to hacked me")
                .resultIsEmpty()
                .evidencesAreInfinite();
    }

    @Test
    public void testSomething_NotEnoughInputs() {

        ComputerAsserter.assertThatWhenCalled()
                .on(" ")
                .messageIsPresent()
                .messageIs("No much stuff to work on")
                .resultIsEmpty()
                .evidencesAreInfinite();
    }

    @Test
    public void testSomething_You_forgot_to_give_something_to_eat() {

        ComputerAsserter.assertThatWhenCalled()
                .on("")
                .messageIsPresent()
                .messageIs("You could be smarter")
                .resultIsEmpty()
                .evidencesAreInfinite();

    }

    @Test
    public void testSomething_lack_of_imagination() {
        ComputerAsserter.assertThatWhenCalled()
                .on("yellow stones are yellow")
                .messageIsPresent()
                .messageIs("You could use upper cases sometime")
                .resultIsNotEmpty()
                .evidencesAreOk();
    }

    @Test
    public void testSomething_lack_of_surprise() {
        ComputerAsserter.assertThatWhenCalled()
                .on("YELLOW STONES ARE YELLOW")
                .messageIsPresent()
                .messageIs("You could use lower cases sometime")
                .resultIsNotEmpty()
                .evidencesAreOk();

    }

    @Test
    public void testSomething_jack_daniels() {
        ComputerAsserter.assertThatWhenCalled()
                .on("You love Jack Daniels")
                .resultIsNotEmpty()
                .evidencesAreOk();
    }

    @Test
    public void testSomething_jack_daniels_bis() {

        ComputerAsserter.assertThatWhenCalled()
                .on("You love Jack Daniels or Jack e-Chan")
                .resultIsNotEmpty()
                .evidencesAreOk();
    }

}
