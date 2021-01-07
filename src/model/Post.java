package model;

//帖子
public class Post
{
    private String postId; //用来区分评论对应的帖子
    private String content; //帖子内容
    private String publisher; //发布人
    private String releaseTime; //发布时间
    private String name; //帖子名字
    private String commentsNumber; //评论数目
    private Comment[] comments; //评论数组
    private int commentsLength;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCommentsLength() { return comments.length; }

    public void setCommentsLength(int commentsLength) {
        this.commentsLength = commentsLength;
    }
}
