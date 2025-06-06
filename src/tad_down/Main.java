package tad_down;

public class Main {
    public static void main(String[] args) {
        tad_down.DoublyLinkedList list = new tad_down.DoublyLinkedList();

        list.insertOrdered(30);
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(40);

        System.out.print(list.printForward());  // Esperado: 10 20 30 40
        System.out.print(list.printBackward()); // Esperado: 40 30 20 10


    }
}
