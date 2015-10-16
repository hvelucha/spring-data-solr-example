package au.edu.parentPortal.beans.audit;

import au.edu.parentPortal.beans.AbstractEntity;
import au.edu.parentPortal.beans.Activities;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */
public class ActivitiesAudit extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name="activities_id", nullable = false)
    private Activities activities;

    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="audit_action")
    private AuditAction auditAction;

    public AuditAction getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(AuditAction auditAction) {
        this.auditAction = auditAction;
    }
}
