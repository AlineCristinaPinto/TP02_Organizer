/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.Item;
import java.util.ArrayList;

/**
 *
 * @author aline
 */
public interface IItemDAO {
    
    boolean createItem (Item item);
    boolean updateItem(Item item);
    boolean deleteItem(Item item);
    ArrayList<Item> listAllItem();
    boolean checkIfItemAlreadyExists(Item item);
    Item searchItemByName(String nomeItem);
    
}
