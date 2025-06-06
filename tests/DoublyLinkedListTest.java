import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tad_down.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTest {
    private DoublyLinkedList list;

    @BeforeEach
    public void initializeList() {
        list = new DoublyLinkedList();
    }

    @Test
    public void test_inserOrdered() {
        list.insertOrdered(10);
        assertEquals("10", list.head.toString());
        list.insertOrdered(20);
        assertEquals("10", list.head.toString());
        assertEquals("20", list.head.getNext().toString());
        list.insertOrdered(30);
        assertEquals("10", list.head.toString());
        assertEquals("20", list.head.getNext().toString());
        assertEquals("30", list.head.getNext().getNext().toString());
    }


    @Test
    public void test_printForward_when() {
        list.insertOrdered(40);
        list.insertOrdered(10);
        list.insertOrdered(30);
        list.insertOrdered(20);
        assertEquals("Lista (frente): 10 20 30 40 \n", list.printForward());
    }

    @Test
    public void test_printBackward_when() {
        list.insertOrdered(40);
        list.insertOrdered(10);
        list.insertOrdered(30);
        list.insertOrdered(20);
        assertEquals("Lista (trás): 40 30 20 10 \n", list.printBackward());
    }

    @Test
    public void test_remove() {
        list.insertOrdered(40);
        list.insertOrdered(10);
        list.insertOrdered(30);
        list.insertOrdered(20);

        list.remove(10);
        assertEquals("Lista (frente): 20 30 40 \n", list.printForward()); // remoção do primeiro elemento
        list.insertOrdered(10);

        list.remove(20);
        assertEquals("Lista (frente): 10 30 40 \n", list.printForward()); // remoção de um elemento do meio
        list.insertOrdered(20);

        list.remove(40);
        assertEquals("Lista (frente): 10 20 30 \n", list.printForward()); // remoção do ultimo elemento
    }
}
