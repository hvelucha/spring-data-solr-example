package au.edu.parentPortal.dao;

import au.edu.parentPortal.beans.EverydayIdeaSolr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * Created by hveluchamy on 14/10/2015.
 */
public interface EverydayIdeaRepository extends SolrCrudRepository<EverydayIdeaSolr, String> {

  /* List<EverydayIdeaSolr> findByManu(String topic);

   List<EverydayIdeaSolr> findByName(String topic);

    Page<EverydayIdeaSolr> findByName(String name, Pageable pageable);*/

    // List<EverydayIdeaSolr> findByDescription(String topic);

    // List<EverydayIdeaSolr> findById(String id);

     List<EverydayIdeaSolr> findByTitle(String name);



    Page<EverydayIdeaSolr> findByTitle(String name, Pageable pageable);
}
