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
    public void test_insertOrdered() {
        list.insertOrdered(10);
        assertEquals("10", list.getHead().toString());
        list.insertOrdered(20);
        assertEquals("10", list.getHead().toString());
        assertEquals("20", list.getHead().getNext().toString());
        list.insertOrdered(30);
        assertEquals("10", list.getHead().toString());
        assertEquals("20", list.getHead().getNext().toString());
        assertEquals("30", list.getHead().getNext().getNext().toString());
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

    @Test
    public void test_remove_singleElement() {
        list.insertOrdered(10);
        list.remove(10);
        assertEquals("Lista (frente): \n", list.printForward());
        assertEquals("Lista (trás): \n", list.printBackward());
    }

    @Test
    public void test_remove_nonExistentElement() {
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(30);
        list.remove(100); // 100 não existe
        assertEquals("Lista (frente): 10 20 30 \n", list.printForward());
        assertEquals("Lista (trás): 30 20 10 \n", list.printBackward());
    }

    @Test
    public void test_print_onEmptyList() {
        assertEquals("Lista (frente): \n", list.printForward());
        assertEquals("Lista (trás): \n", list.printBackward());
    }

    @Test
    public void test_insertOrdered_duplicates() {
        list.insertOrdered(20);
        list.insertOrdered(10);
        list.insertOrdered(20);
        list.insertOrdered(10);
        assertEquals("Lista (frente): 10 10 20 20 \n", list.printForward());
        assertEquals("Lista (trás): 20 20 10 10 \n", list.printBackward());
    }
}
