/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.domain.Tag;
import java.util.ArrayList;

/**
 *
 * @author aline
 */
public interface IItemTagDAO {
    
    boolean createTagInItem (ItemTag itemTag);
    boolean updateTagInItem(ItemTag itemTag);
    boolean deleteTagInItem(ItemTag itemTag);
    ArrayList<Tag> listAllTagInItem(ItemTag itemTag);
    
}
