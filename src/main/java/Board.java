import lombok.Data;

@Data
public class Board {

    private int redCoins;
    private int blackCoins;
    private Player player;

    public Board() {
        redCoins = 1;
        blackCoins = 9;
    }

    public void strike() {
        if(blackCoins == 0)
            return;
        player.updateScore(1);
        blackCoins--;
        player.resetSuccessiveNoStrikes();
    }

    public void multiStrike() {
        if(blackCoins < 2)
            return;
        player.updateScore(2);
        blackCoins = 7;
        redCoins = 1;
        player.resetSuccessiveNoStrikes();
    }

    public void redStrike() {
        if(redCoins == 0)
            return;
        player.updateScore(3);
        redCoins = 0;
        player.resetSuccessiveNoStrikes();
    }

    public void strikerStrike() {
        player.updateScore(-1);
        player.incrementFoulCount();
        player.resetSuccessiveNoStrikes();
    }

    public void defunctCoin() {
        if(blackCoins == 0)
            return;
        player.updateScore(-2);
        blackCoins--;
        player.incrementFoulCount();
        player.resetSuccessiveNoStrikes();
    }

    public void noStrike() {
        player.incrementSuccessiveNoStrikes();
    }
}
