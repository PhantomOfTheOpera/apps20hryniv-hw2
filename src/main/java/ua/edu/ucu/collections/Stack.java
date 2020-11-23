package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class Stack
{
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public Object peek()
    {
        return stack.getFirst();
    }

    public Object pop()
    {
        Object peakedElement = stack.getFirst();
        stack = stack.removeFirst();

        return peakedElement;
    }

    public void push(Object e)
    {
        stack = stack.addFirst(e);
    }

}
