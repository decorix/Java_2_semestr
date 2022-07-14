package Task8_3;

class Compf extends java.util.Stack<Character> {
    //Типы символов (скобки, знаки операций, иное).
    protected final static int SYM_LEFT = 0,
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3,
            SYM_ANS = 4;
    protected static boolean flag;

    protected int symType(char c) {
        switch (c) {
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
                push(c);
                break;
            case SYM_RIGHT:
                processSuspendedSymbols(c);
                pop();
                break;
            case SYM_OPER:
                processSuspendedSymbols(c);
                push(c);
                break;
            case SYM_OTHER:
                nextOther(c);
                break;
        }
    }


    protected void processSuspendedSymbols(char c) { //обаботка подвисшего символа
        while (precedes(peek(), c)) {
            nextOper(pop());
        }
    }

    private int priority(char c) {
        return c == '+' || c == '-' ? 1 : 2;
    }

    private boolean precedes(char a, char b) { //предшествует
        if (symType(a) == SYM_LEFT) return false;
        if (symType(b) == SYM_RIGHT) return true;

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
        System.out.print("" + c + " ");
    }

    protected void nextOther(char c) {
        nextOper(c);
    }

    public void compile(char[] str) {
        if (flag) {
            processSymbol('(');
            flag = false;
        }

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '=') {
                processSymbol(')');
                processSymbol('=');
            } else {
                processSymbol(str[i]);
            }
        }

        //processSymbol(')');

        System.out.print("\n");
    }
}