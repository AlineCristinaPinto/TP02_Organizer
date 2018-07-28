package br.cefetmg.inf.organizer.model.domain;

public class Tag {

    private String tagName;
    private Long seqTag;
    private User user;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getSeqTag() {
        return seqTag;
    }

    public void setSeqTag(Long seqTag) {
        this.seqTag = seqTag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
