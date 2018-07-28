package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import java.util.List;

public interface IKeepTag {

    boolean createTag(Tag tag);
    
    Tag readTag(Tag tag);
    
    boolean updateTag(Tag tag);
    
    boolean updateTagId(Tag tag, Long id);
    
    boolean deleteTag(Tag tag);

    List<Tag> listAlltag(User user);
    
    Long searchTagByName(String nomeTag, User user);
}