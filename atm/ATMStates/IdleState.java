package interview.practise.lld.atm.ATMStates;

import interview.practise.lld.atm.ATM;
import interview.practise.lld.atm.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}

