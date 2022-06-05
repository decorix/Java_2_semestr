package Task2_2;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean a;
        int result;
        for (int j = 0; j < 15; j++) {
            Stack stack = new Stack();
            stack.push(' ');
            String str = scan.nextLine();
            a = true;
            result = 1; // 1 - скобки расставлены верно; 0 - скобки расставлены не в правильном порядке

            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '(':
                    case '[':
                    case '{':
                    case '<':
                        stack.push(str.charAt(i));
                        break;
                    case ')':
                        if ((stack.top() != '(') || stack.empty()) {
                            a = false;
                            break;
                        } else stack.pop();
                        break;
                    case ']':
                        if ((stack.top() != '[') || stack.empty()) {
                            a = false;
                            break;
                        } else stack.pop();
                        break;
                    case '}':
                        if ((stack.top() != '{') || stack.empty()) {
                            a = false;
                            break;
                        } else stack.pop();
                        break;
                    case '>':
                        if ((stack.top() != '<') || stack.empty()) {
                            a = false;
                            break;
                        } else stack.pop();
                        break;
                }
                if (!a) {
                    result = 0;
                    break;
                }
            }
            stack.pop();
            if (!stack.empty())  //Пуст ли стек?
                result = 0;
            System.out.print("Результат: " + result);
        }
    }
}