package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.Tag;
import java.util.List;

public interface IKeepTag {

    boolean createTag(Tag tag);

    boolean updateTag(Tag tag);

    boolean deleteTag(Tag tag);

    List<Tag> listAlltag();
}
