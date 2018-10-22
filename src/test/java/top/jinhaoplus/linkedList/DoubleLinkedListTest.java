package top.jinhaoplus.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {
    private DoubleLinkedList linkedList;

    @Before
    public void setUp() {
        linkedList = new DoubleLinkedList().addNode(1).addNode(2).addNode(3).addNode(4).addNode(5);
    }

    @Test
    public void getSize0() {
        Assert.assertEquals(0, new DoubleLinkedList().getSize());
    }

    @Test
    public void getSize() {
        Assert.assertEquals(5, linkedList.getSize());
    }

    @Test
    public void isEmpty0() {
        Assert.assertTrue(new LinkedList().isEmpty());
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void getValueByIndex0() {
        Assert.assertEquals(1, linkedList.getValueByIndex(0));
    }

    @Test
    public void getValueByIndex1() {
        Assert.assertEquals(2, linkedList.getValueByIndex(1));
    }

    @Test
    public void getValueByIndex10() {
        Assert.assertNull(linkedList.getValueByIndex(10));
    }

    @Test
    public void setValueByIndex0() {
        Assert.assertTrue(verifyResult(new Object[]{11, 2, 3, 4, 5, 4, 3, 2, 11}, linkedList.setValueByIndex(0, 11)));
    }

    @Test
    public void setValueByIndex1() {
        Assert.assertTrue(verifyResult(new Object[]{1, 12, 3, 4, 5, 4, 3, 12, 1}, linkedList.setValueByIndex(1, 12)));
    }

    @Test
    public void setValueByIndex10() {
        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4, 5, 4, 3, 2, 1}, linkedList.setValueByIndex(10, 10)));
    }

    @Test
    public void addNode0() {
        Assert.assertTrue(verifyResult(new Object[]{0}, new DoubleLinkedList().addNode(0)));
    }

    @Test
    public void addNode6() {
        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1}, linkedList.addNode(6)));
    }

    @Test
    public void insertAfterNode0() {
        Assert.assertTrue(verifyResult(new Object[]{}, new DoubleLinkedList().insertAfterNodeValue(0, 10)));
    }

    @Test
    public void insertAfterNode1() {
        Assert.assertTrue(verifyResult(new Object[]{1, 11, 2, 3, 4, 5, 4, 3, 2, 11, 1}, linkedList.insertAfterNodeValue(1, 11)));
    }

    @Test
    public void insertAfterNode2() {
        Assert.assertTrue(verifyResult(new Object[]{1, 2, 12, 3, 4, 5, 4, 3, 12, 2, 1}, linkedList.insertAfterNodeValue(2, 12)));
    }

    @Test
    public void insertAfterNode5() {
        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4, 5, 15, 5, 4, 3, 2, 1}, linkedList.insertAfterNodeValue(5, 15)));
    }

    //    @Test
//    public void insertNodeByIndex0() {
//        Assert.assertTrue(verifyResult(new Object[]{10, 1, 2, 3, 4, 5}, linkedList.insertNodeByIndex(0, 10)));
//    }
//
//    @Test
//    public void insertNodeByIndex1() {
//        Assert.assertTrue(verifyResult(new Object[]{1, 11, 2, 3, 4, 5}, linkedList.insertNodeByIndex(1, 11)));
//    }
//
//    @Test
//    public void insertNodeByIndex5() {
//        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4, 5, 15}, linkedList.insertNodeByIndex(5, 15)));
//    }
//
//    @Test
//    public void deleteByNodeValue1() {
//        Assert.assertTrue(verifyResult(new Object[]{2, 3, 4, 5}, linkedList.deleteByNodeValue(1)));
//    }
//
//    @Test
//    public void deleteByNodeValue2() {
//        Assert.assertTrue(verifyResult(new Object[]{1, 3, 4, 5}, linkedList.deleteByNodeValue(2)));
//    }
//
//    @Test
//    public void deleteByNodeValue5() {
//        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4}, linkedList.deleteByNodeValue(5)));
//    }
//
//    @Test
//    public void deleteByNodeValue6() {
//        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4, 5}, linkedList.deleteByNodeValue(6)));
//    }
//
//    @Test
//    public void deleteAllNodes() {
//        Assert.assertTrue(verifyResult(new Object[]{}, linkedList.deleteByNodeValue(5).deleteByNodeValue(4).deleteByNodeValue(3).deleteByNodeValue(2).deleteByNodeValue(1)));
//    }
//
//    @Test
//    public void deleteByIndex0() {
//        Assert.assertTrue(verifyResult(new Object[]{2, 3, 4, 5}, linkedList.deleteByIndex(0)));
//    }
//
//    @Test
//    public void deleteByIndex1() {
//        Assert.assertTrue(verifyResult(new Object[]{1, 3, 4, 5}, linkedList.deleteByIndex(1)));
//    }
//
//    @Test
//    public void deleteByIndex4() {
//        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4}, linkedList.deleteByIndex(4)));
//    }
//
    @Test
    public void testVerifyResult() {
        Assert.assertTrue(verifyResult(new Object[]{1, 2, 3, 4, 5, 4, 3, 2, 1}, linkedList));
    }

    private boolean verifyResult(Object[] predictResults, DoubleLinkedList linkedList) {
        Object[] nodeValues = linkedList.nodeValues();
        for (int i = 0; i < nodeValues.length; i++) {
            if (predictResults[i] != nodeValues[i]) {
                return false;
            }
        }
        return true;
    }
}