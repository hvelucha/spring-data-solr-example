package au.edu.parentPortal.manager;

import au.edu.parentPortal.dao.ActivityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hveluchamy on 6/10/2015.
 */
@Transactional
public class ActivityManager {
    @Autowired
    private ActivityDao activityDao;
    
}
