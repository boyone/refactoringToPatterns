package refactoringToPatterns.banking;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class CapitalCalculationTests {
    @Test
    public void shouldCreateTermLoanInstance() {
        //given
        int commitment = 1;
        int riskRating = 1;
        Date maturity = new Date();

        //when
        Loan termLoan = Loan.createTermLoan(commitment, riskRating, maturity);

        //then
        assertNotNull(termLoan);
        assertEquals(CapitalStrategyTermLoan.class, termLoan.getCapitalStrategy().getClass());
    }

    @Test
    public void shouldCreateRevolverLoanInstance() {
        //given
        int commitment = 1;
        int riskRating = 1;
        Date expiry = new Date();

        //when
        Loan revolverLoan = Loan.createRevolverLoan(commitment, riskRating, expiry);

        //then
        assertNotNull(revolverLoan);
        assertEquals(CapitalStrategyRevolver.class, revolverLoan.getCapitalStrategy().getClass());
    }

    @Test
    public void shouldCreateRCTLInstance() {
        //given
        int commitment = 1;
        int riskRating = 1;
        Date maturity = new Date();
        Date expiry = new Date();

        //when
        Loan rctlLoan = Loan.createRCTL(commitment, riskRating, maturity, expiry);

        //then
        assertNotNull(rctlLoan);
        assertEquals(CapitalStrategyRCTL.class, rctlLoan.getCapitalStrategy().getClass());
    }

    @Test
    public void shouldCreateTermLoanWithRiskAdjustedCapitalStrategy() {
        //given
        int commitment = 1;
        int riskRating = 1;
        Date maturity = new Date();
        CapitalStrategy riskAdjustedCapitalStrategy = new RiskAdjustedCapitalStrategy();

        //when
        Loan termLoan = Loan.createTermLoan(riskAdjustedCapitalStrategy, commitment, riskRating, maturity);

        //then
        assertNotNull(termLoan);
        assertEquals(RiskAdjustedCapitalStrategy.class, termLoan.getCapitalStrategy().getClass());
    }

}
