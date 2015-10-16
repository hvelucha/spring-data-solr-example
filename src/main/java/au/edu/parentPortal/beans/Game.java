package au.edu.parentPortal.beans;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */
@Entity
@Table(name="games")
public class Game extends AbstractEntity{
    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Length(min=1, max=1000)
    @NotEmpty
    private String title;

    @Column(name="year_level")
    private String yearLevel;

    @Length(min=1, max=1000)
    private String capability;

    @Length(min=1, max=1000)
    @Column(name="brief_description")
    private String briefDescription;

    @Length(min=1, max=1000)
    private String description;

    @Length(min=1, max=1000)
    @Column(name="content_id")
    private String contentId;

    @JoinColumn(name="image_id")
    @OneToOne (fetch = FetchType.EAGER, orphanRemoval = false)
    private ParentImage parentImage;

    @Column(name="resource_id")
    private String resourceId;

    @Length(min=1, max=1000)
    @Column(name="skill_description")
    private String skillDescription;

    @Length(min=1, max=1000)
    @Column(name="useful_terms")
    private String usefulTerms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public ParentImage getParentImage() {
        return parentImage;
    }

    public void setParentImage(ParentImage parentImage) {
        this.parentImage = parentImage;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getUsefulTerms() {
        return usefulTerms;
    }

    public void setUsefulTerms(String usefulTerms) {
        this.usefulTerms = usefulTerms;
    }
}
