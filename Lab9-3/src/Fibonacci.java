import java.util.Iterator;

public class Fibonacci implements Iterable<Integer>{
    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new FibonacciIterator();
    }

    private class FibonacciIterator implements Iterator<Integer>{
        private int val0 = 0;
        private int val1 = 1;

        /**
         * Returns {@code true} if the Fibonacci sequence has more elements.
         * @return {@code true} if the Fibonacci sequence has more elements
         */
        @Override
        public boolean hasNext() {
            return true;
        }

        /**
         * Returns the next element in the Fibonacci sequence.
         * @return the next element in the Fibonacci sequence
         */
        @Override
        public Integer next() {
            int temp = val0;
            val0 = val1;
            val1 = temp + val1;
            return temp;
        }
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        // stops after a couple dozen values have been returned
        for (int i : fib) {
            if (i > 100) {
                break;
            } else {
                System.out.println(i);
            }
        }
    }
}
