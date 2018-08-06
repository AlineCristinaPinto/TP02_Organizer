package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.IMaxDAO;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MaxDAO implements IMaxDAO{

    @Override
    public boolean updateAllItems(User user, String[] itemsID, String[] itemsDate, String[] itemsName, String[] itemsDescription, String[] itemsStatus, String[] itemsType) throws PersistenceException {
        
        Date date;
        java.sql.Date itemDate;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql;
            
            if(itemsID != null){
                sql = "DELETE FROM item";
            
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.execute();
                }
            
            
                sql = "INSERT INTO item ( nom_item, des_item, dat_item, idt_item, idt_estado, cod_email)"
                       + " VALUES ( ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    for(int i = 0; i < itemsID.length; i++){
                        if(itemsDate[i] == null || itemsDate[i].equals("") || itemsDate[i].isEmpty()){
                            itemDate = null;
                        } else {            
                            date = formatter.parse(itemsDate[i]);
                            itemDate = new java.sql.Date( date.getTime() );
                        }
                                               
                        preparedStatement.setString(1, itemsName[i]);
                        preparedStatement.setString(2, itemsDescription[i]);
                        preparedStatement.setDate(3, itemDate);
                        preparedStatement.setString(4, itemsType[i]);
                        preparedStatement.setString(5, itemsStatus[i]);
                        preparedStatement.setString(6, user.getCodEmail());

                        preparedStatement.execute();
                        
                    }   
                    
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new PersistenceException(ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public boolean updateAllTags(User user, String[] tagsID, String[] tagsName) throws PersistenceException {
        
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql;
            
            if(tagsID != null){
                sql = "DELETE FROM tag";
            
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.execute();
                }
            
                sql = "INSERT INTO tag (nom_tag, cod_email)"
                    + " VALUES (?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    for(int i = 0; i < tagsID.length; i++){
                        //preparedStatement.setString(1, tagsID[i]);
                        preparedStatement.setString(1, tagsName[i]);
                        preparedStatement.setString(2, user.getCodEmail());

                        preparedStatement.execute();
                    }               
                    
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new PersistenceException(ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public boolean updateAllItemTag(User user, String[] tagsItems, String[] itemsTags, String[] tagsID) throws PersistenceException {
        
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql;
        
            if(tagsItems != null){
                sql = "DELETE FROM item_tag";
            
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.execute();
                }
            
                sql = "INSERT INTO item_tag (seq_item, seq_tag)"
                    + " VALUES (?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    for(int i = 0; i < tagsID.length; i++){
                        preparedStatement.setInt(1, Integer.valueOf( tagsItems[i]) );
                        preparedStatement.setInt(2, Integer.valueOf( itemsTags[i]) );

                        preparedStatement.execute();
                    }               
                    
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new PersistenceException(ex.getMessage(), ex);
        }
        return false;
    }
    
}
