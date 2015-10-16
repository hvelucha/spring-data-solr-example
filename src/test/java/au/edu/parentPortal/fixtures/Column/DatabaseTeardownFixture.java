package au.edu.parentPortal.fixtures.Column;

import au.edu.parentPortal.fixtures.FailureException;
import au.edu.parentPortal.fixtures.FitClosure;
import au.edu.parentPortal.fixtures.FixtureSupport;

/**
 * Created by hveluchamy on 28/11/2014.
 */
public class DatabaseTeardownFixture extends AbstractColumnFixture {
    private FixtureSupport fixtureSupport = new FixtureSupport();

    public String tearDown() throws FailureException {
        FitClosure tearDown = new FitClosure() {
            @Override
            public void execute() throws FailureException {
               fixtureSupport.tearDownManager().tearDownDatabase();
            }
        };
        return execute(tearDown);
    }

}
