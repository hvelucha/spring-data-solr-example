package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.beans.EverydayIdea;
import au.edu.parentPortal.beans.EverydayIdeaSolr;
import au.edu.parentPortal.dao.BookRepositoryMethods;
import au.edu.parentPortal.dao.EverydayIdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hveluchamy on 13/10/2015.
 */
@Service
public class BookRepositoryMethodsImpl implements BookRepositoryMethods{

    @Autowired
    private EverydayIdeaRepository everydayIdeaRepository;

    public List<EverydayIdeaSolr> getEverydayIdeaByTopic(String topic) {
        //return everydayIdeaRepository.findByTitle(topic);
        return null;
    }

    public Page<EverydayIdeaSolr> getEverydayIdeaSolrByPage(String capability) {
        //return everydayIdeaRepository.findByTopic(capability, new PageRequest(0, 10));
        return null;
    }

    public Page<EverydayIdeaSolr> otherMethods(){
        return everydayIdeaRepository.findAll(new PageRequest(0,30));
    }



    public Iterable<EverydayIdeaSolr> getAll() {
        return everydayIdeaRepository.findAll();
    }




}

