package au.edu.parentPortal.beans.audit;

import au.edu.parentPortal.beans.AbstractEntity;
import au.edu.parentPortal.beans.EverydayIdea;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */
@Entity
@Table(name="everyday_idea_audit")
public class EverydayIdeaAudit extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name="everyday_idea_id", nullable = false)
    private EverydayIdea everydayIdea;

    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="audit_action")
    private AuditAction auditAction;
}
