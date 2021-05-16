package com.quentin.app.model;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * CalculatorTest
 */
public class CalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addEmptyString() {
        int expected = 0;
        int actual;
        Calculator calculator = new Calculator();
        actual = calculator.Add("");
        assertEquals(actual, expected);
    }

    @Test
    public void addSingleDigit(){
        int expected;
        int actual;
        String inputString;
        Calculator calculator = new Calculator();

        inputString = "5";
        expected = 5;
        actual = calculator.Add(inputString);

        assertEquals(actual, expected);
    }

    @Test
    public void addNumberWithMultipleDigits(){
        int expected;
        int actual;
        String inputString;
        Calculator calculator = new Calculator();

        inputString = "27";
        expected = 27;
        actual = calculator.Add(inputString);

        assertEquals(actual, expected);
    }

    @Test
    public void addTwoNumbers(){
        int expected;
        int actual;
        String inputString;
        Calculator calculator = new Calculator();

        inputString = "2,5";
        expected = 7;
        actual = calculator.Add(inputString);

        assertEquals(actual, expected);
    }

    @Test
    public void addMoreNumbers(){
        int expected;
        int actual;
        String inputString;
        Calculator calculator = new Calculator();

        inputString = "2,5,3,8,9,10,7,500,2";
        expected = 546;
        actual = calculator.Add(inputString);

        assertEquals(actual, expected);
    }

    @Test
    public void addNumbersSeparatedByNewlines() {
        int expected;
        int actual;
        String inputString;
        Calculator calculator = new Calculator();

        inputString = "1\n2,3";
        expected = 6;
        actual = calculator.Add(inputString);

        assertEquals(actual, expected);
    }

    @Test
    public void addWithDelimiter() {
        int expected;
        int actual;
        String inputString;
        Calculator calculator = new Calculator();

        inputString = "//;\n1;2";
        expected = 3;
        actual = calculator.Add(inputString);

        assertEquals(actual, expected);
    }

    @Test
    public void addNegative() {
        Calculator calculator = new Calculator();
        exception.expect(IllegalArgumentException.class);

        calculator.Add("-1");
    }

    @Test
    public void addNegatives() {
        Calculator calculator = new Calculator();
        exception.expect(IllegalArgumentException.class);

        calculator.Add("2,5,-3,8,-9,10,-7,-500,2");
    }

    @Test
    public void ignoreAboveThousand() {
        int expected;
        int actual;
        String inputString;
        Calculator calculator = new Calculator();

        inputString = "2,1001";
        expected = 2;
        actual = calculator.Add(inputString);

        assertEquals(actual, expected);
    }
}
