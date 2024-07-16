package com.bway.springproject;

import com.bway.springproject.testing.Calculation;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculation {
    static Calculation c;

    @BeforeEach
    public void init() {
        c = new Calculation();
    }

    @Test
    public void testArea() {
//        Calculation c = new Calculation();
        int result = c.getArea(20, 10);
        assertEquals(200, result, "success");
    }

    @Test
    public void testSI() {
//        Calculation calc = new Calculation();
        int r = c.getSI(20000, 3, 3);
        assertEquals(1800, r, "success");
    }

    @AfterEach
    public void endMethod(){
        System.out.println("=======Method completed=========");
    }
}
