/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.IItemTagDAO;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.util.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aline
 */
public class ItemTagDAO implements IItemTagDAO{

    @Override
    public boolean createTagInItem(ItemTag itemTag) {
        
        try{
            Connection connection = ConnectionManager.getInstance().getConnection();            
            String sql = "INSERT INTO Item_Tag VALUES(?,?)";
           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            
           /* for(Tag t : itemTag.getListTags()){
            
                preparedStatement.setLong(1, itemTag.getItem().getSeqItem());
                preparedStatement.setString(2, t.getSeqTag());
            
            }*/
            
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            
            return true;
            
        }catch (Exception e) {
        }
        
        return false;

    }

    @Override
    public boolean updateTagInItem(ItemTag itemTag) {
        
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE Item_Tag SET seq_tag=?"
                    + " WHERE seq_item=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
         
           /* for(Tag t : itemTag.getListTags()){
                
                preparedStatement.setString(1, t.getSeqTag());
                preparedStatement.setLong(2, itemTag.getItem().getSeqItem());
            
            }*/
           
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            
            return true;
        } catch (Exception ex) {
            //Adicionar Exceção 
        }
         
         return false;
    }

    @Override
    public boolean deleteTagInItem(ItemTag itemTag) {
        
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM Item_Tag WHERE seq_tag=? and seq_item=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            /* for(Tag t : itemTag.getListTags()){
                
                preparedStatement.setString(1, t.getSeqTag());
                preparedStatement.setLong(2, itemTag.getItem().getSeqItem());
            
            }*/
           
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            
            return true;
            
        } catch (Exception ex) {
           //Adicionar Exceção 
        }
        
        return false;
    }

    @Override
    public ArrayList<Tag> listAllTagInItem(ItemTag itemTag) {
        
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT A.seq_Tag, B.nom_Tag FROM Item_Tag A"
                    + "JOIN Tag B ON A.seq_Tag = B.seq_Tag"
                    + "WHERE A.seq_Item=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, itemTag.getItem().getSeqItem());
            
            ResultSet result = preparedStatement.executeQuery();
            
            ArrayList<Tag> listAllTag = null;
            
            if (result.next()) {
                listAllTag = new ArrayList<>();
                do {
                    Tag tag = new Tag();
 
                    /*
                    
                    tag.setSeqTag(result.getLong("seq_Tag"));
                    tag.setNameTag(result.getString("nom_Tag"));
                    
                    */
        
                    listAllTag.add(tag);
                } while (result.next());
            }

            result.close();
            preparedStatement.close();
            connection.close();
                       
            return listAllTag;
        } catch (Exception ex) {
           //Adicionar Exceção 
        }
        
        return null; // temporario
    }
        
}
