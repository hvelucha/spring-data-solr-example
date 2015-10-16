package au.edu.parentPortal.beans.helper;

import au.edu.parentPortal.beans.DateAuditable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by hveluchamy on 2/12/2014.
 */
public class CreateAtEventListener extends DefaultSaveOrUpdateEventListener implements PostInsertEventListener {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        if(postInsertEvent.getEntity() instanceof DateAuditable) {
            Session s = sessionFactory.getCurrentSession();
            DateAuditable auditable = (DateAuditable) postInsertEvent.getEntity();
            if (auditable.getCreateAt() == null) {
                auditable.setUpdatedAt(new Date());
                auditable.setCreateAt(new Date());
                s.save(auditable);
                s.flush();
            }
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
        return true;
    }
}
