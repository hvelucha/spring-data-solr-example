package au.edu.parentPortal.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hveluchamy on 2/12/2014.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable, DateAuditable {
    private static final String DEFAULT_UPDATED_BY = "SYSTEM";

    private static final long serialVersionUID = -4295509776765380330L;

    @Column(name="CREATED_DATE", insertable=true)
     private Date createAt;

    @Column(name="UPDATED_DATE")
    private Date updatedAt;


    @Column(name="UPDATED_BY", nullable=true)
    private String updatedBy = DEFAULT_UPDATED_BY;


    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public void setDefaultUpdatedBy() {
        setUpdatedBy(DEFAULT_UPDATED_BY);
    }
}
