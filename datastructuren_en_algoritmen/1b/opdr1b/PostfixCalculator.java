package opdr1b;

import java.awt.*;
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

    int calculate() throws PostfixException, IOException, EmptyStackException {
        int opr1, opr2, result = 0;
        while (tokenlezer.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tokenlezer.ttype) {
                case StreamTokenizer.TT_WORD:
                    throw new PostfixException("Voer een geldige postfix expressie in");
                case StreamTokenizer.TT_NUMBER:
                    stack.push((int) tokenlezer.nval);
                    break;
                default:
                    char c = (char) tokenlezer.ttype;
                    opr2 = stack.pop();
                    opr1 = stack.pop();
                    result = Operation.fromString(String.valueOf(c)).apply(opr1, opr2);
                    stack.push(result);
            }

        }
        return result;
    }
}
