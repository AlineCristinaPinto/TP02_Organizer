package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.ITagDAO;
import br.cefetmg.inf.organizer.model.dao.impl.TagDAO;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import br.cefetmg.inf.util.exception.BusinessException;
import java.util.ArrayList;

public class KeepTag implements IKeepTag {

    private final ITagDAO tagDAO;

    public KeepTag() {
        tagDAO = new TagDAO();
    }

    @Override
    public boolean createTag(Tag tag) throws BusinessException {
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            throw new BusinessException("Não foi possível criar a tag: nome não informado");
        }
         Tag temp = tagDAO.readTag(tag);
        
        if(temp != null){
            throw new BusinessException("Não foi possível criar a tag: já existe uma tag com esse nome");
        }
        
        boolean result = tagDAO.createTag(tag);
        return result;
    }

    @Override
    public Tag readTag(Tag tag) throws BusinessException {
        
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            throw new BusinessException("Não foi possível ler a tag: nome não informado");  
        }
        
        Tag temp = tagDAO.readTag(tag);
        return temp;
    }

    @Override
    public boolean updateTag(Tag tag) throws BusinessException {
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            throw new BusinessException("Não foi possível atualizar a tag: nome não informado");   
        }

        boolean result = tagDAO.updateTag(tag);
        return result;
    }
    
    @Override
    public boolean updateTagId(Tag tag, Long id) throws BusinessException {
        if ((tag.getTagName() == null) || (tag.getTagName().isEmpty())) {
            throw new BusinessException("Não foi possível atualizar a tag: nome não informado");   
        }

        boolean result = tagDAO.updateTagId(tag, id);
        return result;
    }
    
    @Override
    public boolean deleteTag(Tag tag) {
        boolean result = tagDAO.deleteTag(tag);
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

    @Override
    public Tag searchTagById(Long idTag) {
        Tag result = tagDAO.searchTagById(idTag);
        return result;
    }
}
