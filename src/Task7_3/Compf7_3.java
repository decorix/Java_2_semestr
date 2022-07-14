package Task7_3;

import java.util.ArrayList;
import java.util.Collections;

public class Compf7_3 extends java.util.Stack<Character> {
    protected final static int
            SYM_LEFT = 0,
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3;

    private final ArrayList<Character> symbols = new ArrayList<>();
    private final ArrayList<String> vars = new ArrayList<>();

    private int symType(char c){
        switch(c){
            case '(':
                return SYM_LEFT;
            case ')':
                return SYM_RIGHT;
            case '+':
            case '-':
            case '*':
            case '/':
                return SYM_OPER;
            default:
                return symOther(c);
        }
    }

    protected void processSymbol(char c) {
        switch (symType(c)) {
            case SYM_LEFT:
                printChar();
                push(c);
                break;

            case SYM_RIGHT:
                printChar();
                processSuspendedSymbols(c);
                pop();
                break;

            case SYM_OPER:
                printChar();
                processSuspendedSymbols(c);
                push(c);
                break;

            case SYM_OTHER:
                nextOther(c);
                break;
        }
    }

    private void processSuspendedSymbols(char c) {
        while (precedes(peek(), c)) {

            Collections.sort(vars);

            char sympop = pop();

            if ((sympop == '*' || sympop == '/') && vars.contains("b ")) {
                vars.remove("b ");
                for (int i = 0; i < vars.size(); i++) {
                    System.out.print(vars.get(i));
                }
            } else {
                for (int i = 0; i < vars.size(); i++) {
                    System.out.print(vars.get(i));
                }
                System.out.print(sympop + " ");
            }
            vars.clear();
        }
    }

    private int priority(char c) {
        return c == '+' || c == '-' ? 1 : 2;
    }

    private boolean precedes(char a, char b) {
        if (symType(a)==(SYM_LEFT))
            return false;
        if (symType(b)==(SYM_RIGHT))
            return true;
        return priority(a) >= priority(b);
    }

    protected int symOther(char c) {
        if (c < 'a' || c > 'z') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }

        return SYM_OTHER;
    }

    protected void nextOper(char c) {
        symbols.add(c);
    }

    protected void nextOther(char c) {
        nextOper(c);
    }

    protected void printChar() {
        StringBuilder tempStr = new StringBuilder();

        Collections.sort(symbols);

        for (int i = 0; i < symbols.size(); i++) {
            tempStr.append(symbols.get(i));
        }

        tempStr.append(" ");
        String str = tempStr.toString();

        if (!str.equals(" ")) {
            vars.add(str);
        }
        symbols.clear();
    }

    public void compile(char[] str) {
        processSymbol('(');

        for (int i = 0; i < str.length; i++) {
            processSymbol(str[i]);
        }

        processSymbol(')');

        System.out.print("\n");
    }
}