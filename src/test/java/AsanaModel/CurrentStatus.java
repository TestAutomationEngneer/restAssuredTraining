package AsanaModel;

import com.google.gson.annotations.SerializedName;


public class CurrentStatus {


    private Author author;

    private String color;
    @SerializedName("created_by")
    private CreatedBy createdBy;

    private String html_text;

    private String text;

    private String title;

    public CurrentStatus() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public String getHtml_text() {
        return html_text;
    }

    public void setHtml_text(String html_text) {
        this.html_text = html_text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CurrentStatus{" +
                "author=" + author +
                ", color='" + color + '\'' +
                ", createdBy=" + createdBy +
                ", html_text='" + html_text + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
