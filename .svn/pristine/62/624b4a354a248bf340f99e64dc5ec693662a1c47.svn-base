package au.edu.parentPortal.fixtures.Column;

import au.edu.parentPortal.fixtures.FailureException;
import au.edu.parentPortal.fixtures.FitClosure;
import au.edu.parentPortal.fixtures.FitConstants;
import fit.ColumnFixture;


/**
 * Created by hveluchamy on 27/11/2014.
 */
public class AbstractColumnFixture extends ColumnFixture {
   // protected StopWatch stopWatch;

    //private final Logger LOG = LogManager.getLogger(AbstractColumnFixture.class);
    protected String getSuccessValue() {
        return FitConstants.SuccessResult.OK.name();
    }

    public String execute(final FitClosure closure) {
       // stopWatch.start();
        try {
            closure.execute();
            return getSuccessValue();
        } catch (FailureException e) {
            final String msg = e.getMessage();
            //log.info("FailureException encountered with message: " + msg, e);
            return (msg == null) ? FitConstants.SuccessResult.FAIL.name() : msg;
        } catch (Exception e) {
            //log.info("Encountered exception in fitnesse test", e);
            return String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
        } finally {
           // stopWatch.stop();
        }
    }

    public String setUp() throws FailureException {
        return getSuccessValue();
    }
}
