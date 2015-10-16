package au.edu.parentPortal.fixtures;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hveluchamy on 27/11/2014.
 */
public class SpringWirer {
    private static ClassPathXmlApplicationContext context;

    /**
     * Initialises the <code>ApplicationContext</code>
     *
     * @param configs
     */
    public static void initialiseContext(final String[] configs){
        if(context == null){
            context = new ClassPathXmlApplicationContext(new String[] {
                    "WEB-INF/fitnesse-config.xml"});
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(final String name) {
        return (T) context.getBean(name);
    }

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }
}

/*"au/edu/scootle/resources/applicationContext.xml",
                "au/edu/scootle/resources/dao-context.xml",
                "au/edu/scootle/resources/hibernate-context.xml",
                "au/edu/scootle/resources/manager-context.xml"*/