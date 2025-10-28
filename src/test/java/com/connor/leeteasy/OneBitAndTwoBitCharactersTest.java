package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneBitAndTwoBitCharactersTest {

    @Test
    void testOneBitCharacter() {
        assertFalse(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,0}));
        assertTrue(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{0,0}));
        assertFalse(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,1,1,0}));
        assertTrue(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,0,0}));
    }

}