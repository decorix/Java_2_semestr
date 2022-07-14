package Task6;

public class RecursCompf {
    private static final int DEFSIZE = 256;
    private char[] str;
    private int index; //Число обработанных символов.

    public void RecursCompf() {
        str = new char[DEFSIZE];
    }

    private void compileF() {
        compileT();
        while (index < str.length) {
            if (str[index] == '+') {
                index++;
                compileF();
                System.out.print("+ ");
                return;
            } else if (str[index] == '-') {
                index++;
                compileF();
                System.out.print("- ");
            } else return;
        }
    }

    private void compileT() {
        compileM();
        while (index < str.length) {
            if (str[index] == '*') {
                index++;
                compileM();
                System.out.print("* ");
                return;
            }

            if (str[index] == '/') {
                index++;
                compileM();
                System.out.print("/ ");
            }
            return;
        }
    }

    private void compileM() {
        if (str[index] == '(' ||
                str[index] == '[' ||
                str[index] == '{'
        ) {
            index++;
            compileF();
            index++;
        } else
            compileV();
    }

    private void compileV() {
        while (
                index < str.length &&
                        str[index] != '+' &&
                        str[index] != '-' &&
                        str[index] != '*' &&
                        str[index] != '/' &&
                        str[index] != '(' &&
                        (str[index] != ')' ||
                                str[index] != ']' ||
                                str[index] != '}'
                        )
        ) {
            System.out.print(str[index++]);
        }
        System.out.print(" ");
    }

    public void compile(char[] str) {
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
}