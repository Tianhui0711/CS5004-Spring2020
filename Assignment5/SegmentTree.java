import java.util.List;

public class SegmentTree {
    private class STNode {
        int start;
        int end;
        int max;
        STNode left;
        STNode right;

        public STNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.max = 0;
        }
    }

    STNode root;

    // construct a segment tree with an sorted array
    public SegmentTree(List list) {
        root = buildTree(list, 0, list.size()-1);
    }

    // build a segment tree through recursion
    private STNode buildTree(List list, int start, int end) {
        Player p1 = (Player) list.get(start);
        Player p2 = (Player) list.get(end);
        STNode node = new STNode(p1.playerId, p2.playerId);
        if (start == end) {
            node.max = p1.score;
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(list, start, mid);
            node.right = buildTree(list, mid+1, end);
            node.max = Math.max(node.left.max, node.right.max);
        }
        return node;
    }

    // find the maximum value with the range
    public int maxRange(int start, int end) {
        return maxRange(root, start, end);
    }

    // helper method: find the maximum value with the range
    public int maxRange(STNode node, int start, int end) {
        if (start <= node.start && node.end <= end) {
            return node.max;
        } else {
            if (end < node.right.start) {
                return maxRange(node.left, start, end);
            } else if (start > node.left.end) {
                return maxRange(node.right, start, end);
            } else {
                return Math.max(maxRange(node.left, start, node.left.end), maxRange(node.right, node.right.start, end));
            }
        }
    }

    // search the score in the function for the required player id
    public int search(STNode node, int id) {
        if (node.start == node.end) {
            return node.max;
        }
        if (id < node.right.start) {
            return search(node.left, id);
        } else if (id > node.left.end) {
            return search(node.right, id);
        }
        return node.max;
    }

    // update the segment tree if the score is higher than the previous one
    public boolean update(int id, int score) {
        if (search(root, id) < score) {
            update(root, id, score);
            return true;
        }
        return false;
    }

    // helper method to update
    public void update(STNode node, int id, int score) {
        if (node.start == node.end) {
            node.max = score;
            return;
        }
        if (id < node.right.start) {
            update(node.left, id, score);
        } else if (id > node.left.end) {
            update(node.right, id, score);
        }
        node.max = Math.max(node.left.max, node.right.max);
    }
}
