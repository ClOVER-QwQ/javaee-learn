package com.clover.pojo;

public class Poem {
    private int id;
    private String title;
    private String content;
    private String translation;
    private int authorId;
    private int poemTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPoemTypeId() {
        return poemTypeId;
    }

    public void setPoemTypeId(int poemTypeId) {
        this.poemTypeId = poemTypeId;
    }

    @Override
    public String toString() {
        return "Poem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", translation='" + translation + '\'' +
                ", authorId=" + authorId +
                ", poemTypeId=" + poemTypeId +
                '}';
    }
}