/**
 * Implement a binary search tree ordered by the players' id
 */

import java.util.List;

public class BSTreeOrderById {
    // create a new Node class for this binary search tree
    public class BSTNode extends Node<BSTNode>{
        Player player;

        /**
         * Construct a binary search tree node
         * @param player the Player object
         */
        public BSTNode(Player player) {
            super();
            this.player = player;
        }
    }

    BSTNode root;

    /**
     * Construct a binary search tree ordered by player score
     * @param list the list of Players
     */
    public BSTreeOrderById(List list) {
        for (Object p: list) {
            Player player = (Player) p;
            insert(player);
        }
    }

    /**
     * Insert new Player to the tree ordered by player id
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
        if (p.playerId < root.player.playerId) {
            root.left = insert(root.left, p);
        } else if (p.playerId > root.player.playerId) {
            root.right = insert(root.right, p);
        }
        return root;
    }

    /**
     * Find the Player in the tree
     * @param id the player's id
     * @return the score of the required player
     */
    public int search(int id) {
        return search(root, id).player.score;
    }

    /**
     * Traverse the tree and help find the Player by its id
     * @param node the node start to traverse
     * @param id the player id
     * @return the player node
     */
    public BSTNode search(BSTNode node, int id) {
        if (node.player.playerId == id) {
            return node;
        }
        if (id < node.player.playerId) {
            return search(node.left, id);
        } else {
            return search(node.right, id);
        }
    }

    /**
     * If the score is higher than the existed score, update it; otherwise do nothing
     * @param id the player id
     * @param score the player score
     * @return true if updated successfully, false otherwise
     */
    public boolean update(int id, int score) {
        BSTNode found = search(root, id);
        if (found.player.score < score) {
            found.player.score = score;
            return true;
        }
        return false;
    }
}
