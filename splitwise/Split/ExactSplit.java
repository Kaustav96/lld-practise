package interview.practise.lld.splitwise.Split;

import interview.practise.lld.splitwise.User;

public class ExactSplit extends Split{
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
