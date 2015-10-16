package au.edu.parentPortal.controllers;

import au.edu.parentPortal.beans.EverydayIdea;
import au.edu.parentPortal.beans.EverydayIdeaSolr;
import au.edu.parentPortal.dao.EverydayIdeaRepository;
import au.edu.parentPortal.exceptions.NotFoundException;
import au.edu.parentPortal.manager.BookRepositoryManager;
import au.edu.parentPortal.manager.EverydayIdeaManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hveluchamy on 5/10/2015.
 */
@Controller
public class EverydayIdeaController extends BaseController {
    private final Logger LOG = LogManager.getLogger(EverydayIdeaController.class);

    @Autowired
    private EverydayIdeaManager everydayIdeaManager;

    @Autowired
    private EverydayIdeaRepository everydayIdeaRepository;

    @Autowired
    private BookRepositoryManager bookRepositoryManager;

    @RequestMapping(value="/everydayIdeas/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody
     public EverydayIdea getEverydayIdeaById(@PathVariable("id") Long id) throws Exception {
        Assert.notNull(id);
        LOG.info("About to retrieve EverydayIdea id [" + id + "]");
        EverydayIdea everydayIdea = everydayIdeaManager.getEverydayIdea(id);
        if(everydayIdea == null) {
            throw new NotFoundException("everydayIdea.id", "EverydayIdea id [" + id + "] not found");
        }

        return everydayIdea;
    }

    @RequestMapping(value="/everydayIdeas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<EverydayIdeaSolr> getEverydayIdeas() throws Exception {
        LOG.error("About to retrieve EverydayIdeas");
        List<EverydayIdea> everydayIdeas = everydayIdeaManager.getAllIdeas();
        List<EverydayIdeaSolr> everydayIdeaSolrs = new ArrayList<>();
        Iterable<EverydayIdeaSolr> everydayIdeaSolrsNow = everydayIdeaRepository.findAll();
        for(EverydayIdeaSolr everydayIdeaSolr : everydayIdeaSolrsNow) {
            everydayIdeaSolrs.add(everydayIdeaSolr);

        }
        Page<EverydayIdeaSolr> everydayIdeaSolrss =everydayIdeaRepository.findByTitle("arcu eu odio tristique", new PageRequest(0, 30));




        LOG.info("got by topic created");

        return everydayIdeaSolrs;

    }



}
