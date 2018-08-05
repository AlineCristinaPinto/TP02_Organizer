package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.BusinessException;
import java.util.ArrayList;

public interface IKeepTag {

    boolean createTag(Tag tag) throws BusinessException;
    
    Tag readTag(Tag tag) throws BusinessException;
    
    boolean updateTag(Tag tag) throws BusinessException;
    
    boolean updateTagId(Tag tag, Long id) throws BusinessException;
    
    boolean deleteTag(Tag tag) throws BusinessException;

    ArrayList<Tag> listAlltag(User user) throws BusinessException;
    
    Long searchTagByName(String nomeTag, User user) throws BusinessException;
    
    Tag searchTagById(Long idTag) throws BusinessException;
}
