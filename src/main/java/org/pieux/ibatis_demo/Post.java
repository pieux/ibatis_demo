package org.pieux.ibatis_demo;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created with IntelliJ IDEA.
 * User: pieux
 * Date: 7/16/13
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Post implements Serializable {
    private static final long serialVersionUID = -7163004163334815825L;

    private int id;
    private String title;
    private String author;
    private Timestamp publish_date;
    private String content;

    public int getId() {return id; }
    public void setId(int id) { this.id = id;}

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return this.author; }
    public void setAuthor(String author) { this.author = author; }

    public Timestamp getPublishDate() { return this.publish_date; }
    public void setPublishDate(Timestamp publish_date) { this.publish_date = publish_date; }

    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }

    public String toString(){
        return "id: " + this.id + ",publish_date: " + this.publish_date + ",content: " + this.content;
    }
}
