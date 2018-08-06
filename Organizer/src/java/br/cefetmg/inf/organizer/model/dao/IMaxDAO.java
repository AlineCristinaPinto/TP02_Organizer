
package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.PersistenceException;


public interface IMaxDAO {
    boolean updateAllItems(User user, String[] itemsID, String[] itemsDate, String[] itemsName, String[] itemsDescription, String[] itemsStatus, String[] itemsType) throws PersistenceException;
    boolean updateAllTags(User user, String[] tagsID, String[] tagsName) throws PersistenceException;
    boolean updateAllItemTag(User user, String[] tagsItems, String[] itemsTags, String[] tagsID) throws PersistenceException;
}
