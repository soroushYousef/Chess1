package Common;

public class Game {
    private User user1;
    private User user2;
    private User winner;
    private User loser;
    private int numberOfMovments;

    public Game(User user1,User user2){
        this.user1 = user1;
        this.user2 = user2;
        numberOfMovments = 0;
    }

    public void setLoser(User loser){
        this.loser = loser;
    }
    public void setWinner(User winner){
        this.winner = winner;
    }
}
