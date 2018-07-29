/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import java.util.ArrayList;
import java.util.List;

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
    ArrayList<Item> searchItemByTag(List<Tag> tagList);
    ArrayList<Item> searchItemByType(List<String> typeList);
    ArrayList<Item> searchItemByTagAndType(List<Tag> tagList, List<String> typeList);
    
}
