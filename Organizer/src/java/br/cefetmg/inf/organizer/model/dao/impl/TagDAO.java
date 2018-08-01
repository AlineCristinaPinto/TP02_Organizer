package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.ITagDAO;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TagDAO implements ITagDAO {

    @Override
    public boolean createTag(Tag tag) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "INSERT INTO tag VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tag.getTagName());
                preparedStatement.setString(2, tag.getUser().getCodEmail());

                preparedStatement.execute();
            }
            return true;
        } catch (Exception ex) {
            //exception
        }
        return false;
    }

    @Override
    public Tag readTag(Tag tag) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM tag WHERE cod_email=? and nom_tag=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tag.getUser().getCodEmail());
                preparedStatement.setString(2, tag.getTagName());

                try (ResultSet result = preparedStatement.executeQuery()) {
                    if (result.next()) {
                        tag.setSeqTag(result.getLong("seq_tag"));
                        tag.setTagName(result.getString("nom_tag"));
                    } else {
                        tag = null;
                    }
                }
            }
            return tag;
        } catch (Exception ex) {
            //exception
        }
        return tag;

    }

    @Override
    public boolean updateTag(Tag tag) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "UPDATE tag SET nom_tag=? WHERE cod_email=? and seq_tag=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tag.getUser().getCodEmail());
                preparedStatement.setString(2, tag.getTagName());
                preparedStatement.setLong(3, tag.getSeqTag());
            }
            return true;
        } catch (Exception ex) {
            //exception
        }
        return false;
    }
    
    @Override
    public boolean updateTagId(Tag tag, Long id) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "UPDATE tag SET seq_tag=? WHERE cod_email=? and nom_tag=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, tag.getSeqTag());                
                preparedStatement.setString(2, tag.getUser().getCodEmail());
                preparedStatement.setString(3, tag.getTagName());
            }
            return true;
        } catch (Exception ex) {
            //exception
        }
        return false;
    }
    
    @Override
    public boolean deleteTag(Tag tag) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "DELETE FROM tag WHERE cod_email=? and nom_tag=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tag.getUser().getCodEmail());
                preparedStatement.setString(2, tag.getTagName());

                preparedStatement.execute();
            }
            return true;
        } catch (Exception ex) {
            //exception
        }
        return false;
    }

    @Override
    public ArrayList<Tag> listAlltag(User user) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM tag WHERE cod_email=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getCodEmail());
                
                try (ResultSet result = preparedStatement.executeQuery()) {
                    ArrayList<Tag> listAllTag = null;
                    
                    if (result.next()) {
                        listAllTag = new ArrayList<>();

                        do {
                            Tag tag = new Tag();
                            tag.setTagName(result.getString("nom_tag"));
                            tag.setSeqTag(result.getLong("seq_tag"));
                            tag.setUser(user);
                            listAllTag.add(tag);
                        } while (result.next());
                    }
                    return listAllTag;
                }
            }
        } catch (Exception ex) {
            //exception
        }
        return null;
    }

    @Override
    public Long searchTagByName(String nomeTag, User user) {
        
        try {
            Long id=null;
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "SELECT seq_tag FROM Tag WHERE nom_tag=? and cod_email=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, nomeTag);
                    preparedStatement.setString(2, user.getCodEmail());
                    
                    try (ResultSet result = preparedStatement.executeQuery()) {
                        if(result.next()){
                            id = result.getLong("seq_tag");
                        }  
                    }
                }
            }

            return id;
        } catch (Exception ex) {
            //Adicionar Exceção 
        }

        return null;
    }
    
    @Override
    public Tag searchTagById(Long idTag) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM tag WHERE seq_tag=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, idTag);
                
                try (ResultSet result = preparedStatement.executeQuery()) {
                    Tag tag = new Tag();
                    
                    if (result.next()) {
                        tag.setTagName(result.getString("nom_tag"));
                        tag.setSeqTag(result.getLong("seq_tag"));
                    }
                    return tag;
                }
            }
        } catch (Exception ex) {
            //exception
        }
        return null;
    }

}