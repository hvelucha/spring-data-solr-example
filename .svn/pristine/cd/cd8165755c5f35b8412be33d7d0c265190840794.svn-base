package au.edu.parentPortal.beans;

import au.edu.parentPortal.enums.ImageType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created by hveluchamy on 5/10/2015.
 */
@Entity
@Table(name="parent_image")
public class ParentImage extends AbstractEntity{
    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="file_name")
    private String fileName;

    @Column(name="image_location_type")
    private String locationType;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private ImageType type;

    @Length(max = 1000)
    @Column(name="image_url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageType getType(){
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=" + id);
        sb.append(", fileName=" + fileName);
        sb.append(", type=" + type);

        return sb.toString();
    }
}
