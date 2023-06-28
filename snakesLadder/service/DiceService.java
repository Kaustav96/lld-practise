package interview.practise.lld.snakesLadder.service;

import java.util.Random;

public class DiceService {

    private static int MAX_DICE_VALUE = 6;
    private static int MIN_DICE_VALUE = 1;

    public static int getDiceValue(){
        return new Random().nextInt(MAX_DICE_VALUE)+MIN_DICE_VALUE;
    }

}
