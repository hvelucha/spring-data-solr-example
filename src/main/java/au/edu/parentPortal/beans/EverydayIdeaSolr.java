package au.edu.parentPortal.beans;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

/**
 * Created by hveluchamy on 14/10/2015.
 */
public class EverydayIdeaSolr {
  /*
    @Field("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Field("manu")
    private String manu;

    @Field("name")
    private String name;







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }


    @Override
    public String toString() {
        return "Data [id=" + id + ", name=" + name + "]";
    }*/

    @Id
    @Field
    private String internal_id;

    @Field
    private String title;

    @Field
    private String topic;

    public String getInternal_id(){
        return internal_id;
    }

    public void setInternal_id(String internal_id){
        this.internal_id = internal_id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTopic(){
        return topic;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Data [id=" + internal_id + ", title=" + title + "]";
    }



}
