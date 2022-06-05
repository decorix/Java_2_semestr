package Task2_2;

public class Stack{
    private static final int DEFSIZE = 16;
    private int[] array;
    private int head;

    public Stack(int capacity) {
        array = new int[capacity];
        head = 0;
    }

    public Stack() {
        this(DEFSIZE);
    }

    //Пуст ли стек?
    public boolean empty() {
        return head == 0;
    }

    //Сделать стек пустым.
    public void clear() {
        head = 0;
    }

    //Добавить элемент на вершину стека.
    public void push(int val) throws Exception {
        array[head++] = val;
    }

    //Удалить элемент с вершины стека.
    public int pop() throws Exception {
        return array[--head];
    }

    //Получить вершину стека.
    public int top() throws Exception {
        return array[head - 1];
    }
}