import java.util.List;

public class BSTreeOrderByScore {
    private class BSTNode {
        Player player;
        BSTNode left;
        BSTNode right;
        int rCount;

        public BSTNode(Player player) {
            this.player = player;
            this.left = null;
            this.right = null;
            this.rCount = 0;
        }
    }

    BSTNode root;

    public BSTreeOrderByScore(List list) {
        for (Object p: list) {
            Player player = (Player) p;
            insert(player);
        }
    }

    // insert new Player to the binary search tree ordered by player score
    public void insert(Player p) {
        root = insert(root, p);
    }

    // helper method: insert new Player to the binary search tree ordered by player score
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

    public int getMax() {
        return getMax(root);
    }

    public int getMax(BSTNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.player.playerId;
    }

    // find the min node under the deleted node
    public Player getMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.player;
    }

    // found the original player score in the binary search tree ordered by id
    public int search(BSTreeOrderById tree, int id) {
        return tree.search(id);
    }

    // update the tree if the score is higher
    public boolean update(BSTreeOrderById tree, int id, int score) {
        int originalScore = search(tree, id);
        if (originalScore < score) {
            root = delete(root, originalScore);
            insert(new Player(id, score));
            return true;
        }
        return false;
    }

    public BSTNode delete(BSTNode node, int score) {
        if (node == null) {
            return null;
        }
        // found the node we want to delete
        if (score < node.player.score) {
            node.left = delete(node.left, score);
        } else if (score > node.player.score) {
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

    // get the player who is at the required position
    public int getKthPosition(int k) {
        return getKthPosition(root, k).playerId;
    }

    // get the player who is at the required position
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
