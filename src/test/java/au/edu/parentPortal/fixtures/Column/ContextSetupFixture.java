package au.edu.parentPortal.fixtures.Column;

import au.edu.parentPortal.fixtures.FailureException;
import au.edu.parentPortal.fixtures.FitClosure;
import au.edu.parentPortal.fixtures.SpringWirer;
import org.springframework.util.StringUtils;

/**
 * Created by hveluchamy on 27/11/2014.
 */
public class ContextSetupFixture extends AbstractColumnFixture {
    public String contextFiles;


    @Override
    public String setUp() throws FailureException {
        FitClosure setup = new FitClosure() {

            public void execute() throws FailureException {
                String[] contextFileArray;
                contextFileArray = StringUtils.split("WEB-INF/applicationContext.xml", ",");
                SpringWirer.initialiseContext(contextFileArray);
            }
        };

        return execute(setup);
    }
}
