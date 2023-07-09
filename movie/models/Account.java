package interview.practise.lld.movie.models;
import interview.practise.lld.movie.enums.AccountStatus;
public class Account {
    private String id;
    private String password;
    private AccountStatus status;

    /**
     * Reset account password.
     * @return
     */
    public boolean resetPassword() {
        return true;
    }
}
