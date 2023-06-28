package interview.practise.lld.snakesLadder;

import interview.practise.lld.snakesLadder.model.Ladder;
import interview.practise.lld.snakesLadder.model.Player;
import interview.practise.lld.snakesLadder.model.Snake;
import interview.practise.lld.snakesLadder.service.SnakeAndLadderService;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        // 100 cells on the board
        // starting position is 00
        // total snakes = 4
        // total ladder = 4
        // define position of snakes & ladder on your own
        // i/p -> roll dice value & current position
        // o/p -> new position
        // program exit as soon as reach 100
        /*
        models -> snake, ladder, board, player
        service -> dice(get dice value), snakeandladder(main game will be played here)
         */
        Scanner scanner = new Scanner(System.in);

        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<Snake>();
        for (int i = 0; i < noOfSnakes; i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadders(ladders);

        snakeAndLadderService.startGame();
    }
}
