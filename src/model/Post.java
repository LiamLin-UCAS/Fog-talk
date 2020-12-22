package model;

//帖子
public class Post
{
    private String content; //帖子内容
    private String publisher; //发布人
    private String releaseTime; //发布时间
    private String commentsNumber; //评论数目
    private Comment[] comments; //评论数组

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(String commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}
