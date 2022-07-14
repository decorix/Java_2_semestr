package Task3;

public class L1List<T> {
    private Node<T> first, last; //������ �� ������ � ��������� ����.
    private int size;

    public L1List() {
        first = last = null;
        size = 0;
    }

    public void append(Node<T> node) {
        node.next = null;

        if (first == null) //������ �������.
            first = node;

        if (last != null)
            last.next = node;

        last = node;
        size++;
    }

    // �������� ����� ��������
    public int search(Node<T> node) {
        int index = 0;
        try {
            if (!node.equals(first)) {
                Node<T> object = first.next;
                while (true) {
                    index++;
                    if (!object.equals(node)) {
                        object = object.next;
                    } else if (object.equals(node)) return index;
                    else return -1;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    // �������� ����� ��������
    public int find(Node<T> node) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.equals(node)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    // ������� ��������
    public void insert(Node<T> node, int location) throws Exception {
        Node<T> current = first;
        for (int i = 0; i < location; i++) {
            if (current.next == null) {
                throw new Exception();
            }
            current = current.next;
        }
        Node<T> oldNext = current.next;
        if (oldNext == null) last = node;
        current.next = node;
        node.next = oldNext;
        size++;
    }

    // �������� ��������
    public void remove(int location) throws Exception {
        Node<T> current = first;
        Node<T> before = null;
        for (int i = 0; i < location; i++) {
            if (current.next == null) {
                throw new Exception();
            }
            before = current;
            current = current.next;
        }
        before.next = current.next;
        if (location == size-1){
            before.next = null;
            last = before;
        }

        size--;
    }
}