package au.edu.parentPortal.beans.audit;

import au.edu.parentPortal.beans.AbstractEntity;
import au.edu.parentPortal.beans.Game;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */

@Entity
@Table(name="games_audit")
public class GameAudit extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name="games_id", nullable = false)
    private Game game;


    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="audit_action")
    private AuditAction auditAction;
}
