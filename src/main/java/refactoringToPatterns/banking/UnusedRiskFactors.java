package refactoringToPatterns.banking;

/**
 * Created with IntelliJ IDEA.
 * User: Thawatchai Jongsuwanpaisan
 * Date: 11/18/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnusedRiskFactors implements Factor {

    @Override
    public double forRating(int riskRating) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static UnusedRiskFactors getFactors() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
