package top.jinhaoplus.linkedList;

public class LinkedListStyle {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.traverse();
        linkedList.insertNode(3, 6);
        linkedList.traverse();
        linkedList.insertNode(4, 7);
        linkedList.traverse();
        linkedList.deleteNode(6);
        linkedList.traverse();
        linkedList.deleteNode(7);
        linkedList.traverse();
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = new Node();
    }

    void addNode(int value) {
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(value);
    }

    void insertNode(int indexValue, int value) {
        Node pointer = head;
        while (pointer.next != null) {
            if (pointer.value == indexValue) {
                Node newNode = new Node(value);
                newNode.next = pointer.next;
                pointer.next = newNode;
                break;
            } else {
                pointer = pointer.next;
            }
        }
    }

    void deleteNode(int indexValue) {
        Node pointer = head;
        while (pointer.next != null) {
            if (pointer.next.value == indexValue) {
                pointer.next = pointer.next.next;
                break;
            } else {
                pointer = pointer.next;
            }
        }
    }

    void traverse() {
        Node pointer = head.next;
        while (pointer.next != null) {
            System.out.print(pointer.value + " -> ");
            pointer = pointer.next;
        }
        System.out.println(pointer.value);
    }
}

class Node {
    int value;
    Node next;

    Node() {
    }

    Node(int value) {
        this.value = value;
    }
}
