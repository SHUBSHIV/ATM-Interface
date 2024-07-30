import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("ATM INTERFACE");

        Interface i1=new Interface("HB12345");

        boolean isRight=false;
        int attempts=3;

        while(attempts > 0 && !isRight){

            System.out.println("Enter your Username: ");
            String user=sc.next();
            System.out.println("Enter your pin number: ");
            int pin=sc.nextInt();

            if(user.equals("Shubham")&&pin==1234){
                isRight=true;
                System.out.println("Authentication successful!");

                while(true){
                    System.out.println(
                            "1: Transaction History\n" +
                                    "2: Withdraw \n"+
                                    "3: Deposit \n"+
                                    "4: Transfer \n"+
                                    "5: Check Balance \n"+
                                    "6: Quit");
                    System.out.println("Enter your choice: ");
                    int choice=sc.nextInt();
                    switch (choice){
                        case 1: i1.displayTransactionhistory();
                            break;

                        case 2: System.out.print("Enter the amount to withdraw: ");
                            double amount=sc.nextDouble();
                            i1.withdraw(amount);
                            break;

                        case 3: System.out.print("Enter the amount to deposit: ");
                            double depositamount=sc.nextDouble();
                            i1.deposit(depositamount);
                            System.out.println("Deposited Rs." + depositamount + " successfully.");
                            break;

                        case 4: System.out.println("Enter the account number to transfer money to: ");
                            String account=sc.next();
                            System.out.print("Enter amount to transfer: ");
                            double transferamount=sc.nextDouble();
                            i1.transfer(new Interface(account),transferamount);
                            break;

                        case 5: System.out.println("Balance: Rs."+i1.getBalance());
                            break;

                        case 6: System.out.println("Exiting ATM Interface. Thank You!");
                            System.exit(0);

                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    }
                }
            }else{
                attempts--;
                if(attempts>0){
                    System.out.println("Incorrect username or pin number! Attempts left: "+attempts);
                }else{
                    System.out.println("Authentication failed. No attempts left.");
                }
            }
        }
        sc.close();
   }
}
