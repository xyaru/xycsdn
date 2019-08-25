package com.zhy.model;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ArticleLikesRecord {

    private long id;


    private long articleId;


    private int likerId;


    private String likeDate;


    private int isRead = 1;

    public ArticleLikesRecord(long articleId, int likerId, String likeDate) {
        this.articleId = articleId;
        this.likerId = likerId;
        this.likeDate = likeDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getLikerId() {
        return likerId;
    }

    public void setLikerId(int likerId) {
        this.likerId = likerId;
    }

    public String getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(String likeDate) {
        this.likeDate = likeDate;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}
