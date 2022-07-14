package Task2_5;

public class Deq extends Queue {
    public Deq(int degree) {
        super(degree);
    }

    public Deq() {
        super();
    }

    //������� ������ ����������� �� ������ ��������.
    private int backward(int index) {
        return --index < 0 ? this.array.length - 1 : index;
    }

    //�������� ������ � ������� (� ������).
    public void pushBack(char val) throws Exception {
        if (++size > array.length)
            throw new Exception();

        array[head = backward(head)] = val;
    }

    public void pushFront(char val) throws Exception {
        super.push(val);
    }

    //������� ����� �� ����� �������.
    public int popBack() throws Exception {
        int val = back();
        tail = backward(tail);
        size -= 1;
        return val;
    }

    public int popFront() throws Exception {
        return super.pop();
    }

    //�������� ����� ������� (�� ������ ���).
    public int back() throws Exception {
        if (super.empty())
            throw new Exception();
        return array[tail];
    }

}
