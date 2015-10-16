package au.edu.parentPortal.dao;

import au.edu.parentPortal.beans.audit.GameAudit;
import au.edu.parentPortal.exceptions.DaoException;

import java.util.List;

/**
 * Created by hveluchamy on 6/10/2015.
 */
public interface GameAuditDao {
    public List<GameAudit> getGameAudit(long gameId) throws DaoException;

    public void create(GameAudit gameAudit) throws DaoException;
}
