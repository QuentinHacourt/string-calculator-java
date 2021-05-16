package com.quentin.app;

import com.quentin.app.model.Calculator;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        System.out.println(calculator.Add("1,2"));
    }
}
