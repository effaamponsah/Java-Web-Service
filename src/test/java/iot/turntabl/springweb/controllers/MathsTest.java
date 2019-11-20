package iot.turntabl.springweb.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MathsTest {
    private Maths operations = new Maths();

    @Test
    public void addNegs(){
        assertEquals(-2, operations.add(-1,-1));
    }

    @Test
    public void addToZero(){
        assertEquals(1, operations.add(1,0));
    }


}