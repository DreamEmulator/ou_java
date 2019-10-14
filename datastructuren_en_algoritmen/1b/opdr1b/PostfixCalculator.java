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

//    Feedback
//    ✅De expressie 12 geeft als resultaat 0. Dat moet echter 12 zijn.

//    ✅Als er een foutmelding is geweest, moet je die bij een volgende berekening wel weghalen. Dat gebeurt nu alleen als de volgende berekening geldig is.

//    ✅De expressie 1 2 3 4 + + + + is ongeldig. Er volgt geen foutmelding, maar ook geen resultaat.

//    ✅De expressie 1 2 3 4 + + is ongeldig. Jouw programma geeft als resultaat 9.

//    ✅In berekenKnop vang je alleen een algemene exception op. Vang liever de specifieke exceptions op, zoals postfixExpression.

//    ✅In je berekening houd je er geen rekening mee dat de stack leeg kan zijn als je een berekening wilt uitvoeren

//    ✅Je controleert niet of er teveel getallen zijn ingevoerd voor de berekening.

    int calculate() throws PostfixException, IOException {
        int opr1, opr2;

        while (tokenlezer.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tokenlezer.ttype) {
                case StreamTokenizer.TT_WORD:
                    throw new PostfixException("Voer een geldige postfix expressie in");
                case StreamTokenizer.TT_NUMBER:
                    stack.push((int) tokenlezer.nval);
                    break;
                default:
                    char c = (char) tokenlezer.ttype;
                    if (stack.isEmpty()) throw new PostfixException("Stack is leeg, onvoldoende getallen");
                    opr1 = stack.pop();
                    if (stack.isEmpty()) throw new PostfixException("Stack is leeg, onvoldoende getallen");
                    opr2 = stack.pop();
                    if (!stack.isEmpty()) throw new PostfixException("Stack is niet leeg, teveel getallen");
                    int result = Operation.fromString(String.valueOf(c)).apply(opr2, opr1);
                    stack.push(result);
            }

        }
        return stack.peek();
    }
}
