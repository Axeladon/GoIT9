package myQueue;

public class MyQueue<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, value);
            lastNode = firstNode;
        } else if (lastNode == firstNode) {
            lastNode = new Node<>(null, value);
            firstNode.setNextNode(lastNode);
        } else {
            Node nextNode = new Node(null,  value);
            lastNode.setNextNode(nextNode);
            lastNode = nextNode;
        }
        size++;
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return firstNode.getValue();
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T value = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        size--;
        return value;
    }

    public class Node<T> {
        private Node<T> nextNode;
        private T value;

        public Node(Node<T> nextNode, T value) {
            this.nextNode = nextNode;
            this.value = value;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public T getValue() {
            return this.value;
        }

    }
}
