/**
 * Implement a binary search tree ordered by the players' score
 */

import java.util.List;

public class BSTreeOrderByScore {
    // create a new tree node
    private class BSTNode extends Node<BSTNode>{
        Player player;
        int rCount;

        /**
         * Construct a node
         * @param player the player
         */
        public BSTNode(Player player) {
            super();
            this.player = player;
            this.rCount = 0;    // count numbers of nodes that are on its right
        }
    }

    BSTNode root;

    /**
     * Construct a binary search tree ordered by player score
     * @param list the list of Players
     */
    public BSTreeOrderByScore(List list) {
        for (Object p: list) {
            Player player = (Player) p;
            insert(player);
        }
    }

    /**
     * Insert new Player to the tree ordered by player score
     * @param p the Player
     */
    public void insert(Player p) {
        root = insert(root, p);
    }

    /**
     * Traverse the tree and help insert new Player to the tree
     * @param root the root node
     * @param p the Player
     * @return the root node
     */
    public BSTNode insert(BSTNode root, Player p) {
        if (root == null) {
            root = new BSTNode(p);
            return root;
        }
        if (p.score < root.player.score) {
            root.left = insert(root.left, p);
        } else if (p.score > root.player.score) {
            root.right = insert(root.right, p);
            root.rCount++;
        }
        return root;
    }

    /**
     * Get the player who has the maximum score
     * @return the player id
     */
    public int getMax() {
        return getMax(root);
    }

    /**
     * Traverse the tree and find the player who has the maximum score
     * @param node the node which to start traverse
     * @return the id of the player
     */
    public int getMax(BSTNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.player.playerId;
    }

    /**
     * Find the player who has the minimum score under the deleted node
     * @param node the deleted node
     * @return the player node with the minimum score
     */
    public Player getMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.player;
    }

    /**
     * Find the original player score in the binary search tree ordered by id
     * @param tree the original tree ordered by id
     * @param id the id want to find
     * @return the score of the player with the search id
     */
    public int search(BSTreeOrderById tree, int id) {
        return tree.search(id);
    }

    /**
     * If the score is higher than the existed score, delete the original node and
     * insert the node with new score; otherwise, do nothing
     * @param tree the original tree ordered by id
     * @param id the id want to find
     * @param score the score of the player with the search id
     * @return true if updated successfully, false otherwise
     */
    public boolean update(BSTreeOrderById tree, int id, int score) {
        int originalScore = search(tree, id);
        if (originalScore < score) {
            root = delete(root, originalScore);
            insert(new Player(id, score));
            return true;
        }
        return false;
    }

    /**
     * Delete the original node and rearrange the tree
     * @param node the deleted node
     * @param score the player score
     * @return the player node
     */
    public BSTNode delete(BSTNode node, int score) {
        if (node == null) {
            return null;
        }
        // found the node we want to delete
        if (score < node.player.score) {
            node.left = delete(node.left, score);
        } else if (score > node.player.score) {
            node.rCount--;
            node.right = delete(node.right, score);
        } else {
            // if the node does not have any left child
            if (node.left == null) {
                node.rCount--;
                return node.right;
            } else if (node.right == null) {
                // if the node does not have any right child
                return node.left;
            } else {
                // if the node has both left child and right child
                // found the min node on its right child and let if be the node
                node.player = getMin(node.right);
                node.right = delete(node.right, node.player.score);
            }
        }
        return node;
    }

    /**
     * Get the player who is at the required position
     * @param k the position index
     * @return the player id
     */
    public int getKthPosition(int k) {
        return getKthPosition(root, k).playerId;
    }

    /**
     * Traverse the tree and find the kth position player
     * @param node node start to traverse
     * @param k the position index
     * @return the player object
     */
    public Player getKthPosition(BSTNode node, int k) {
        while (node != null) {
            if (node.rCount + 1 == k) {
                return node.player;
            } else if (k > node.rCount) {
                k = k - (node.rCount + 1);
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node.player;
    }
}
