package id.refactory.app.refactoryapps.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by massam on 30/10/17.
 */

public class UpdateDataAssignments {
    @SerializedName("id")
    private Integer id;

    @SerializedName("assignment_type")
    private String assignment_type;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("description")
    private String descryption;

    @SerializedName("score")
    private String score;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("status")
    private String status;

    @SerializedName("author")
    private String author;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssignment_type() {
        return assignment_type;
    }

    public void setAssignment_type(String assignment_type) {
        this.assignment_type = assignment_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
