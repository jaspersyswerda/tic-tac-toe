package com.jasper;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TTTTest {

    @Test
    public void test(){
        TTT ttt = new TTT();
        ttt.makeBoard();
        assertEquals(9,ttt.getBoard().length);
        assertEquals("5", ttt.getBoard()[4]);
    }


}

