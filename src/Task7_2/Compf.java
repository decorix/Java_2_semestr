package Task7_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Compf extends Stack {
    //Типы символов (скобки, знаки операций, иное).
    protected final static int SYM_LEFT = 0,
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3;
    protected int a = 1;
    protected ArrayList<Character> list = new ArrayList<>();
    //protected char k;
    // protected int count=0; // кол-во операций

    private int symType(char c) {
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

    private void processSymbol(char c) {
        switch (symType(c)) {
            case SYM_LEFT:
                push(c);
                break;
            case SYM_RIGHT:
                processSuspendedSymbols(c);
                pop(); //?!
                break;
            case SYM_OPER:
                a = 0;
                processSuspendedSymbols(c);
                push(c);
                break;
            case SYM_OTHER:
                nextOther(c);
                break;
        }
    }

    private void processSuspendedSymbols(char c) {
        while (precedes((Character) peek(), c))
            nextOper((Character) pop());
    }

    private int priority(char c) {
        return c == '+' || c == '-' ? 1 : 2;
    }

    private boolean precedes(char a, char b) {
        if (symType(a) == SYM_LEFT)
            return false;
        if (symType(b) == SYM_RIGHT)
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

    protected void Add() {

    }

    protected void nextOper(char c) {
        if (a == 1) {
            System.out.print("" + c + "");
        } else {
            a = 1;
            System.out.print(" " + c + " ");
        }


    }

    protected void nextOther(char c) {
        nextOper(c);
    }

    public void compile(char[] str) {
        processSymbol('('); //!

        for (int i = 0; i < str.length; i++) {
            processSymbol(str[i]);
            list.add(str[i]);

        }

        processSymbol(')'); //!

        System.out.print("\n");
        System.out.println();
        Collections.sort(list);
        for (int i=0; i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}

/*
        /*
if (count>=1 && (c=='+' || c=='-' || c=='*' || c=='/')) {
            a = 1;
            count=0;
            System.out.print(" " + k + " ");

        }else if (a == 0) {
            a = 1;
            count++;
            k = c;
        } else if (a == 1 && count >= 1) {
            count=0;
            System.out.print(" " + c + "");
        } else if (a == 1) {
            System.out.print("" + c + "");
        }

 */