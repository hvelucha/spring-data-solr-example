package au.edu.parentPortal.fixtures;

/**
 * Created by hveluchamy on 27/11/2014.
 */

import au.edu.parentPortal.test.manager.TearDownManager;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;
import org.springframework.orm.hibernate4.HibernateOperations;

import static au.edu.parentPortal.fixtures.SpringWirer.getBean;

public class FixtureSupport {

    private HibernateOperations hibernateTemplate;
    private SimpleJdbcOperations jdbcTemplate;


    private SessionFactory sessionFactory;

    public static final String JdbcTemplate = "jdbcTemplate";

    private static final String CmsCarouselDao = "carouselDao";
    private static final String CMSVersionDao = "cmsVersionDao";

    private TearDownManager tearDownManager;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = getBean("sessionFactory");
        }
        return sessionFactory;
    }



    public HibernateOperations getHibernateTemplate() {
        if (hibernateTemplate == null) {
            hibernateTemplate = getBean("hibernateTemplate");
        }
        return hibernateTemplate;
    }

    public TearDownManager tearDownManager() {
        if(tearDownManager ==null) {
            tearDownManager = getBean(TearDownManager.class);
        }
        return tearDownManager;
    }

    public SimpleJdbcOperations getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = getBean(JdbcTemplate);
        }
        return jdbcTemplate;
    }




}
