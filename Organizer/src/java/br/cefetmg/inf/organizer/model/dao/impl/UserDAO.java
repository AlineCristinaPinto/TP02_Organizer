/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.IThemeDAO;
import br.cefetmg.inf.organizer.model.dao.IUserDAO;
import br.cefetmg.inf.organizer.model.domain.Theme;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.db.ConnectionManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aline
 */
public class UserDAO implements IUserDAO {

    @Override
    public void createUser(User user) {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getCodEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getUserPassword());
            preparedStatement.setBinaryStream(4, null);
            preparedStatement.setInt(5, user.getCurrentTheme().getIdTheme());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
            //Adicionar Exceção da Aline
        }
    }

    @Override
    public User readUser(User user) {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT nom_Usuario,txt_Senha,blb_Imagem,seq_Tema, len(blb_Imagem) tamanho FROM usuario WHERE cod_Email=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getCodEmail());

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserName(rs.getString("nom_Usuario"));
                user.setUserPassword(rs.getString("txt_Senha"));

                File tempFile = new File("src/java/br/cefetmg/inf/resources/temp1.jpg");
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    int len = rs.getInt("tamanho");
                    byte[] buf = rs.getBytes("blb_Imagem");
                    fos.write(buf, 0, len);
                }
                
                user.setUserPhoto(tempFile);
                 
                IThemeDAO themeDAO = new ThemeDAO();
                Theme newTheme = themeDAO.readTheme(rs.getInt("seq_Tema"));
                user.setCurrentTheme(newTheme);
                
            } else {
                user = null;
            }
            rs.close();
            preparedStatement.close();
            connection.close();
            
            return user;
        } catch (Exception ex) {
            //Adicionar Exceção da Aline
        }
        return null; // temporário
    }

    @Override
    public void updateUser(User user) {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE usuario SET cod_Email=?, nom_Usuario=?, txt_Senha=?, blb_Imagem=?, seq_Tema=? WHERE cod_Email=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getCodEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getUserPassword());
            if (user.getUserPhoto() != null) {
                try (FileInputStream fin = new FileInputStream(user.getUserPhoto())) {
                    preparedStatement.setBinaryStream(4, fin, user.getUserPhoto().length());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    throw new IOException(ex.getMessage());
                }
            } else {
                preparedStatement.setBinaryStream(4, null);
            }
            preparedStatement.setInt(5, user.getCurrentTheme().getIdTheme());
            preparedStatement.setString(6, user.getCodEmail());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            //Adicionar Exceção da Aline
        }
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM usuario WHERE cod_Email=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getCodEmail());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();

            return true;
        } catch (Exception ex) {
            //throw new Exception();
            //Adicionar Exceção da Aline
        }
        return false;//temporario
    }

}
