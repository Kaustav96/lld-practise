package interview.practise.lld.tictactoe;

public class Driver {
    public static void main(String[] args) {
        TicTacToeService game = new TicTacToeService();
        game.initializeGame();
        System.out.println("game winner is: " + game.startGame());

    }
}
