import java.util.*;

class VectorStack<T> implements Stack<T> {
    private Vector<T> stack;

    public VectorStack() {
        stack = new Vector<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.lastElement();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}