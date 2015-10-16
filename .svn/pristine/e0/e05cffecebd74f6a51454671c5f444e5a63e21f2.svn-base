package au.edu.parentPortal.beans;

import au.edu.parentPortal.beans.audit.AuditAction;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */
public class ItemStatistics extends AbstractEntity{
    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="activities_id")
    private Long activityId;

    @Column(name="acitivity_type")
    private String activityType;

    @Enumerated(EnumType.STRING)
    @Column(name="audit_action")
    private AuditAction auditAction;


}
