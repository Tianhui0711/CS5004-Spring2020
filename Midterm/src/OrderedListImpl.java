import java.util.Objects;

public class OrderedListImpl implements OrderedList {
    private Node head;
    private int lengthLimit;

    public OrderedListImpl(Node head, int lengthLimit) {
        this.head = head;
        this.lengthLimit = lengthLimit;
    }

    public int getMin() throws IllegalStateException {
        if (size() == 0) {
            throw new IllegalStateException("The ordered list is empty.");
        }
        return this.head.getValue();
    }

    public int getMax() throws IllegalStateException {
        if (size() == 0) {
            throw new IllegalStateException("The ordered list is empty.");
        }
        Node p = head;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        return p.getValue();
    }

    public double getMedian() throws IllegalStateException {
        if (size() == 0) {
            throw new IllegalStateException("The ordered list is empty.");
        }
        int med = 0;
        Node p = head;
        while (med < (size() - 1)  / 2) {
            med += 1;
            p = p.getNext();
        }
        if (size() % 2 == 0) {
            return (double) (p.getValue() + p.getNext().getValue()) / 2;
        }
        return p.getValue();
    }

    public void add(int val) {
        if (head == null && size() < lengthLimit) {
            head = new Node(val);
            return;
        }

        if (size() == lengthLimit) {
            if (val > head.getValue()) {
                Node p = head;
                while (p.getValue() < val && p.getNext() != null) {
                    p = p.getNext();
                }
                Node newNext = new Node(val,p.getNext());
                p.addNext(newNext);
                Node temp = head;
                head = temp.getNext();
                return;
            }
        } else {
            Node p = head;
            if (p.getValue() > val) {
                head = new Node(val);
                head.addNext(p);
            } else {
                while (p.getValue() < val) {
                    if (p.getNext() == null) {
                        break;
                    }
                    if (p.getNext().getValue() > val) {
                        break;
                    }
                    p = p.getNext();
                }
                Node newNext = new Node(val, p.getNext());
                p.addNext(newNext);
            }
            return;
        }
    }

    public OrderedList merge(OrderedList other) {
        Node p1 = this.head;
        OrderedListImpl that = (OrderedListImpl) other;
        Node p2 = that.head;
        int length = this.lengthLimit + that.lengthLimit;
        OrderedList mergeList = new OrderedListImpl(null, length);
        while (p1 != null) {
            mergeList.add(p1.getValue());
            p1 = p1.getNext();
        }
        while (p2 != null) {
            mergeList.add(p2.getValue());
            p2 = p2.getNext();
        }
        return mergeList;
    }

    public void remove(int val) {
        if (val == head.getValue()) {
            head = head.getNext();
            return;
        }

        Node p = head;
        while (p.getNext() != null) {
            if (val == p.getNext().getValue()) {
                p.addNext(p.getNext().getNext());
                return;
            }
            p = p.getNext();
        }
    }

    public void removeAll(int cap) {
        if (head.getValue() >= cap) {
            head = null;
            return;
        }

        Node p = head;
        while (p.getNext().getValue() < cap) {
            p = p.getNext();
        }
        p.addNext(null);
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public OrderedList intersection(OrderedList other) {
        return null;
    }

    public OrderedList union(OrderedList other) {
        return null;
    }

    public int size() {
        int size = 0;
        Node p = head;
        while (p != null) {
            size += 1;
            p = p.getNext();
        }
        return size;
    }

    @Override
    public String toString() {
        if (head == null && lengthLimit == 0) {
            return "[]";
        }

        String s = "[";
        Node p = head;
        while (p != null) {
            s += p.getValue() + " ";
            p = p.getNext();
        }
        if (size() < lengthLimit) {
            for (int i = 0; i < lengthLimit - size(); i++) {
                s += "?";
            }
        }
        s = s.trim();
        s += "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedListImpl that = (OrderedListImpl) o;
        int sum1 = 0;
        int sum2 = 0;
        Node p1 = this.head;
        Node p2 = that.head;
        while (p1 != null) {
            sum1 += p1.getValue();
            p1 = p1.getNext();
        }
        while (p2 != null) {
            sum2 += p2.getValue();
            p2 = p2.getNext();
        }
        return lengthLimit == that.lengthLimit && sum1 == sum2;
    }
}