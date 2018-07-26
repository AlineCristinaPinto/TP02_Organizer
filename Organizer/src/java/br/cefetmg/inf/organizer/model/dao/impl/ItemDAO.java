/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.IItemDAO;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.util.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author aline
 */
public class ItemDAO implements IItemDAO{

    @Override
    public boolean createItem(Item item) {
        
        try{
            Connection connection = ConnectionManager.getInstance().getConnection();            
            String sql = "INSERT INTO item VALUES(?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, item.getNameItem());
            if (item.getDescriptionItem() != null) {
                preparedStatement.setString(2, item.getDescriptionItem());
            } else {
                preparedStatement.setString(2, null);
            }
            if (item.getDateItem() != null) {
                preparedStatement.setDate(3, new java.sql.Date(item.getDateItem().getTime()));
            } else {
                preparedStatement.setDate(3, null);
            }
            preparedStatement.setString(4, item.getIdentifierItem());
            if (item.getIdentifierStatus() != null) {
                preparedStatement.setString(5, item.getIdentifierStatus());
            } else {
                preparedStatement.setString(5, null);
            }
            preparedStatement.setString(5, item.getUser().getCodEmail());
            
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            
            return true;
            
        }catch (Exception e) {
        }
        
        return false;
    }

    @Override
    public boolean updateItem(Item item) {
    
         try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE item SET nom_item=?, des_item=?, dat_item=?, idt_estado=?"
                    + " WHERE cod_email=? and nom_item=? and idt_item=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, item.getNameItem());
            if (item.getDescriptionItem() != null) {
                preparedStatement.setString(2, item.getDescriptionItem());
            } else {
                preparedStatement.setString(2, null);
            }
            if (item.getDateItem() != null) {
                preparedStatement.setDate(3, new java.sql.Date(item.getDateItem().getTime()));
            } else {
                preparedStatement.setDate(3, null);
            }
            if (item.getIdentifierStatus() != null) {
                preparedStatement.setString(4, item.getIdentifierStatus());
            } else {
                preparedStatement.setString(4, null);
            }
            
            preparedStatement.setString(5, item.getUser().getCodEmail());
            preparedStatement.setString(6, item.getNameItem());
            preparedStatement.setString(7, item.getIdentifierItem());
                                    
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
    public boolean deleteItem(Item item) {
    
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM item WHERE cod_email=? and nom_item=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, item.getUser().getCodEmail());            
            preparedStatement.setString(2, item.getNameItem());

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
    public ArrayList<Item> listAllItem() {
        
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM item ORDER BY dat_item";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            
            ArrayList<Item> listAllItem = null;
            
            if (result.next()) {
                listAllItem = new ArrayList<>();
                do {
                    Item item = new Item();
                    item.setNameItem(result.getString("nom_item"));
                    item.setDescriptionItem(result.getString("des_item"));
                    item.setIdentifierItem(result.getString("idt_item"));
                    item.setDateItem(result.getDate("dat_item"));
                    item.setIdentifierStatus(result.getString("idt_estado"));
        
                    listAllItem.add(item);
                } while (result.next());
            }

            result.close();
            preparedStatement.close();
            connection.close();
                       
            return listAllItem;
        } catch (Exception ex) {
           //Adicionar Exceção 
        }
        
        return null; // temporario
    }
    
    @Override
    public boolean checkIfItemAlreadyExists(Item item){
         
        try {
           Connection connection = ConnectionManager.getInstance().getConnection();
           String sql = "SELECT nom_item FROM item WHERE nom_item=? and idt_item=? and cod_email=?";

           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, item.getNameItem());
           preparedStatement.setString(2, item.getIdentifierItem());
           preparedStatement.setString(3, item.getUser().getCodEmail());            
           
           ResultSet result = preparedStatement.executeQuery();
           
           result.close();
           preparedStatement.close();
           connection.close();
           
           if(result.getString("nom_item") == null)
               return true;
           
        } catch (Exception ex) {
           //Adicionar Exceção 
        }
        
        return false;
    }
    
}
