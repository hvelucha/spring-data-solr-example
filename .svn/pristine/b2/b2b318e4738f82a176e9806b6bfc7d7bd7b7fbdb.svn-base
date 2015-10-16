package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.beans.Activities;
import au.edu.parentPortal.dao.ActivityDao;
import au.edu.parentPortal.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hveluchamy on 6/10/2015.
 */
public class ActivityDaoImpl extends DaoImpl<Activities> implements ActivityDao {
    private Logger LOG = LogManager.getLogger(ActivityDaoImpl.class);

    @Override
    public List<Activities> getAllActivities() throws DaoException {
        Session s = sessionFactory.getCurrentSession();
        List<Activities> activitiesList = new ArrayList<>();
        try{
            String query = "from Activities a order by a.id desc";
        } catch (Exception e) {
            LOG.error("Unable to retrieve activities list", e);
        }
        return activitiesList;
    }

    @Override
    public Class<Activities> getModelClass() {
        return Activities.class;
    }
}
