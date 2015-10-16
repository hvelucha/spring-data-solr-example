package au.edu.parentPortal.manager;

import au.edu.parentPortal.beans.EverydayIdea;
import au.edu.parentPortal.dao.EverydayIdeaDao;
import au.edu.parentPortal.exceptions.DaoException;
import au.edu.parentPortal.exceptions.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hveluchamy on 5/10/2015.
 */
@Transactional
public class EverydayIdeaManager {
    @Autowired
    private EverydayIdeaDao everydayIdeaDao;

    public EverydayIdea getEverydayIdea (long id) throws ManagerException {
        try {
            return everydayIdeaDao.getById(id);
        } catch (DaoException e) {
            throw new ManagerException("Unable to retrieve EverydayIdea by id [" + id + "]. DaoException occured", e);
        }
    }

    public List<EverydayIdea> getAllIdeas() throws ManagerException {
        try {
            return everydayIdeaDao.getAllEverydayIdeas();
        } catch (DaoException e) {
            throw new ManagerException("Unable to retrieve everyday ideas lists. Dao Exception occured", e);
        }
    }
}
