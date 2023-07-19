public class SBIBank implements RBIBankSystem{

    private String accNo;

    private String passCode;

    private Double balance;

    private double rateOfInterest = 6;

    private Integer minimumBalance = 500;

    public SBIBank(String accNo, String passCode, double balance) {
        this.accNo = accNo;
        this.passCode = passCode;
        this.balance = balance;
    }

    @Override
    public String depositMoney(int money) {
        if(money > 0){
            balance = balance + money;
            return "Money :" + money + "has been added to your account. Total " + "balance is" + balance;
        }else{
            return "Money entered is negative";
        }
    }

    @Override
    public String withdrawMoney(int money, String password) {
        if(password.equals(this.passCode)){
            if(balance - minimumBalance > money){
                balance = balance - money;
                return "Money: " + money + "has been withdrawn. Remaining balance is "+ balance;
            }else{
                return "Insufficient Balance. Minimum balance that needs to supported is " + minimumBalance;
            }
        }else{
            return "Wrong password entered";
        }
    }

    @Override
    public String checkBalance(String password) {
        if(this.passCode.equals(password)){
            return "The balance is "+ this.balance;
        }else{
            return "Wrong password entered";
        }
    }

    @Override
    public Double calculateTotalInterest(int time) {
        Double simpleInterest = (balance * time * rateOfInterest)/100;
        return simpleInterest;
    }














}
