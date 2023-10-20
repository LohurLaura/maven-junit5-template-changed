package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SolverClassTest {
    @Test
    void testNoRoots() {
        SolverClass solver = new SolverClass();
        int result = SolverClass.equations(1, 1, 1);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testOneRoot() {
        SolverClass solver = new SolverClass();
        int result = SolverClass.equations(0, 0, 0);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testTwoRoots() {
        SolverClass solver = new SolverClass();
        int result = SolverClass.equations(2, 5, 2);
        Assertions.assertEquals(2, result);
    }
}

