package au.edu.parentPortal.beans.helper;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by hveluchamy on 2/12/2014.
 */
@Component
public class HibernateEventWiring {
    @Autowired
   private SessionFactory sessionFactory;

    @Autowired
     private CreateAtEventListener createAtEventListener;

   @Autowired
   private UpdatedAtEventListener updatedAtEventListener;

    @PostConstruct
    public void registerListeners() {
        EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_COMMIT_INSERT).appendListener(createAtEventListener);
        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListeners(updatedAtEventListener);

    }
}
