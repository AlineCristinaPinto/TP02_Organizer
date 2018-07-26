package br.cefetmg.inf.organizer.model.domain;

public class Tag {
    
    private String tagName;
    private User user;
    
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }    
}
