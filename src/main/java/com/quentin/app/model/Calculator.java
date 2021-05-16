package com.quentin.app.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculator
 */
public class Calculator {
    Calculator() {}

    public int Add(String input){
        String[] numbers;
        ArrayList<Integer> negatives = new ArrayList<>();
        String pattern;
        int result;

        pattern = ",|\\n";
        final Pattern p = Pattern.compile("^\\/\\/.+\\n.*");
        final Matcher m = p.matcher(input);

        if (m.matches()) {
            pattern =",|\\n|" + m.group().substring(2, 3);
            input = input.substring(3);
        }

        result = 0;

        if (input.isEmpty() || input == null)
            return 0;

        numbers = input.split(pattern);

        for (String s : numbers) {
            try {
                int number = Integer.parseInt(s);
                if (number < 0) {
                    negatives.add(number);
                } else if (number <= 1000) {
                    result += number;
                }
            } catch (Exception e) {
                System.out.println("failed to  parse integer: " + e.getMessage());
            }
        }

        if (negatives.size() != 0) {
            throw new IllegalArgumentException("No negatives should be included in the input string: " + negatives.toString());
        }

        return result;
    }

}
