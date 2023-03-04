package stack;

import java.util.Map;
// import java.util.Stack;

public class EvaluateExp {
    public boolean evaluate(String exp, Map<Character, Character> symbols) {
        var stack = new ArrayStack<Character>(20);

        for (char character : exp.toCharArray()) {
            if (symbols.containsValue(character)) {
                var lastSymbol = stack.pop();
                if (symbols.get(lastSymbol) != character)
                    return false;
            }
            if (symbols.containsKey(character)) {
                stack.push(character);
            }
        }

        return stack.empty();
    }
}
