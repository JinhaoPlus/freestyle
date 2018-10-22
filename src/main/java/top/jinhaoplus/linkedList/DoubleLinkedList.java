package top.jinhaoplus.linkedList;

public class DoubleLinkedList {

    private DoubleNode head;

    private int size;

    DoubleLinkedList() {
        this.head = new DoubleNode();
        this.size = 0;
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
    public DoubleLinkedList addNode(int value) {
        DoubleNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        DoubleNode newNode = new DoubleNode(value);
        pointer.next = newNode;
        newNode.prev = pointer;
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
        DoubleNode pointer = head.next;
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
    public DoubleLinkedList setValueByIndex(int index, Object value) {
        if (index < -1 || index >= size) {
            return this;
        }
        DoubleNode pointer = head.next;
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
    public DoubleLinkedList insertAfterNodeValue(Object nodeValue, int value) {
        DoubleNode pointer = head.next;
        while (pointer != null) {
            if (pointer.value == nodeValue) {
                DoubleNode newNode = new DoubleNode(value);
                newNode.next = pointer.next;
                newNode.prev = pointer;
                if (pointer.next != null) {
                    pointer.next.prev = newNode;
                }
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
     * 在值为indexValue的节点前插入一个值为value的节点
     *
     * @param nodeValue 要在值为indexValue的节点前插入
     * @param value     插入的节点的值
     * @return 链表本身
     */
    public DoubleLinkedList insertBeforeNodeValue(Object nodeValue, int value) {
        DoubleNode pointer = head.next;
        while (pointer != null) {
            if (pointer.value == nodeValue) {
                DoubleNode newNode = new DoubleNode(value);
                // 保证最后丢弃的指向关系是以前的两个节点的，先建立的是newNode和两个节点的
                newNode.next = pointer;
                newNode.prev = pointer.prev;
                pointer.prev.next = newNode;
                pointer.prev = newNode;
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
    public DoubleLinkedList insertNodeByIndex(int index, Object value) {
        DoubleNode pointer = head;
        int cursor = 0;
        while (pointer != null) {
            if (cursor == index) {
                DoubleNode newNode = new DoubleNode(value);
                newNode.next = pointer.next;
                newNode.prev = pointer;
                if (pointer.next != null) {
                    pointer.next.prev = newNode;
                }
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
    public DoubleLinkedList deleteByNodeValue(Object nodeValue) {
        DoubleNode pointer = head.next;
        while (pointer != null) {
            if (pointer.value == nodeValue) {
                pointer.prev.next = pointer.next;
                if (pointer.next != null) {
                    pointer.next.prev = pointer.prev;
                }
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
    public DoubleLinkedList deleteByIndex(int index) {
        DoubleNode pointer = head.next;
        int cursor = 0;
        while (pointer != null) {
            if (cursor == index) {
                pointer.prev.next = pointer.next;
                if (pointer.next != null) {
                    pointer.next.prev = pointer.prev;
                }
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
     * 链表的所有节点的值顺序再反向顺序输入一个数组
     *
     * @return 值的数组
     */
    public Object[] nodeValues() {
        if (size == 0) {
            return new Object[0];
        }
        Object[] nodeValues = new Object[size * 2 - 1];
        int index = 0;
        DoubleNode pointer = head;
        while (pointer.next != null) {
            nodeValues[index++] = pointer.next.value;
            pointer = pointer.next;
        }
        pointer = pointer.prev;
        while (pointer.prev != null) {
            nodeValues[index++] = pointer.value;
            pointer = pointer.prev;
        }
        return nodeValues;
    }

    public static class DoubleNode {
        Object value;
        DoubleNode prev;
        DoubleNode next;

        DoubleNode() {
        }

        DoubleNode(Object value) {
            this.value = value;
        }
    }

}