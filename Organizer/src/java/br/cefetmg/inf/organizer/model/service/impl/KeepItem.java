/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.IItemDAO;
import br.cefetmg.inf.organizer.model.dao.impl.ItemDAO;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.service.IKeepItem;
import java.util.List;

/**
 *
 * @author aline
 */
public class KeepItem implements IKeepItem{
    
    private final IItemDAO itemDAO = new ItemDAO();

    @Override
    public boolean createItem(Item item) {
        
        if(itemDAO.checkIfItemAlreadyExists(item) == false){
            // exceção
        }
        
        if((item.getNameItem() == null) || (item.getNameItem().isEmpty())){
            //exceção
        }
                
        boolean result = itemDAO.createItem(item);
        return result;
    }

    @Override
    public boolean updateItem(Item item) {
        
        if(itemDAO.checkIfItemAlreadyExists(item) == false){
            // exceção
        }
        
        if((item.getNameItem() == null) || (item.getNameItem().isEmpty())){
            //exceção
        }
                
        boolean result = itemDAO.updateItem(item);
        return result;
    
    }

    @Override
    public boolean deleteItem(Item item) {
        
        boolean result = itemDAO.deleteItem(item);
        return result;
    
    }

    @Override
    public List<Item> listAllItem() {
        
        List<Item> result = itemDAO.listAllItem();
        return result;
        
    }

    @Override
    public Item searchItemByName(String nomeItem) {
        
        Item result = itemDAO.searchItemByName(nomeItem);
        return result;
        
    }
    
}
