package stack;

// import java.util.Stack;

public class StringReverse {
    public String reverse(String str) {
        var stack = new ArrayStack<Character>(10);
        var reversedStr = new StringBuffer();

        for (char ch : str.toCharArray())
            stack.push(ch);
        while (!stack.empty())
            reversedStr.append(stack.pop());

        return reversedStr.toString();
    }
}
