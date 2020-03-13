package problemSolving.linkedlist;

public class MergeSortInLinkedlist {
    private static Node head;

    public static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
            next = null;
        }
    }

    public static void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        push(5);
        push(8);
        push(4);
        push(10);
        printList(head);
        System.out.println("head : " + head.next.next.next.next);
    }
}

