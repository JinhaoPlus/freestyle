package top.jinhaoplus.linkedList;

public class DoubleLinkedListStyle {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(1);
        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(3);
        doubleLinkedList.addNode(4);
        doubleLinkedList.addNode(5);
        System.out.println("原链表");
        doubleLinkedList.traverse();
        System.out.println("在节点3后插入6");
        doubleLinkedList.insertNode(3, 6, true);
        doubleLinkedList.traverse();
        System.out.println("在节点4前插入7");
        doubleLinkedList.insertNode(4, 7, false);
        doubleLinkedList.traverse();
        System.out.println("删除节点6");
        doubleLinkedList.deleteNode(6);
        doubleLinkedList.traverse();
        System.out.println("删除节点7");
        doubleLinkedList.deleteNode(7);
        doubleLinkedList.traverse();
    }
}

class DoubleLinkedList {
    DoubleNode head;

    DoubleLinkedList() {
        this.head = new DoubleNode();
    }

    void addNode(int value) {
        DoubleNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        DoubleNode newNode = new DoubleNode(value);
        pointer.next = newNode;
        newNode.prev = pointer;

    }

    /**
     * 插入节点
     *
     * @param indexValue     在值为indexValue的节点之前|后插入
     * @param value          插入的节点的值
     * @param afterIndexNode 在节点之前|后插入
     */
    void insertNode(int indexValue, int value, boolean afterIndexNode) {
        DoubleNode pointer = head;
        while (pointer != null) {
            if (pointer.value == indexValue) {
                if (afterIndexNode) {
                    DoubleNode newNode = new DoubleNode(value);
                    if (pointer.next != null) {
                        newNode.next = pointer.next;
                        pointer.next.prev = newNode;
                    }
                    pointer.next = newNode;
                    newNode.prev = pointer;
                } else {
                    DoubleNode newNode = new DoubleNode(value);
                    newNode.prev = pointer.prev;
                    pointer.prev.next = newNode;
                    pointer.prev = newNode;
                    newNode.next = pointer;
                }
                break;
            } else {
                pointer = pointer.next;
            }
        }
    }

    /**
     * 删除节点
     */
    void deleteNode(int indexValue) {
        DoubleNode pointer = head;
        while (pointer != null) {
            if (pointer.value == indexValue) {
                pointer.prev.next = pointer.next;
                if (pointer.next != null) {
                    pointer.next.prev = pointer.prev;
                }
                break;
            } else {
                pointer = pointer.next;
            }
        }
    }

    void traverse() {
        System.out.println("------------------");
        DoubleNode pointer = head.next;
        while (pointer.next != null) {
            System.out.print(pointer.value + " -> ");
            pointer = pointer.next;
        }
        System.out.println(pointer.value);
        while (pointer.prev != null) {
            System.out.print(pointer.value + " -> ");
            pointer = pointer.prev;
        }
        System.out.println();
        System.out.println("------------------");
    }
}

class DoubleNode {
    int value;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode() {
    }

    DoubleNode(int value) {
        this.value = value;
    }
}
