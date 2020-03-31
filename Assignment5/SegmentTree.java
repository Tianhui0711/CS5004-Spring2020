/**
 * Implement a segment tree, which helps find the highest score within a given playerId range
 */

import java.util.List;

public class SegmentTree {
    // create a new node for segment tree
    private class STNode extends Node<STNode>{
        int start;
        int end;
        int max;

        /**
         * Construct a new node for segment tree
         * @param start the start of the range
         * @param end the end of the range
         */
        public STNode(int start, int end) {
            super();
            this.start = start;     // the start of the range
            this.end = end;     // the end of the range
            this.max = 0;   // store the maximum score within the range
        }
    }

    STNode root;

    /**
     * Construct a segment tree with an sorted array
     * @param list
     */
    public SegmentTree(List list) {
        root = buildTree(list, 0, list.size()-1);
    }

    /**
     * Build a segment tree through recursion
     * @param list the list of players
     * @param start the start index of the list
     * @param end the end index of the list
     * @return the root node
     */
    private STNode buildTree(List list, int start, int end) {
        Player p1 = (Player) list.get(start);
        Player p2 = (Player) list.get(end);
        STNode node = new STNode(p1.playerId, p2.playerId);
        // build the segment tree from the leaf
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

    /**
     * Find the maximum score within the range
     * @param start the start of the range
     * @param end the end of the range
     * @return the maximum score within the range
     */
    public int maxRange(int start, int end) {
        return maxRange(root, start, end);
    }

    /**
     * Traverse the tree and find the maximum score within the range
     * @param node the start node
     * @param start the start of the range
     * @param end the end of the range
     * @return the maximum score within the range
     */
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

    /**
     * Search the score in the tree with the required player id
     * @param node the start node
     * @param id the player id
     * @return the required maximum score
     */
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

    /**
     * Update the segment tree if the score is higher than the previous one
     * @param id the player id
     * @param score the player score
     * @return true if successfully update; false otherwise
     */
    public boolean update(int id, int score) {
        if (search(root, id) < score) {
            update(root, id, score);
            return true;
        }
        return false;
    }

    /**
     * Traverse the tree and help find the required maximum score
     * @param node the start node
     * @param id the player id
     * @param score the new score
     */
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
