package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

    public class ImmutableLinkedListTest
{
    private ImmutableLinkedList firstImmutableList;
    private ImmutableLinkedList secondImmutableList;
    private ImmutableLinkedList emptyImmutableList;
    private Object[] firstArray;
    private Object[] secondArray;
    private Object[] emptyArray;

    @Before
    public void setUp() throws Exception
    {
        firstArray = new Object[]{51};
        secondArray = new Object[]{6, 5, 4, 3, 11, 15, -27};
        emptyArray = new Object[0];
        firstImmutableList = new ImmutableLinkedList(firstArray);
        secondImmutableList = new ImmutableLinkedList(secondArray);
        emptyImmutableList = new ImmutableLinkedList();
    }

    public void checkArrays()
    {
        assertArrayEquals(firstImmutableList.toArray(), firstArray);
        assertArrayEquals(secondImmutableList.toArray(), secondArray);
        assertArrayEquals(emptyImmutableList.toArray(), emptyArray);
    }

    public void testAdd(ImmutableLinkedList lst, Object value)
    {
        ImmutableLinkedList arr = (ImmutableLinkedList) lst.add(value);
        Object[] expected = new Object[lst.size() + 1];
        for (int i = 0; i < lst.size(); i++)
        {
            expected[i] = lst.get(i);
        }
        expected[expected.length - 1] = value;

        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(), expected.length);

    }

    @Test
    public void testAdd()
    {
        testAdd(secondImmutableList, 14);
        testAdd(firstImmutableList, -88);
        testAdd(emptyImmutableList, 0);
        checkArrays();
    }

    public void testAddIndex(ImmutableLinkedList lst, Object value, int index)
    {
        ImmutableLinkedList arr = (ImmutableLinkedList) lst.add(index, value);

        Object[] expected = new Object[lst.size() + 1];
        for (int i = 0; i < index; i++)
        {
            expected[i] = lst.get(i);
        }
        expected[index] = value;
        for (int i = index; i < lst.size(); i += 1)
            expected[i + 1] = lst.get(i);
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);
    }

    @Test
    public void testAddIndex()
    {
        testAddIndex(firstImmutableList, 11, 0);

        testAddIndex(secondImmutableList, 121, 4);
        checkArrays();
    }

    public void testRemove(ImmutableLinkedList lst, int index)
    {
        ImmutableLinkedList arr = (ImmutableLinkedList) lst.remove(index);
        Object[] expected = new Object[lst.size() - 1];
        for (int i = 0; i < index; i++)
        {
            expected[i] = lst.get(i);
        }
        for (int i = index; i < lst.size() - 1; i++)
        {
            expected[i] = lst.get(i + 1);
        }
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }

    @Test
    public void testRemove()
    {
        testRemove(firstImmutableList, 0);
        testRemove(secondImmutableList, 5);
        checkArrays();

    }
    public void testSet(ImmutableLinkedList lst, int index, Object value)
    {
        ImmutableLinkedList arr = (ImmutableLinkedList) lst.set(index,value);
        Object[] expected = lst.toArray();
        expected[index] = value;
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }
    @Test
    public void testSet()
    {
        testSet(firstImmutableList, 0, 95);
        testSet(secondImmutableList, 5, 1);
        checkArrays();
    }

    @Test
    public void testIndexOf()
    {
        assertEquals(firstImmutableList.indexOf(51),0);
        assertEquals(firstImmutableList.indexOf(43),-1);
        assertEquals(secondImmutableList.indexOf(5),1);
        assertEquals(secondImmutableList.indexOf(-27),6);
        assertEquals(emptyImmutableList.indexOf(0),-1);
        checkArrays();
    }

    @Test
    public void testSize()
    {
        assertEquals(firstImmutableList.size(), firstArray.length);
        assertEquals(secondImmutableList.size(), secondArray.length);
        assertEquals(emptyImmutableList.size(),0);
        checkArrays();

    }

    @Test
    public void testListClear()
    {
        assertArrayEquals(secondImmutableList.clear().toArray(), new Object[0]);
        assertEquals(firstImmutableList.clear().toString(),"");
    }
    @Test
    public void testEmpty()
    {
        assertFalse(firstImmutableList.isEmpty());
        assertFalse(secondImmutableList.isEmpty());
        assertTrue(emptyImmutableList.isEmpty());
        checkArrays();

    }

    @Test
    public void testString()
    {
        assertEquals(firstImmutableList.toString(),"51");
        assertEquals(secondImmutableList.toString(),"6, 5, 4, 3, 11, 15, -27");
        assertEquals(emptyImmutableList.toString(),"");
        checkArrays();
    }

    public void testAddFirst(ImmutableLinkedList lst, Object value)
    {
        ImmutableLinkedList arr = lst.addFirst(value);
        Object[] expected = new Object[lst.size() + 1];
        for (int i = 1; i <= lst.size(); i++)
        {
            expected[i] = lst.get(i - 1);
        }
        expected[0] = value;

        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(), expected.length);

    }

    @Test
    public void testAddFirst()
    {
        testAddFirst(firstImmutableList, 95);
        testAddFirst(secondImmutableList, 51);
        testAddFirst(emptyImmutableList, 43);
        checkArrays();
    }
    public void testAddLast(ImmutableLinkedList lst, Object value)
    {
        ImmutableLinkedList arr = lst.addLast(value);
        Object[] expected = new Object[lst.size() + 1];
        for (int i = 0; i < lst.size(); i++)
        {
            expected[i] = lst.get(i);
        }
        expected[lst.size()] = value;

        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(), expected.length);

    }

    @Test
    public void testAddLast()
    {
        testAddLast(firstImmutableList, 95);
        testAddLast(secondImmutableList, 51);
        testAddLast(emptyImmutableList, 43);
        checkArrays();
    }

    @Test
    public void testGetFirst()
    {
        assertEquals(firstImmutableList.getFirst(), 51);
        assertEquals(secondImmutableList.getFirst(), 6);
        checkArrays();
    }



    @Test
    public void testGetLast()
    {
        assertEquals(firstImmutableList.getLast(), 51);
        assertEquals(secondImmutableList.getLast(), -27);
        checkArrays();
    }


    public void testRemoveFirst(ImmutableLinkedList lst)
    {
        int index = 0;
        ImmutableLinkedList arr = lst.removeFirst();
        Object[] expected = new Object[lst.size() - 1];
        for (int i = index; i < lst.size() - 1; i++)
        {
            expected[i] = lst.get(i + 1);
        }
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }

    @Test
    public void testRemoveFirst(){
        testRemoveFirst(firstImmutableList);
        testRemoveFirst(secondImmutableList);
    }

    public void testRemoveLast(ImmutableLinkedList lst)
    {
        int index = lst.size() - 1;
        ImmutableLinkedList arr = lst.removeLast();
        Object[] expected = new Object[lst.size() - 1];
        for (int i = 0; i < index; i++)
        {
            expected[i] = lst.get(i);
        }
        for (int j = index; j < lst.size() - 1; j++)
        {
            expected[j] = lst.get(j + 1);
        }
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }

    @Test
    public void testRemoveLast()
    {
        testRemoveLast(firstImmutableList);
        testRemoveLast(secondImmutableList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetError()
    {
        emptyImmutableList.get(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetAnotherError()
    {
        firstImmutableList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetError()
    {
        emptyImmutableList.set(0, 7);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetAnotherError()
    {
        firstImmutableList.set(1, 111);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveError()
    {
        emptyImmutableList.remove(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveAnotherError()
    {
        firstImmutableList.remove(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddError()
    {
        emptyImmutableList.add(1,-10);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddAnotherError()
    {
        firstImmutableList.add(100,55);
    }
}