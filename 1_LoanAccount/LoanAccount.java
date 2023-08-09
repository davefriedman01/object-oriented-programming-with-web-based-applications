public class LoanAccount {
  public static double annualInterestRate;
  private       double principal;

  public LoanAccount () {
    this(0.0);
  }
  public LoanAccount (double principal) {
    this.principal = principal;
  }

  public static void setAnnualInterestRate (double newInterestRate) {
    annualInterestRate = newInterestRate;
  }

  public double calculateMonthlyPayment (int numberOfPayments) {
    double monthlyInterest = annualInterestRate / 12;
    double monthlyPayment  = this.principal * (monthlyInterest / (1 - Math.pow(1 + monthlyInterest, -numberOfPayments)));
    return monthlyPayment;
  }

  public static void main (String[] args) {
    LoanAccount loan1 = new LoanAccount( 5000);
    LoanAccount loan2 = new LoanAccount(31000);

    double      interestRates[] = {0.01, 0.05};
    LoanAccount loans[]         = {loan1, loan2};

    for (double interestRate : interestRates) {
      System.out.printf("%n%nMonthly payments for loan1 of $5000.00 and loan2 of $31000.00 for 3, 5, and 6 year loans at %.0f%% interest.", interestRate * 100);
      System.out.printf("%n%-7s\t%-7s\t%-7s\t%-7s", "Loan", "3 years", "5 years", "6 years");
      
      for (LoanAccount loan : loans) {
        LoanAccount.setAnnualInterestRate(interestRate);
        System.out.printf(
          "%n%-7s\t%-7.2f\t%-7.2f\t%-7.2f", "Loan1",
          loan.calculateMonthlyPayment(36),
          loan.calculateMonthlyPayment(60),
          loan.calculateMonthlyPayment(72)
        );
      }
    }
  }
}
