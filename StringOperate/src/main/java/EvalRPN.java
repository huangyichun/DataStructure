import java.util.LinkedList;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 1) {
            throw new IllegalArgumentException("输入参数有误");
        }
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; ++i) {
            String temp = tokens[i];
            countSum(temp, stack);
        }
        int sum = stringParseInt(stack.pop());
        if(!stack.isEmpty()){
            throw new IllegalArgumentException("输入参数有误");
        }
        return sum;
    }

    public void countSum(String str, LinkedList<String> stack) {
        int sum = 0, a, b;
        switch (str) {
            case "+": {
                a = stringParseInt(stack.pop());
                b = stringParseInt(stack.pop());
                sum = b + a;
                stack.push(String.valueOf(sum));
                break;
            }
            case "-": {
                a = stringParseInt(stack.pop());
                b = stringParseInt(stack.pop());
                sum = b - a;
                stack.push(String.valueOf(sum));
                break;
            }
            case "*": {
                a = stringParseInt(stack.pop());
                b = stringParseInt(stack.pop());
                sum = b * a;
                stack.push(String.valueOf(sum));
                break;
            }
            case "/": {
                a = stringParseInt(stack.pop());
                b = stringParseInt(stack.pop());
                sum = b / a;
                stack.push(String.valueOf(sum));
                break;
            }
            default:
                stack.push(str);
        }
    }

    public int stringParseInt(String s) {
        return Integer.parseInt(s);
    }
}
