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
        int count = 0;
        Node current = head;
        String output = "Lista (trás): ";

        // Adicionada condicional para lista vazia
        if (current == null) {
            return output + "\n"; // Lista vazia
        }

        while (current.next != null) { //precisamos substituir "current != null" por "current.next != null" para impedir que o ultimo nó seja nulo
            current = current.next;
            count++;
        }

        for (int i = 0; i <= count; i++) {
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
            if (head != null) {
                head.prev = null; // Add para limpar o prev do novo header, que deverá ser "esquecido".
            }
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

    }
}
