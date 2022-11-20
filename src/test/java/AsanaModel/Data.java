package AsanaModel;

import com.google.gson.annotations.SerializedName;


public class Data {


    private Boolean archived;

    private String color;

    @SerializedName("current_status")
    private CurrentStatus currentStatus;

    private String default_view;

    private String due_date;

    private String due_on;

    private String html_notes;

    private String name;

    private String notes;

    @SerializedName("public")
    private Boolean is_public;

    public Data() {
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDefault_view() {
        return default_view;
    }

    public CurrentStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(CurrentStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void setDefault_view(String default_view) {
        this.default_view = default_view;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getDue_on() {
        return due_on;
    }

    public void setDue_on(String due_on) {
        this.due_on = due_on;
    }

    public String getHtml_notes() {
        return html_notes;
    }

    public void setHtml_notes(String html_notes) {
        this.html_notes = html_notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getIs_public() {
        return is_public;
    }

    public void setIs_public(Boolean is_public) {
        this.is_public = is_public;
    }

    @Override
    public String toString() {
        return "Data{" +
                "archived=" + archived +
                ", color='" + color + '\'' +
                ", currentStatus=" + currentStatus +
                ", default_view='" + default_view + '\'' +
                ", due_date='" + due_date + '\'' +
                ", due_on='" + due_on + '\'' +
                ", html_notes='" + html_notes + '\'' +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", is_public=" + is_public +
                '}';
    }
}
