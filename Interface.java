import java.util.ArrayList;

public class Interface {
    private String accountnumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Interface(String accountnumber){
        this.accountnumber=accountnumber;
        this.balance=0;
        this.transactions=new ArrayList<>();
    }

    public void deposit(double amount){
        balance+=amount;
        transactions.add(new Transaction("Deposit",amount));
    }

    public void withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
            transactions.add(new Transaction("Withdraw",amount));
        }else{
            System.out.println("Insufficient Balance");
        }
    }

    public void transfer(Interface recipient,double amount){
        if(balance>=amount){
            balance-=amount;
            recipient.deposit(amount);
            System.out.println("Amount transferred.");
            transactions.add(new Transaction("Transfer to "+recipient.getAccountNumber(),amount));
        }else{
            System.out.println("Insufficient Balance");
        }
    }

    public void displayTransactionhistory(){
        System.out.println("Transaction History: ");
        for(Transaction transaction:transactions){
            System.out.println(transaction);
        }
    }

    public String getAccountNumber(){
        return accountnumber;
    }

    public double getBalance(){
        return balance;
    }
}