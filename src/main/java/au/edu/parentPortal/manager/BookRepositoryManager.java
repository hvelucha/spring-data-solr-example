package au.edu.parentPortal.manager;

import au.edu.parentPortal.beans.EverydayIdeaSolr;
import au.edu.parentPortal.dao.BookRepositoryMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by hveluchamy on 13/10/2015.
 */
public class BookRepositoryManager {
    @Autowired
    private BookRepositoryMethods bookRepositoryMethods;

    public List<EverydayIdeaSolr> getEverydayIdeaByTopic(String topic) {
       return bookRepositoryMethods.getEverydayIdeaByTopic(topic);
    }

    public Page<EverydayIdeaSolr> otherMethods() {
        return bookRepositoryMethods.otherMethods();
    }

    public Iterable<EverydayIdeaSolr> getAllEverydayIdeas() {
        return bookRepositoryMethods.getAll();
    }



    public Page<EverydayIdeaSolr> getEverydayIdeaSolrByPage(String capability) {
        return bookRepositoryMethods.getEverydayIdeaSolrByPage(capability);
    }


}
