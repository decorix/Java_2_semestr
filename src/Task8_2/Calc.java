package Task8_2;

import java.util.Stack;

public class Calc extends Compf {

    private final Stack<Integer> s;
    private static String num;

    public Calc() {
        s = new Stack<Integer>();
        num = "";
    }

    private static int char2int(char c) {
        return (int) c - (int) '0';
    }

    private static int Str2int(String c) {
        return Integer.parseInt(c);
    }

    @Override
    protected int symType(char c) {
        switch (c) {
            case '(', '{', '[':
                return SYM_LEFT;
            case ')', '}', ']':
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

    @Override
    protected void processSymbol(char c) {
        switch (symType(c)) {
            case SYM_LEFT:
                AddNum();
                push(c);
                break;
            case SYM_RIGHT:
                AddNum();
                processSuspendedSymbols(c);
                pop();
                break;
            case SYM_OPER:
                AddNum();
                processSuspendedSymbols(c);
                push(c);
                break;
            case SYM_OTHER:
                nextOther(c);
                break;
        }
    }

    private void AddNum() {
        if (!num.equals("")){
            s.push(Str2int(num));
            num="";
        }
    }

    @Override
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);

            System.exit(0);
        }

        return SYM_OTHER;
    }

    @Override
    protected void nextOper(char c) {

        int second = s.pop();
        int first = s.pop();

        switch (c) {
            case '+':
                s.push(first + second);
                break;
            case '-':
                s.push(first - second);
                break;
            case '*':
                s.push(first * second);
                break;
            case '/':
                s.push(first / second);
                break;
        }
    }

    @Override
    protected void nextOther(char c) {
        num+=c;
    }

    @Override
    public final void compile(char[] str) {
        super.compile(str);
        System.out.println("Ответ: " + s.peek()); //вывод ответа
    }
}