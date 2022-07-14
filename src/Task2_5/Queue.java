package Task2_5;

class Queue {
    protected final static int DEFSIZE = 16;
    protected char[] array;
    protected int size, head, tail;

    public Queue(int capacity) {
        array = new char[capacity];
        clear();
    }

    public int getSize() {
        return size;
    }

    public Queue(){
        this(DEFSIZE);
    }

    //����� �� �������?
    public boolean empty() {
        return size == 0;
    }

    //������� ������� ������.
    public void clear() {
        size = head = 0;
        tail = array.length - 1;
    }

    //������� ������ ���������� �� ������ ��������.
    private int forward(int index) {
        return ++index < array.length ? index : 0;
    }

    //�������� ����� � ������� (� �����).
    public void push(char val) throws Exception {
        if(++size > array.length)
            throw new Exception();

        array[tail = forward(tail)] = val;
    }

    //������� ����� �� ������ �������.
    public int pop() throws Exception {
        int val = front();
        head = forward(head);
        size -= 1;

        return val;
    }

    //�������� ������ ������� (�� ������ ���).
    public int front() throws Exception {
        if(empty())
            throw new Exception();

        return array[head];
    }
}
