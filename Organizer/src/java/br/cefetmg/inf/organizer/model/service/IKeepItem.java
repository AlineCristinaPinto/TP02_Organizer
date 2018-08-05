/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.Item;
import java.util.ArrayList;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.util.List;

/**
 *
 * @author aline
 */
public interface IKeepItem {
    
    boolean createItem (Item item);
    boolean updateItem(Item item);
    boolean deleteItem(Long idItem, User user);
    ArrayList<Item> listAllItem(User user);
    Item searchItemById(Long idItem);
    Item searchItemByName(String nomeItem);
    List<Item> searchItemByTag(List<Tag> tagList, User user) throws PersistenceException;
    List<Item> searchItemByType(List<String> typeList, User user) throws PersistenceException;
    List<Item> searchItemByTagAndType(List<Tag> tagList, List<String> typeList, User user) 
            throws PersistenceException;
    
}
