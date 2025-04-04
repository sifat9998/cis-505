import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E item) {
        list.addFirst(item);
    }

    public E dequeue() {
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }
}
