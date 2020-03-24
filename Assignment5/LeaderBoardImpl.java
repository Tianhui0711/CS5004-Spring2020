import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderBoardImpl implements LeaderBoard {
    BSTreeOrderById bsTree;
    SegmentTree sTree;
    BSTreeOrderByScore bsTree2;

    // construct a LeaderBoardImpl
    public LeaderBoardImpl(List playerInfo) {
        // construct a binary search tree ordered by player id
        bsTree = new BSTreeOrderById(playerInfo);

        // create a new list of playerInfo and sort it by player id
        List<Player> orderInfo = new ArrayList<>();
        for (Object p: playerInfo) {
            Player player = (Player) p;
            orderInfo.add(player);
        }
        Collections.sort(orderInfo);
        // construct a segment tree
        sTree = new SegmentTree(orderInfo);

        // construct a second binary search tree ordered by player score
        bsTree2 = new BSTreeOrderByScore(playerInfo);
    }

    /**
     * Given a player id, return the player’s score
     * @param id the player id
     * @return the player's score
     */
    @Override
    public int scoreQuery(int id) {
        return bsTree.search(id);
    }

    /**
     * Update the player's score if it is higher than the exist score
     * @param id the player id
     * @param score the new score
     * @return Return true if the update succeeded and false if failed
     */
    @Override
    public boolean update(int id, int score) {
        // Must first update: the second BST ordered by score
        // because it replies on the original BST to get the original score
        // then update BST ordered by id and segment tree
        return bsTree2.update(bsTree, id, score) && bsTree.update(id, score) && sTree.update(id, score);
    }

    /**
     * Get the highest score within the range of given id
     * @param low_id the lower bound of id
     * @param high_id the upper bound of id
     * @return the highest score within the range
     */
    @Override
    public int rangeHighestQuery(int low_id, int high_id) {
        return sTree.maxRange(low_id, high_id);
    }

    /**
     * Return the id of the player who has the highest score
     * @return the player id
     */
    @Override
    public int getTopOne() {
        return bsTree2.getMax();
    }

    /**
     * Return the id of the player who ranks at a given position
     * @param pos the rank of the player
     * @return the player id
     */
    @Override
    public int playerIdAtPosition(int pos) {
        return bsTree2.getKthPosition(pos);
    }

    // test code
    public static void main(String[] args) {
        Player p1 = new Player(45, 82); // 1st arg: playerId, 2nd arg: score
        Player p2 = new Player(127, 86);
        Player p3 = new Player(21, 77);
        Player p4 = new Player(1002, 84);
        Player p5 = new Player(10, 56);
        Player p6 = new Player(98, 57);

        List<Player> playerInfo = new ArrayList<>();
        playerInfo.add(p1);
        playerInfo.add(p2);
        playerInfo.add(p3);
        playerInfo.add(p4);
        playerInfo.add(p5);
        playerInfo.add(p6);

        LeaderBoard board = new LeaderBoardImpl(playerInfo);
        System.out.println(board.scoreQuery(1002));
        System.out.println(board.rangeHighestQuery(20,200));
        System.out.println(board.getTopOne());

        System.out.println();
        System.out.println(board.playerIdAtPosition(1));
        System.out.println(board.playerIdAtPosition(2));
        System.out.println(board.playerIdAtPosition(3));
        System.out.println(board.playerIdAtPosition(4));
        System.out.println(board.playerIdAtPosition(5));
        System.out.println(board.playerIdAtPosition(6));
        System.out.println();

        board.update(21, 98);
        System.out.println(board.scoreQuery(21));
        System.out.println(board.rangeHighestQuery(20,200));
        System.out.println(board.getTopOne());

        System.out.println();
        System.out.println(board.playerIdAtPosition(1));
        System.out.println(board.playerIdAtPosition(2));
        System.out.println(board.playerIdAtPosition(3));
        System.out.println(board.playerIdAtPosition(4));
        System.out.println(board.playerIdAtPosition(5));
        System.out.println(board.playerIdAtPosition(6));
        System.out.println();
    }
}
