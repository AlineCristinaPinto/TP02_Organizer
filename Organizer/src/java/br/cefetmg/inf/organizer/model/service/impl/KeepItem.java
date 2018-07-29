/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.IItemDAO;
import br.cefetmg.inf.organizer.model.dao.impl.ItemDAO;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepItem;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                
        boolean result=false;
        try {
            result = itemDAO.createItem(item);
        } catch (PersistenceException ex) {
            Logger.getLogger(KeepItem.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public boolean deleteItem(Long idItem, User user) {
        
        boolean result=false;
        try {
            result = itemDAO.deleteItem(idItem, user);
        } catch (PersistenceException ex) {
            Logger.getLogger(KeepItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    
    }

    @Override
    public ArrayList<Item> listAllItem(User user) {
        
        ArrayList<Item> result=null;
        try {
            result = itemDAO.listAllItem(user);
        } catch (PersistenceException ex) {
            Logger.getLogger(KeepItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }

    @Override
    public Item searchItemByName(String nomeItem) {
        
        Item result=null;
        try {
            result = itemDAO.searchItemByName(nomeItem);
        } catch (PersistenceException ex) {
            Logger.getLogger(KeepItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
}
