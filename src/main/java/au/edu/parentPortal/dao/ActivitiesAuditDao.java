package au.edu.parentPortal.dao;

import au.edu.parentPortal.beans.audit.ActivitiesAudit;
import au.edu.parentPortal.exceptions.DaoException;

import java.util.List;

/**
 * Created by hveluchamy on 6/10/2015.
 */
public interface ActivitiesAuditDao {
    public List<ActivitiesAudit> getActivityAudit(long activityId) throws DaoException;

    public void create(ActivitiesAudit activitiesAudit) throws DaoException;
}
