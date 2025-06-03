package tad_down;

import tad_down.Node;

/**
 * Lista que insere os elementos ordenados pelo seus
 * respectivos valores armazenados no campo data de cada Node
 */
public class DoublyLinkedList {
    public Node head;

    public DoublyLinkedList() {
        head = null;
    }

    // Inserção em ordem crescente
    public void insertOrdered(int data) {
        Node newNode = new Node(data);
        if (head == null || data < head.getData()) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext()!= null && current.getNext().getData() >= current.getData()) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            if (current.getNext() != null) {
                current.getNext().setPrev(newNode);
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    public String printForward() {
        String output = "";
        Node current = head;
        output += "Lista (frente): ";
        while (current != null) {
            output += (current.getData() + " ");
            current = current.getNext();
        }
        return output + "\n";
    }

    public String printBackward() {
        Node current = head;
        String output = "Lista (trás): ";
        while (current != null) {
            current = current.getNext();
        }

        while (current != null) {
            output += (current.getData() + " ");
            current = current.getPrev();
        }
        return output + "\n";
    }

    public void remove(int data) {
        Node current = head;

        while (current != null && current.getData() != data) {
            current = current.getNext();
        }

        if (current == null) return;

        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        } else {
            head = head.getNext();
        }

        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }

    }
}
