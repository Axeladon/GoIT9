package myStack;

public class MyStack<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;
    public void push(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, value);
            lastNode = firstNode;
        } else {
            if (firstNode == lastNode) {
                lastNode = new Node<>(firstNode, null, value);
                firstNode.setNextNode(lastNode);
            } else {
                Node newNode = new Node<>(lastNode, null, value);
                lastNode.setNextNode(newNode);
                lastNode = newNode;
            }
        }
        size++;
    }

    public void remove(int index) {
        if (size == 1) {
            clear();
        } else {
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
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return lastNode == null ? null : lastNode.getValue();
    }

    public T pop() {
        T value = lastNode.getValue();
        Node privNode = lastNode.getPrevNode() != null ? lastNode.getPrevNode() : firstNode;
        privNode.setNextNode(null);
        lastNode = privNode;
        size--;
        return value;
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

    }
}
