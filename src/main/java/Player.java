import lombok.Data;

@Data
public class Player {

    private int score;
    private int foulCount;
    private int successiveNoStrikes;
    private boolean havingFoulPenalty;
    private boolean havingNoStrikePenalty;

    public Player() {
        score = 0;
        foulCount = 0;
        successiveNoStrikes = 0;
        havingFoulPenalty = false;
        havingNoStrikePenalty = false;
    }

    public void updateScore(int offset) {
        score += offset;
        if(score < 0) score = 0;
    }

    public void resetFoulCount() {
        foulCount = 0;
    }

    public void incrementFoulCount() {
        foulCount++;
        if(foulCount == 3) {
            updateScore(-1);
            havingFoulPenalty = true;
            resetFoulCount();
        }
    }

    public void resetSuccessiveNoStrikes() {
        successiveNoStrikes = 0;
    }

    public void incrementSuccessiveNoStrikes() {
        successiveNoStrikes++;
        if(successiveNoStrikes == 3) {
            updateScore(-1);
            havingNoStrikePenalty = true;
            resetSuccessiveNoStrikes();
        }
    }
}
