package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import java.util.ArrayList;

public interface IKeepTag {

    boolean createTag(Tag tag);

    boolean updateTag(Tag tag);

    boolean deleteTag(Tag tag);

    ArrayList<Tag> listAlltag(User user);
    
    Long searchTagByName(String nomeTag, User user);
}
