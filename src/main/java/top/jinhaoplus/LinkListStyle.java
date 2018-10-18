package top.jinhaoplus;

public class LinkListStyle {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(1);
        linkList.addNode(2);
        linkList.addNode(3);
        linkList.addNode(4);
        linkList.addNode(5);
        linkList.traverse();
        linkList.insertNode(3, 6);
        linkList.traverse();
        linkList.insertNode(4, 7);
        linkList.traverse();
        linkList.deleteNode(6);
        linkList.traverse();
        linkList.deleteNode(7);
        linkList.traverse();
    }
}

class LinkList {
    Node head;

    LinkList() {
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
