package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.beans.Game;
import au.edu.parentPortal.dao.GameDao;
import au.edu.parentPortal.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hveluchamy on 6/10/2015.
 */
public class GameDaoImpl extends DaoImpl<Game> implements GameDao {
    private Logger LOG = LogManager.getLogger(GameDaoImpl.class);

    @Override
    public Class<Game> getModelClass() {
        return Game.class;
    }

    @Override
    public List<Game> getAllGames() throws DaoException {
        Session s = sessionFactory.getCurrentSession();
        List<Game> games = new ArrayList<>();
        try {
            String query = "from Game g order by g.id desc";
        } catch (Exception e) {
            LOG.error("Unable to retrieve Games list", e);
        }
        return games;
    }
}
