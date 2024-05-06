
//PART 1

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    private static class Node<T> {
        T element;  // Data stored in the node
        Node<T> next;   // Reference to the next node
        Node<T> prev;   // Reference to the previous node

        Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(T e) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == size)
            add(element);
        else {
            Node<T> successor = getNode(index);
            Node<T> predecessor = successor.prev;
            Node<T> newNode = new Node<>(predecessor, element, successor);
            successor.prev = newNode;
            if (predecessor == null)
                first = newNode;
            else
                predecessor.next = newNode;
            size++;
        }
    }

    public T get(int index) {
        Node<T> x = getNode(index);
        return x.element;
    }

    public void remove(T element) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (element.equals(x.element)) {
                unlink(x);
                return;
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        unlink(getNode(index));
    }

    public void removeAll(T element) {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            if (element.equals(x.element)) {
                unlink(x);
            }
            x = next;
        }
    }

    public void addFirst(T e) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> x = first;
        while (x != null) {
            sb.append(x.element.toString());
            if (x.next != null)
                sb.append(", ");
            x = x.next;
        }
        return sb.toString();
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    private void unlink(Node<T> x) {
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> lastReturned;
            private Node<T> next = first;
            private int nextIndex = 0;

            public boolean hasNext() {
                return nextIndex < size;
            }

            public T next() {
                if (!hasNext())
                    throw new java.util.NoSuchElementException();
                lastReturned = next;
                next = next.next;
                nextIndex++;
                return lastReturned.element;
            }
        };
    }
}
