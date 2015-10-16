package au.edu.parentPortal.beans.helper;

import au.edu.parentPortal.beans.DateAuditable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by hveluchamy on 2/12/2014.
 */
public class UpdatedAtEventListener implements PreUpdateEventListener {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        if(preUpdateEvent.getEntity() instanceof DateAuditable) {
            Session s = sessionFactory.getCurrentSession();
            DateAuditable auditable = (DateAuditable) preUpdateEvent.getEntity();
            auditable.setUpdatedAt(new Date());
            s.update(auditable);
        }
        return false;
    }
}
