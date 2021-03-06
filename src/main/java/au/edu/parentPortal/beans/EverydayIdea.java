package au.edu.parentPortal.beans;

import org.apache.solr.client.solrj.beans.Field;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */

@Entity
@Table(name="everyday_idea")
public class EverydayIdea extends AbstractEntity{
    @Field("id")
    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Field
    @Length(min=1, max=1000)
    @NotEmpty
    private String title;

    @Field
    @Column(name="year_level")
    private String yearLevel;

    @Field
    @NotEmpty
    private String topic;

    @Field
    @Length(min=1, max=1000)
    @Column(name="brief_description")
    private String briefDescription;

    @Length(min=1, max=1000)
    private String description;

    @Field
    @Length(min=1, max=1000)
    @Column(name="content_id")
    private String contentId;

    @Column(name="item_content")
    private String itemContent;

    @JoinColumn(name="image_id")
    @OneToOne (fetch = FetchType.LAZY, orphanRemoval = false)
    private ParentImage parentImage;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=" + id);
        sb.append(", title=" + title);
        sb.append(", yearLevel=" + yearLevel);
        sb.append(", briefDescription=" + briefDescription);
        sb.append(", contentId=" + contentId);

        return sb.toString();
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   public String getContentId() {
       return contentId;
   }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
