package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.beans.EverydayIdea;
import au.edu.parentPortal.dao.EverydayIdeaDao;
import au.edu.parentPortal.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hveluchamy on 5/10/2015.
 */
public class EverydayIdeaDaoImpl extends DaoImpl<EverydayIdea> implements EverydayIdeaDao {
    private Logger LOG = LogManager.getLogger(EverydayIdeaDaoImpl.class);

    @Override
    public Class<EverydayIdea> getModelClass() {
        return EverydayIdea.class;
    }

    public List<EverydayIdea> getAllEverydayIdeas() throws DaoException {
        Session s = sessionFactory.getCurrentSession();
        List<EverydayIdea> everydayIdeas = new ArrayList<>();
        try {
            String query = "from EverydayIdea e order by e.id desc";
            everydayIdeas = s.createQuery(query).list();


        } catch (Exception e) {
            LOG.error("Unable to retrieve everydayIdeas list", e);
        }
        return everydayIdeas;
    }

}
