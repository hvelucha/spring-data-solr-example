package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.beans.audit.EverydayIdeaAudit;
import au.edu.parentPortal.dao.EverydayIdeaAuditDao;
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
public class EverydayIdeaAuditDaoImpl extends DaoImpl<EverydayIdeaAudit> implements EverydayIdeaAuditDao {
    private Logger LOG = LogManager.getLogger(EverydayIdeaAuditDaoImpl.class);

    @Override
    public Class<EverydayIdeaAudit> getModelClass() {
        return EverydayIdeaAudit.class;
    }

    @Override
    public List<EverydayIdeaAudit> getEverydayIdeaAudits(long everydayIdeaId) throws DaoException {
        Session s = sessionFactory.getCurrentSession();
        List<EverydayIdeaAudit> everydayIdeaAudits = new ArrayList<>();
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("from EverydayIdeaAudit a where a.everydayIdea = :everydayIdea order by a.id desc");
            query.setLong("everydayIdea", everydayIdeaId);
            everydayIdeaAudits = query.list();
        } catch (Exception e) {
            LOG.error("Unable to retrieve audit list", e);
        }
        return null;
    }
}
