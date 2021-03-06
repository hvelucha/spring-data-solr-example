package au.edu.parentPortal.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */

public class ActivityItem extends AbstractEntity{
    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @JoinColumn(name="activities_id")
    @ManyToOne
    private Activities activities;

    @Column(name="acitivity_type")
    private String activityType;

    @Column(name="acitivity_tips")
    private String activityTips;

    @JoinColumn(name="image_id")
    @OneToOne (fetch = FetchType.LAZY, orphanRemoval = false)
    private ParentImage parentImage;

    public Activities getActivities() {
        return activities;
    }

    public void setActivities(Activities activities) {
        this.activities = activities;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityTips() {
        return activityTips;
    }

    public void setActivityTips(String activityTips) {
        this.activityTips = activityTips;
    }
}
