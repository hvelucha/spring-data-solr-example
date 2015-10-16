package au.edu.parentPortal.util;

import au.edu.parentPortal.fixtures.FailureException;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;

/**
 * Created by hveluchamy on 28/11/2014.
 */
public class TearDownUtil {
    public static void cleanCMSDatabase(SimpleJdbcOperations jdbcTemplate) {
        Exception reason = null;
        try {
            jdbcTemplate.update("delete from Carousels where id not in (1,2)");
            jdbcTemplate.update("delete from cms_version where id not in (1,2,3,4,5,6)");
            jdbcTemplate.update("delete from cms_version_audit");
        } catch (Exception e) {
            throw new FailureException("Failed to tear down database", e);
        }
    }
}
