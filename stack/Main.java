package stack;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var reverser = new StringReverse();
        var evaluator = new EvaluateExp();

        System.out.println(reverser.reverse("Valentin"));

        Map<Character, Character> mathSymbols = new HashMap<>();

        mathSymbols.put('(', ')');
        mathSymbols.put('[', ']');
        mathSymbols.put('{', '}');

        String expression = "(2 * 4 * { [ 2 * 5 ] })[]";

        System.out.println(evaluator.evaluate(expression, mathSymbols));
    }
}
