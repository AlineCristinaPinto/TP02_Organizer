package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.ITagDAO;
import br.cefetmg.inf.organizer.model.dao.impl.TagDAO;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import java.util.ArrayList;
import java.util.List;

public class KeepTag implements IKeepTag {

    private final ITagDAO tagDAO;

    public KeepTag() {
        tagDAO = new TagDAO();
    }

    @Override
    public boolean createTag(Tag tag) {
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            //exception    
        }
         Tag temp = tagDAO.readTag(tag);
        
        if(temp != null){
            //exception
        }
        
        boolean result = tagDAO.createTag(tag);
        return result;
    }

    @Override
    public Tag readTag(Tag tag) {
        
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            //exception    
        }
        
        Tag temp = tagDAO.readTag(tag);
        return temp;
    }

    @Override
    public boolean updateTag(Tag tag) {
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            //exception    
        }

        boolean result = tagDAO.updateTag(tag);
        return result;
    }
    
    @Override
    public boolean updateTagId(Tag tag, Long id) {
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            //exception    
        }

        boolean result = tagDAO.updateTagId(tag, id);
        return result;
    }
    
    @Override
    public boolean deleteTag(Tag tag) {
        boolean result = tagDAO.createTag(tag);
        return result;
    }

    @Override
    public List<Tag> listAlltag(User user) {
        ArrayList result = (ArrayList) tagDAO.listAlltag(user);
        return result;
    }

    @Override
    public Long searchTagByName(String nomeTag, User user) {
        
        Long result = tagDAO.searchTagByName(nomeTag, user);
        return result;
    }

}
