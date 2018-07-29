/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import java.util.List;

/**
 *
 * @author aline
 */
public interface IKeepItem {
    
    boolean createItem (Item item);
    boolean updateItem(Item item);
    boolean deleteItem(Item item);
    List<Item> listAllItem();
    Item searchItemByName(String nomeItem);
    List<Item> searchItemByTag(List<Tag> tagList);
    List<Item> searchItemByType(List<String> typeList);
    List<Item> searchItemByTagAndType(List<Tag> tagList, List<String> typeList);
    
}
