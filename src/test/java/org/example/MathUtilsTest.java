package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MathUtilsTest {
    MathUtils mathUtils;
    @BeforeEach
    void setup(){
        mathUtils = new MathUtils();
    }
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
        Assertions.assertFalse(bigger);
    }
    @Test
    void testFloatingPointDivision(){
        float division = mathUtils.division(6.6f,2.0f);
        Assertions.assertEquals(3.3,division,0.001);
    }
    @Test
    void testFloatingPointMultiplication(){
        float multiplication = mathUtils.multiplication(5.25f,2.0f);
        Assertions.assertEquals (10.5,multiplication,0.001);
    }
    @ValueSource(ints = {3})
    @ParameterizedTest
    void testSquareRoot(int a){
        int squareRoot = mathUtils.squareRoot(3);
        Assertions.assertEquals(9,squareRoot,0.001);
    }
}