package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.beans.audit.ActivitiesAudit;
import au.edu.parentPortal.dao.ActivitiesAuditDao;
import au.edu.parentPortal.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hveluchamy on 6/10/2015.
 */
public class ActivitiesAuditDaoImpl extends DaoImpl<ActivitiesAudit> implements ActivitiesAuditDao {
    private Logger LOG = LogManager.getLogger(ActivitiesAuditDao.class);

    @Override
    public List<ActivitiesAudit> getActivityAudit(long activityId) throws DaoException {
        Session s = sessionFactory.getCurrentSession();
        List<ActivitiesAudit> activitiesAuditList = new ArrayList<>();
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("from ActivitiesAudit a where a.activities = :activities order by a.id desc");
            query.setLong("activities", activityId);
            activitiesAuditList = query.list();
        } catch (Exception e) {
            LOG.error("Unable to retrieve audit list", e);
        }
        return activitiesAuditList;
    }

    @Override
    public Class<ActivitiesAudit> getModelClass() {
        return ActivitiesAudit.class;
    }
}
