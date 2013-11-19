package refactoringToPatterns.banking;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertNotNull;

public class CapitalCalculationTests {
    @Test
    public void ShouldGetTermLoanInstance() {
        //given
        int commitment = 1;
        int riskRating = 1;
        Date maturity = new Date();

        //when
        Loan termLoan = new Loan(commitment, riskRating, maturity);

        //then
        assertNotNull(termLoan);
    }

}
