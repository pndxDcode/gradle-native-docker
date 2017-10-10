
package id.refactory.app.refactoryapps.api.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("assignment_type")
    @Expose
    private String assignmentType;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("closed_at")
    @Expose
    private Object closedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("result_value")
    @Expose
    private String resultValue;
    @SerializedName("result_attachments")
    @Expose
    private String resultAttachments;
    @SerializedName("result_json")
    @Expose
    private Object resultJson;
    @SerializedName("result_description")
    @Expose
    private Object resultDescription;
    @SerializedName("result_attachment")
    @Expose
    private Object resultAttachment;
    @SerializedName("eta")
    @Expose
    private String eta;
    @SerializedName("assignees")
    @Expose
    private String assignees;
    @SerializedName("related_curriculums")
    @Expose
    private String relatedCurriculums;
    @SerializedName("ticket_url")
    @Expose
    private String ticketUrl;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("is_overdue")
    @Expose
    private Boolean isOverdue;
    @SerializedName("curriculumItems")
    @Expose
    private List<Object> curriculumItems = null;
    @SerializedName("user")
    @Expose
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Object getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Object closedAt) {
        this.closedAt = closedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    public String getResultAttachments() {
        return resultAttachments;
    }

    public void setResultAttachments(String resultAttachments) {
        this.resultAttachments = resultAttachments;
    }

    public Object getResultJson() {
        return resultJson;
    }

    public void setResultJson(Object resultJson) {
        this.resultJson = resultJson;
    }

    public Object getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(Object resultDescription) {
        this.resultDescription = resultDescription;
    }

    public Object getResultAttachment() {
        return resultAttachment;
    }

    public void setResultAttachment(Object resultAttachment) {
        this.resultAttachment = resultAttachment;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getAssignees() {
        return assignees;
    }

    public void setAssignees(String assignees) {
        this.assignees = assignees;
    }

    public String getRelatedCurriculums() {
        return relatedCurriculums;
    }

    public void setRelatedCurriculums(String relatedCurriculums) {
        this.relatedCurriculums = relatedCurriculums;
    }

    public String getTicketUrl() {
        return ticketUrl;
    }

    public void setTicketUrl(String ticketUrl) {
        this.ticketUrl = ticketUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    public List<Object> getCurriculumItems() {
        return curriculumItems;
    }

    public void setCurriculumItems(List<Object> curriculumItems) {
        this.curriculumItems = curriculumItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
