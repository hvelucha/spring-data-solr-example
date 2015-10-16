package au.edu.parentPortal.test.manager;

import au.edu.parentPortal.util.TearDownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;
import org.springframework.stereotype.Service;

/**
 * Created by hveluchamy on 28/11/2014.
 */
@Service
public class TearDownManagerImpl implements TearDownManager {
    private final SimpleJdbcOperations jdbcTemplate;

    @Autowired
    public TearDownManagerImpl(@Qualifier("jdbcTemplate") SimpleJdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void tearDownDatabase() {
        TearDownUtil.cleanCMSDatabase(jdbcTemplate);
    }
}

