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
        if (head == null || data < head.data) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data <= data) {   //Bastou substituir current.next.data >= data por current.next.data <= data;
                current = current.next;
            }

            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public String printForward() {
        String output = "";
        Node current = head;
        output += "Lista (frente): ";
        while (current != null) {
            output += (current.data + " ");
            current = current.next;
        }
        return output + "\n";
    }

    public String printBackward() {
        Node current = head;
        String output = "Lista (trás): ";
        while (current != null && current.next != null) { //precisamos adicionar && current.next != null para impedir que o utlimo nó seja nulo
            current = current.next;
        }

        while (current != null) {
            output += (current.data + " ");
            current = current.prev;

        }
        return output + "\n";
    }

    public void remove(int data) {
        Node current = head;

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) return;

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = head.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

    }
}
