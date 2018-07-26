/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.IItemDAO;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.service.IKeepItem;

/**
 *
 * @author aline
 */
public class KeepItem implements IKeepItem{
    
    private IItemDAO itemDAO;

    public KeepItem(IItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
    
    @Override
    public boolean create(Item item) {
        
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
    public boolean update(Item item) {
        
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
    public boolean delete(Item item) {
        
        boolean result = itemDAO.updateItem(item);
        return result;
    
    }
    
}
