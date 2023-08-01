package myLinkedList;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;
    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, value);
        } else if (lastNode == null){
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        } else {
            Node newNode = new Node<>(lastNode, null, value);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public void remove(int index) {
        checkIndex(index);

        Node toRemove = firstNode;
        for (int i = 0; i < index; i++) {
            toRemove = toRemove.getNextNode();
        }
        if (toRemove == firstNode) {
            firstNode = firstNode.getNextNode();
            firstNode.setPrevNode(null);
        } else if (toRemove == lastNode) {
            lastNode = lastNode.getPrevNode();
            lastNode.setNextNode(null);
        } else {
            toRemove.getPrevNode().setNextNode(toRemove.getNextNode());
            toRemove.getNextNode().setPrevNode(toRemove.getPrevNode());
        }
        size--;
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);

        Node curNode = firstNode;
        for (int i = 0; i < index; i++) {
            curNode = curNode.getNextNode();
        }
        return (T)curNode.getValue();
    }

    private class Node<T> {
        private Node<T> prevNode;
        private Node<T> nextNode;
        private T value;

        public Node(Node<T> prevNode, Node<T> nextNode, T value) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = value;
        }
        public Node<T> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<T> prevNode) {
            this.prevNode = prevNode;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
