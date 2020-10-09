package com.testing.module3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    BowlingGame theGame;

    @BeforeEach
    void setUp() {
        theGame = new BowlingGame();
    }

    @Test
    void shouldScoreOneWhenNoRolls() {
        assertThat(theGame.getScore()).isEqualTo(0);
    }

    @Test
    void shouldScore0WhenNoPinDown20Times() {
        roll(20, 0);
        assertThat(theGame.getScore()).isEqualTo(0);
    }

    @Test
    void shouldScore20WhenOnePinDown20Times() {
        roll(20, 1);
        assertThat(theGame.getScore()).isEqualTo(20);
    }

    @Test
    void shouldScoreSpare() {
        roll(2,5);
        roll(1,4);
        roll(17,0);
        assertThat(theGame.getScore()).isEqualTo(18);
    }

    @Test
    void shouldScoreStrike() {
        roll(1,10);
        roll(2,4);
        roll(16,0);

        assertThat(theGame.getScore()).isEqualTo(26);
    }

    private void roll(int numberOfThrows, int pins) {
        for (int i = 0; i < numberOfThrows; i++) {
            theGame.roll(pins);
        }
    }
}