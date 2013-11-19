package refactoringToPatterns.banking;

import java.util.Date;
import java.util.Set;

public class Loan {
    private double commitment;
    private double outstanding;
    private int riskRating;
    private Date maturity;
    private Date expiry;
    private CapitalStrategy capitalStrategy;
    private double unusedPercentage;
    private Set<Payment> payments;
    private Date today;
    private Date start;

    public Loan(double commitment, double outstanding,
                int customerRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, customerRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment,
                double outstanding, int riskRating,
                Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;

        if (capitalStrategy == null) {
            if (expiry == null)
                this.capitalStrategy = new CapitalStrategyTermLoan();
            else if (maturity == null)
                this.capitalStrategy = new CapitalStrategyRevolver();
            else
                this.capitalStrategy = new CapitalStrategyRCTL();
        }
    }

    public static Loan createTermLoan(int commitment, int riskRating, Date maturity) {
        return new Loan(commitment, 0.00, riskRating, maturity, null);
    }

    public static Loan createRevolverLoan(int commitment, int riskRating, Date expiry) {
        return new Loan(commitment, 0.00, riskRating, null, expiry);
    }

    public static Loan createRCTL(int commitment, int riskRating, Date maturity, Date expiry) {
        return new Loan(commitment, 0.00, riskRating, maturity, expiry);
    }

    public static Loan createTermLoan(CapitalStrategy riskAdjustedCapitalStrategy, int commitment, int riskRating, Date maturity) {
        return new Loan(riskAdjustedCapitalStrategy, commitment, 0.0, riskRating, maturity, null);
    }

    public double getCommitment() {
        return commitment;
    }

    public void setCommitment(double commitment) {
        this.commitment = commitment;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(double outstanding) {
        this.outstanding = outstanding;
    }

    public int getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(int riskRating) {
        this.riskRating = riskRating;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public CapitalStrategy getCapitalStrategy() {
        return capitalStrategy;
    }

    public void setCapitalStrategy(CapitalStrategy capitalStrategy) {
        this.capitalStrategy = capitalStrategy;
    }

    public double getUnusedPercentage() {
        return unusedPercentage;
    }

    public void setUnusedPercentage(double unusedPercentage) {
        this.unusedPercentage = unusedPercentage;
    }

    public double duration() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

    public double outstandingRiskAmount() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

    public double unusedRiskAmount() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }


    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
