/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.IItemTagDAO;
import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.service.IKeepItemTag;
import java.util.List;

/**
 *
 * @author aline
 */
public class KeepItemTag implements IKeepItemTag {
    
    private IItemTagDAO itemTagDAO;

    public KeepItemTag(IItemTagDAO itemTagDAO) {
        this.itemTagDAO = itemTagDAO;
    }
    
    @Override
    public boolean createTagInItem(ItemTag itemTag) {
        
        if((itemTag.getItem().getSeqItem() == null)){
            //exceção
        }
        
        if((itemTag.getListTags() == null) || (itemTag.getListTags().isEmpty())){
            //exceção
        }
        
        boolean result = itemTagDAO.createTagInItem(itemTag);
        return result;
        
    }

    @Override
    public boolean updateTagInItem(ItemTag itemTag) {
        
        if((itemTag.getItem().getSeqItem() == null)){
            //exceção
        }
        
        if((itemTag.getListTags() == null) || (itemTag.getListTags().isEmpty())){
            //exceção
        }
        
        boolean result = itemTagDAO.updateTagInItem(itemTag);
        return result;
        
    }

    @Override
    public boolean deleteTagInItem(ItemTag itemTag) {
        
        boolean result = itemTagDAO.deleteTagInItem(itemTag);
        return result;
        
    }

    @Override
    public List<Tag> listAllTagInItem(ItemTag itemTag) {
        
        List<Tag> result = itemTagDAO.listAllTagInItem(itemTag);
        return result;
        
    }
    
}
