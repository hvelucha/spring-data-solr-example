package au.edu.parentPortal.dao;

import au.edu.parentPortal.beans.audit.EverydayIdeaAudit;
import au.edu.parentPortal.exceptions.DaoException;

import java.util.List;

/**
 * Created by hveluchamy on 6/10/2015.
 */
public interface EverydayIdeaAuditDao {
    public List<EverydayIdeaAudit> getEverydayIdeaAudits(long everydayIdeaId) throws DaoException;

    public void create(EverydayIdeaAudit everydayIdeaAudit) throws DaoException;
}
