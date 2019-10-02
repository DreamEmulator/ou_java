package opdr1b;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.EmptyStackException;
import java.util.Stack;

class PostfixCalculator {
    private StreamTokenizer tokenlezer;
    private Stack<Integer> stack = new Stack<>();

    PostfixCalculator(String expressie) {
        this.tokenlezer = new StreamTokenizer(new StringReader(expressie));
        tokenlezer.ordinaryChar('/');
        tokenlezer.ordinaryChar('-');
    }

    Boolean isOperator(String c) {
        return c.equals("/") || c.equals("*") || c.equals("+") || c.equals("/-");
    }

    String calculate() throws PostfixException {

        int opr1, opr2, result = 0;
        try {
            while (tokenlezer.nextToken() != StreamTokenizer.TT_EOF) {
                switch (tokenlezer.ttype) {
                    case StreamTokenizer.TT_WORD:
                        throw new PostfixException("Geen letters invoeren");
                    case StreamTokenizer.TT_NUMBER:
                        stack.push((int) tokenlezer.nval);
                        break;
                    default:
                        char c = (char) tokenlezer.ttype;
                        if (isOperator(String.valueOf(c))) {
                            opr1 = stack.pop();
                            opr2 = stack.pop();
                            result = Operation.fromString(String.valueOf(c)).apply(opr1, opr2);
                            stack.push(result);
                        } else {
                            throw new PostfixException("Gebruik alleen geldige operators");
                        }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "" + result;
    }
}
