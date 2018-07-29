/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.util.ArrayList;

/**
 *
 * @author aline
 */
public interface IItemDAO {
    
    boolean createItem (Item item) throws PersistenceException;
    boolean updateItem(Item item);
    boolean deleteItem(Long idItem, User user) throws PersistenceException;
    ArrayList<Item> listAllItem(User user) throws PersistenceException;
    boolean checkIfItemAlreadyExists(Item item);
    Item searchItemByName(String nomeItem) throws PersistenceException;
    
}
