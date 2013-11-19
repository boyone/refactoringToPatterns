package refactoringToPatterns.banking;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class CapitalCalculationTests {

    private int commitment;
    private int riskRating;
    private Date maturity;
    private Date expiry;
    private CapitalStrategy riskAdjustedCapitalStrategy;

    @Before
    public void setup() {
        //given
        commitment = 1;
        riskRating = 1;
        maturity = new Date();
        expiry = new Date();
        riskAdjustedCapitalStrategy = new RiskAdjustedCapitalStrategy();

    }

    @Test
    public void shouldCreateTermLoanInstance() {
        //when
        Loan termLoan = Loan.createTermLoan(commitment, riskRating, maturity);

        //then
        assertNotNull(termLoan);
        assertEquals(CapitalStrategyTermLoan.class, termLoan.getCapitalStrategy().getClass());
    }

    @Test
    public void shouldCreateRevolverLoanInstance() {
        //when
        Loan revolverLoan = Loan.createRevolverLoan(commitment, riskRating, expiry);

        //then
        assertNotNull(revolverLoan);
        assertEquals(CapitalStrategyRevolver.class, revolverLoan.getCapitalStrategy().getClass());
    }

    @Test
    public void shouldCreateRCTLInstance() {
        //when
        Loan rctlLoan = Loan.createRCTL(commitment, riskRating, maturity, expiry);

        //then
        assertNotNull(rctlLoan);
        assertEquals(CapitalStrategyRCTL.class, rctlLoan.getCapitalStrategy().getClass());
    }

    @Test
    public void shouldCreateTermLoanWithRiskAdjustedCapitalStrategy() {
        //when
        Loan termLoan = Loan.createTermLoan(riskAdjustedCapitalStrategy, commitment, riskRating, maturity);

        //then
        assertNotNull(termLoan);
        assertEquals(RiskAdjustedCapitalStrategy.class, termLoan.getCapitalStrategy().getClass());
    }

    @Test
    public void shouldCreateRevolverLoanWithRiskAdjustedCapitalStrategy() {
        //when
        Loan revolverLoan = Loan.createRevolverLoan(riskAdjustedCapitalStrategy, commitment, riskRating, expiry);

        //then
        assertNotNull(revolverLoan);
        assertEquals(RiskAdjustedCapitalStrategy.class, revolverLoan.getCapitalStrategy().getClass());
    }

}
