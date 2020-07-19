package Common;

public class Game {
    private User user1;
    private User user2;
    private User winner;
    private User loser;
    private int numberOfMovments;
    private int numberOfPiecesRemoved;

    public Game(User user1,User user2){
        this.user1 = user1;
        this.user2 = user2;
        numberOfMovments = 0;
        numberOfPiecesRemoved = 0;
    }

    public void setLoser(User loser){
        this.loser = loser;
    }
    public void setWinner(User winner){
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o){
        Game game = (Game) o;
        return (game.user1.equals(user1) && game.user2.equals(user2) || (game.user1.equals(user2) && game.user2.equals(user1))  );
    }
    @Override
    public int hashCode(){
        return 31;
    }
    public void addNumberOfPiecesRemoved(){
        numberOfPiecesRemoved++;
    }
    public void addNumberOfMovments(){
        numberOfMovments++;
    }
}
