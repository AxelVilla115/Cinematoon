package utez.project.cinematoon.structure;

import java.util.Comparator;
import java.util.Locale;
import java.util.function.Function;

public class BinarySearchTree<T> {
    private Node<T> root;
    private int size;
    private final Comparator<T> comparator;
    private final Function<T, String> searchKeyExtractor;

    public BinarySearchTree(Comparator<T> comparator, Function<T, String> searchKeyExtractor) {
        this.root = null;
        this.size = 0;
        this.comparator = comparator;
        this.searchKeyExtractor = searchKeyExtractor;
    }

    public void insert(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        root = insert(root, data);
        size++;
    }

    private Node<T> insert(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        int comparison = comparator.compare(data, current.data);

        if (comparison < 0) {
            current.left = insert(current.left, data);
        } else {
            current.right = insert(current.right, data);
        }

        return current;
    }

    public LinkedList<T> search(String query) {
        LinkedList<T> results = new LinkedList<>();

        if (query == null || query.isBlank()) {
            return results;
        }

        search(root, query.toLowerCase(), results);

        return results;
    }

    private void search(Node<T> current, String query, LinkedList<T> results) {
        if (current == null) {
            return;
        }

        search(current.left, query, results);

        String value = searchKeyExtractor.apply(current.data);

        if (value != null && value.toLowerCase(Locale.ROOT).contains(query)) {
            results.add(current.data);
        }

        search(current.right, query, results);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
