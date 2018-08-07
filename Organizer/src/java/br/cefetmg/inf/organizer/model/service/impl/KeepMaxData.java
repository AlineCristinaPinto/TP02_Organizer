
package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.IMaxDAO;
import br.cefetmg.inf.organizer.model.dao.impl.MaxDAO;
import br.cefetmg.inf.organizer.model.domain.MaxDataObject;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepMaxData;
import br.cefetmg.inf.util.exception.PersistenceException;



public class KeepMaxData implements IKeepMaxData {

    private final IMaxDAO maxDAO;
    
    public KeepMaxData() {
        maxDAO = new MaxDAO();
    }
    
    @Override
    public boolean updateAllItems(MaxDataObject maxDataObject) throws PersistenceException {
        if(maxDataObject.getItemsID().length < 1 || (maxDataObject.getUser() == null)){
            return false;
        }
        
        return maxDAO.updateAllItems(maxDataObject);
    }

    @Override
    public boolean updateAllTags(MaxDataObject maxDataObject) throws PersistenceException {
        if(maxDataObject.getTagsID().length < 1 || (maxDataObject.getUser() == null)){
            return false;
        }
        
        return maxDAO.updateAllTags(maxDataObject);
    }

    @Override
    public boolean updateAllItemTag(MaxDataObject maxDataObject) throws PersistenceException {
        if(maxDataObject.getTagsItems().length < 1){
            return false;
        }
        
        return maxDAO.updateAllItemTag(maxDataObject);
    }
    
}
