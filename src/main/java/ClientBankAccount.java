public class ClientBankAccount {

    private int clientId;

    private int balance;

    public ClientBankAccount(int clientId, int balance) {
        this.clientId = clientId;
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
