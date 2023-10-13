package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    void testAddTwoPositiveIntegers(){
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(6,7);
        Assertions.assertEquals(13, sum);
    }

    @Test
    void testAddPositiveIntegerToZero(){
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(5,0);
        Assertions.assertEquals(5, sum);
    }

    @Test
    void testAddNegativeIntegerToAPositiveInteger(){
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(-6,7);
        Assertions.assertEquals(1,sum);
    }

    @Test
    void testAddLargeIntegersResultOverflow(){
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(2147483647, 1);
        Assertions.assertEquals(-2147483648,sum);
    }
    @Test
    void testFirstArgumentIsLarger(){
        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(7,6);
        Assertions.assertTrue(bigger);
    }
    @Test
    void testSecondArgumentIsLarger(){
        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(6,7);
        Assertions.assertFalse(bigger);
    }

    @Test
    void testBothArgumentsAreEqual(){
        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(7,7);
        Assertions.assertEquals(7,7);
    }
}
