package au.edu.parentPortal.dao;

import au.edu.parentPortal.beans.EverydayIdeaSolr;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by hveluchamy on 13/10/2015.
 */
public interface BookRepositoryMethods {

    public List<EverydayIdeaSolr> getEverydayIdeaByTopic(String topic);

    public Iterable<EverydayIdeaSolr> getAll();

    public Page<EverydayIdeaSolr> otherMethods();

    public Page<EverydayIdeaSolr> getEverydayIdeaSolrByPage(String capability);
}
