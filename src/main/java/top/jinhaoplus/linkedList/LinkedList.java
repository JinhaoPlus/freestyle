package top.jinhaoplus.linkedList;

public class LinkedList {

    private Node head;

    private int size;

    LinkedList() {
        this.size = 0;
        this.head = new Node();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表后部插入值为value的节点
     *
     * @param value 插入的节点的值
     * @return 链表本身
     */
    public LinkedList addNode(int value) {
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(value);
        size++;
        return this;
    }

    /**
     * 获取链表中第index位置的节点的值
     *
     * @param index 第index位置
     * @return 节点值
     */
    public Object getValueByIndex(int index) {
        if (index < -1 || index >= size) {
            return null;
        }
        Node pointer = head.next;
        int cursor = 0;
        while (pointer != null) {
            if (cursor == index) {
                return pointer.value;
            } else {
                pointer = pointer.next;
                cursor++;
            }
        }
        return null;
    }

    /**
     * 设置链表中第index位置的节点的值
     *
     * @param index 第index位置
     * @param value 值
     * @return 节点值
     */
    public LinkedList setValueByIndex(int index, Object value) {
        if (index < -1 || index >= size) {
            return this;
        }
        Node pointer = head.next;
        int cursor = 0;
        while (pointer != null) {
            if (cursor == index) {
                pointer.value = value;
                break;
            } else {
                pointer = pointer.next;
                cursor++;
            }
        }
        return this;
    }

    /**
     * 在值为indexValue的节点后插入一个值为value的节点
     *
     * @param nodeValue 要在值为indexValue的节点后插入
     * @param value     插入的节点的值
     * @return 链表本身
     */
    public LinkedList insertAfterNodeValue(Object nodeValue, int value) {
        Node pointer = head.next;
        while (pointer != null) {
            if (pointer.value == nodeValue) {
                Node newNode = new Node(value);
                newNode.next = pointer.next;
                pointer.next = newNode;
                size++;
                break;
            } else {
                pointer = pointer.next;
            }
        }
        return this;
    }

    /**
     * 插入一个值为value的节点到第index的位置上
     *
     * @param index 第index的位置
     * @param value 插入的节点的值
     * @return 链表本身
     */
    public LinkedList insertNodeByIndex(int index, Object value) {
        Node pointer = head;
        int cursor = 0;
        while (pointer != null) {
            if (cursor == index) {
                Node newNode = new Node(value);
                newNode.next = pointer.next;
                pointer.next = newNode;
                size++;
                break;
            } else {
                pointer = pointer.next;
                cursor++;
            }
        }
        return this;
    }

    /**
     * 删除一个值为nodeValue的节点
     *
     * @param nodeValue 要删除的节点值为indexValue
     * @return 链表本身
     */
    public LinkedList deleteByNodeValue(Object nodeValue) {
        Node pointer = head;
        while (pointer.next != null) {
            if (pointer.next.value == nodeValue) {
                pointer.next = pointer.next.next;
                size--;
                break;
            } else {
                pointer = pointer.next;
            }
        }
        return this;
    }

    /**
     * 删除第index的位置上的节点
     *
     * @param index 第index的位置
     * @return 链表本身
     */
    public LinkedList deleteByIndex(int index) {
        Node pointer = head;
        int cursor = 0;
        while (pointer.next != null) {
            if (cursor == index) {
                pointer.next = pointer.next.next;
                size--;
                break;
            } else {
                pointer = pointer.next;
                cursor++;
            }
        }
        return this;
    }

    /**
     * 链表的所有节点的值顺序输入一个数组
     *
     * @return 值的数组
     */
    public Object[] nodeValues() {
        Object[] nodeValues = new Object[size];
        int index = 0;
        Node pointer = head;
        while (pointer.next != null) {
            nodeValues[index++] = pointer.next.value;
            pointer = pointer.next;
        }
        return nodeValues;
    }

    public static class Node {
        Object value;
        Node next;

        Node() {
        }

        Node(Object value) {
            this.value = value;
        }
    }
}
