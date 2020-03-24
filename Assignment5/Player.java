public class Player implements Comparable<Player>{
    int playerId;
    int score;

    public Player(int playerId, int score) {
        this.playerId = playerId;
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        if (this.playerId > o.playerId) {
            return 1;
        } else {
            return -1;
        }
    }
}
