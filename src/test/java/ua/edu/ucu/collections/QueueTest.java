package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest
{
    private Queue q;

    @Before
    public void setUp()
    {
        q = new Queue();
    }

    @Test
    public void testQueue()
    {
        int[] elements = new int[]{95, 51, 43, 23, 44};
        for (int element : elements)
        {
            q.enqueue(element);
        }
        for (int element : elements)
        {
            assertEquals(element, q.peek());
            assertEquals(element, q.dequeue());
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)

    public void testError()
    {
        q.peek();
    }
    
}
