
package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.User;


public interface IKeepMaxData {
    boolean updateAllItems(User user, String[] itemsID, String[] itemsDate, String[] itemsName, String[] itemsDescription, String[] itemsStatus, String[] itemsType); //Olhar parametros
    boolean updateAllTags(User user, String[] tagsID, String[] tagsName); //Olhar parametros
    boolean updateAllItemTag(User user, String[] tagsItems, String[] itemsTags, String[] tagsID);
}
