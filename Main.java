import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println("Which bank you want to open an account");
        System.out.println("Print 1 to create in Lotak and 2 to create in SBI");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        System.out.println("Enter password and initial deposit");
        int password = sc.nextInt();
        Integer initialBalance = sc.nextInt();
        double account = Math.abs(Math.random()*Math.pow(10,9));
        //Your task : function that generates
        // 9 digits no randomly for accountNo
        String stringVersion = String.valueOf(account);

        RBIBankSystem bankAccount;
        if(option == 1){


            bankAccount = new LotakBank(stringVersion, String.valueOf(password), initialBalance);
        }else{
            bankAccount = new SBIBank(stringVersion, String.valueOf(password), initialBalance);
        }

        System.out.println("Press 1. For Withdraw");
        System.out.println("Press 2. For Deposit");
        System.out.println("Press 3. For checking balance");
        System.out.println("Press 4. for Interest rate");
        int x = sc.nextInt();

        switch (x){
            case 1:
                System.out.println("How much do you want to withdraw");
                System.out.println("recommand : ");
                System.out.println("1. 2000");
                System.out.println("2. 10000");
                System.out.println("3. Manual amount");
                int y = sc.nextInt();
                System.out.println("Enter Your passCode : ");
                int passCode = sc.nextInt();
                switch (y){

                    case 1:
                        String ans = bankAccount.withdrawMoney(2000, String.valueOf(passCode));
                        System.out.println(ans);
                        break;
                    case 2:
                        String ans1 = bankAccount.withdrawMoney(10000, String.valueOf(passCode));
                        System.out.println(ans1);
                        break;
                    case 3:
                        System.out.println("Enter your amount");
                        int amount = sc.nextInt();
                        String ans2 = bankAccount.withdrawMoney(amount, String.valueOf(passCode));
                        System.out.println(ans2);
                        break;
                }
                break;
            case 2:
                System.out.println("Enter amount to deposit : ");
                int deposit = sc.nextInt();
                String ans4 = bankAccount.depositMoney(deposit);
                System.out.println(ans4);
                break;
            case 3:
                System.out.println("Enter your passcode : ");
                int passCode1 = sc.nextInt();
                String ans5 = bankAccount.checkBalance(String.valueOf(passCode1));
                System.out.println(ans5);
                break;
            case 4:
                System.out.println("for How many years you want to keep this amount :");
                int time = sc.nextInt();
                double ans6 = bankAccount.calculateTotalInterest(time);
                System.out.println(ans6);
                break;
        }

    }



}
