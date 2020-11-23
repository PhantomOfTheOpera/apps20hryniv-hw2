package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class ImmutableArrayListTest
{
    private ImmutableArrayList firstList;
    private ImmutableArrayList secondList;
    private ImmutableArrayList emptyList;
    private Object[] firstArray;
    private Object[] secondArray;
    private Object[] emptyArray;

    @Before
    public void setUp() throws Exception
    {
        firstArray = new Object[]{51};
        secondArray = new Object[]{6, 5, 4, 3, 11, 15, -27};
        emptyArray = new Object[0];
        firstList = new ImmutableArrayList(firstArray);
        secondList = new ImmutableArrayList(secondArray);
        emptyList = new ImmutableArrayList();
    }

    public void checkArrays()
    {
        assertArrayEquals(firstList.toArray(), firstArray);
        assertArrayEquals(secondList.toArray(), secondArray);
        assertArrayEquals(emptyList.toArray(), emptyArray);
    }

    public void testAdd(ImmutableArrayList lst, Object value)
    {
        ImmutableArrayList arr = (ImmutableArrayList) lst.add(value);
        Object[] expected = new Object[lst.size() + 1];
        for (int i = 0; i < lst.size(); i++) {
            expected[i] = lst.get(i);
        }
        expected[expected.length - 1] = value;

        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(), expected.length);

    }

    @Test
    public void testAdd()
    {
        testAdd(firstList, 14);
        testAdd(secondList, -88);
        testAdd(emptyList, 0);
        checkArrays();
    }

    public void testAddList(ImmutableArrayList lst, Object[] value)
    {
        ImmutableArrayList arr = (ImmutableArrayList) lst.addAll(value);
        Object[] expected = new Object[lst.size() + value.length];
        for (int i = 0; i < lst.size(); i++) {
            expected[i] = lst.get(i);
        }
        for (int i = 0; i < value.length; i += 1)
            expected[i + lst.size()] = value[i];
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(), expected.length);

    }

    @Test
    public void testAddList()
    {
        testAddList(firstList, new Object[]{60, 120, 314});
        testAddList(secondList, new Object[]{44});
        testAddList(emptyList, new Object[]{0});
        checkArrays();
    }
    public void testAddIndex(ImmutableArrayList lst, Object value, int index)
    {
        ImmutableArrayList arr = (ImmutableArrayList) lst.add(index, value);

        Object[] expected = new Object[lst.size() + 1];
        for (int i = 0; i < index; i++) {
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
        testAddIndex(firstList, 11, 0);

        testAddIndex(secondList, 121, 4);
        checkArrays();
    }

    public void testRemove(ImmutableArrayList lst, int index)
    {
        ImmutableArrayList arr = (ImmutableArrayList) lst.remove(index);
        Object[] expected = new Object[lst.size() - 1];
        for (int i = 0; i < index; i++) {
            expected[i] = lst.get(i);
        }
        for (int i = index; i < lst.size() - 1; i++) {
            expected[i] = lst.get(i + 1);
        }
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }

    @Test
    public void testRemove()
    {
        testRemove(firstList, 0);
        testRemove(secondList, 5);
        checkArrays();

    }
    public void testSet(ImmutableArrayList lst, int index, Object value)
    {
        ImmutableArrayList arr = (ImmutableArrayList) lst.set(index,value);
        Object[] expected = lst.toArray();
        expected[index] = value;
        assertArrayEquals(arr.toArray(), expected);
        assertEquals(arr.size(),expected.length);

    }
    @Test
    public void testSet()
    {
        testSet(firstList, 0, 3);
        testSet(secondList, 3, 6);
        checkArrays();
    }

    @Test
    public void testIndexOf()
    {
        assertEquals(firstList.indexOf(51),0);
        assertEquals(firstList.indexOf(43),-1);

        assertEquals(secondList.indexOf(5),1);
        assertEquals(secondList.indexOf(-27),6);

        assertEquals(emptyList.indexOf(0),-1);
        checkArrays();
    }

    @Test
    public void testSize()
    {
        assertEquals(firstList.size(), firstArray.length);
        assertEquals(secondList.size(), secondArray.length);
        assertEquals(emptyList.size(),emptyArray.length);
    }


    @Test
    public void testEmpty()
    {
        assertFalse(firstList.isEmpty());
        assertFalse(secondList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testString()
    {
        assertEquals(firstList.toString(),"51");
        assertEquals(secondList.toString(),"6, 5, 4, 3, 11, 15, -27");
        assertEquals(emptyList.toString(),"");
    }

    @Test
    public void testClear()
    {
        assertArrayEquals(firstList.clear().toArray(), new Object[0]);
        assertEquals(secondList.clear().toString(),"");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetError()
    {
        emptyList.get(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetError2()
    {
        firstList.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetError()
    {
        emptyList.set(0, 7);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetAnotherError()
    {
        firstList.set(1, 11);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveError()
    {
        emptyList.remove(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveAnotherError()
    {
        firstList.remove(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddError()
    {
        emptyList.add(1,34);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddAnotherError()
    {
        firstList.add(100,55);
    }

}
