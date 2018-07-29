package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.ITagDAO;
import br.cefetmg.inf.organizer.model.dao.impl.TagDAO;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import java.util.ArrayList;

public class KeepTag  implements IKeepTag{

    private final ITagDAO tagDAO;
    
    public KeepTag() {
        tagDAO = new TagDAO();
    }
    
    @Override
    public boolean createTag(Tag tag) {
        if((tag.getTagName() == null) || (tag.getTagName().isEmpty()))
        {
        //exception    
        }
                          
        boolean result = tagDAO.createTag(tag);
        return result;
    }

    @Override
    public boolean updateTag(Tag tag) {
        if((tag.getTagName() == null) || (tag.getTagName().isEmpty()))
        {
        //exception    
        }
                          
        boolean result = tagDAO.updateTag(tag);
        return result;
    }

    @Override
    public boolean deleteTag(Tag tag) {                          
        boolean result = tagDAO.createTag(tag);
        return result;
    }

    @Override
    public ArrayList<Tag> listAlltag(User user) {
        ArrayList result = tagDAO.listAlltag(user);
        return result;
    }
    
    @Override
    public Long searchTagByName(String nomeTag, User user){
        Long result = tagDAO.searchTagByName(nomeTag, user);
        return result;
    }
}
