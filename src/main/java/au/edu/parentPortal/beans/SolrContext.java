package au.edu.parentPortal.beans;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * Created by hveluchamy on 13/10/2015.
 */

@Configuration
@EnableSolrRepositories("au.edu.parentPortal")
public class SolrContext {
    @Bean
    public SolrServer solrServer() {
        return new HttpSolrServer("http://localhost:8983/solr/parentswebsite");
    }
    @Bean
    public SolrTemplate solrTemplate(SolrServer server) throws Exception {
        return new SolrTemplate(server);
    }
}
