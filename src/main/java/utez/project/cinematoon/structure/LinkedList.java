package utez.project.cinematoon.structure;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedList<T> copy() {
        LinkedList<T> copy = new LinkedList<>();

        Node<T> current = head;

        while (current != null) {
            copy.add(current.data);
            current = current.next;
        }

        return copy;
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();

        Node<T> current = head;

        while (current != null) {
            list.add(current.data);
            current = current.next;
        }

        return list;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}