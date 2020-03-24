import java.util.List;

public class BSTreeOrderById {
    public class BSTNode {
        Player player;
        BSTNode left;
        BSTNode right;

        public BSTNode(Player player) {
            this.player = player;
            this.left = null;
            this.right = null;
        }
    }

    BSTNode root;

    public BSTreeOrderById(List list) {
        for (Object p: list) {
            Player player = (Player) p;
            insert(player);
        }
    }

    // insert new Player to the binary search tree ordered by player id
    public void insert(Player p) {
        root = insert(root, p);
    }

    // helper method: insert new Player to the binary search tree ordered by player id
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

    // found the Player in the binary search tree
    public int search(int id) {
        return search(root, id).player.score;
    }

    // helper method: found the Player in the binary search tree
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

    // update the tree if the score is higher
    public boolean update(int id, int score) {
        BSTNode found = search(root, id);
        if (found.player.score < score) {
            found.player.score = score;
            return true;
        }
        return false;
    }
}
