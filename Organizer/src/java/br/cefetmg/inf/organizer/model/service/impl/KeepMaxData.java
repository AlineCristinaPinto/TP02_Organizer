
package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepMaxData;


public class KeepMaxData implements IKeepMaxData {

    @Override
    public boolean updateAllItems(User user, String[] itemsID, String[] itemsDate, String[] itemsName, String[] itemsDescription, String[] itemsStatus, String[] itemsType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAllTags(User user, String[] tagsID, String[] tagsName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAllItemTag(User user, String[] tagsItems, String[] itemsTags, String[] tagsID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
