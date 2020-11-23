package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest
{

    private Stack s;

    @Before
    public void setUp()
    {
        s = new Stack();
    }

    @Test
    public void testStack()
    {
        int[] elements = new int[]{95, 51, 43, 23, 44};

        for (int element : elements)
        {
            s.push(element);
            assertEquals(element, s.peek());
        }

        for (int i = elements.length - 1; i >= 0; i --)
        {
            assertEquals(elements[i], s.peek());
            assertEquals(elements[i], s.pop());
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testError()
    {
        s.peek();
    }
    
}
