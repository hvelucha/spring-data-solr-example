package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.beans.audit.GameAudit;
import au.edu.parentPortal.dao.GameAuditDao;
import au.edu.parentPortal.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hveluchamy on 6/10/2015.
 */
public class GameAuditDaoImpl extends DaoImpl<GameAudit> implements GameAuditDao {
    private Logger LOG = LogManager.getLogger(GameAuditDaoImpl.class);

    @Override
    public Class<GameAudit> getModelClass() {
        return GameAudit.class;
    }

    @Override
    public List<GameAudit> getGameAudit(long gameId) throws DaoException {
        Session s = sessionFactory.getCurrentSession();
        List<GameAudit> gameAudits = new ArrayList<>();
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("from GameAudit a where a.game = :game order by a.id desc");
            query.setLong("game", gameId);
            gameAudits = query.list();
        } catch (Exception e) {
            LOG.error("Unable to retrieve audit list", e);
        }
        return gameAudits;
    }
}
