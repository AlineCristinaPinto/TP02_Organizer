package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.ITagDAO;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public boolean updateTag(Tag tag) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "UPDATE tag SET nom_tag=? WHERE cod_email=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tag.getTagName());
                preparedStatement.setString(2, tag.getUser().getCodEmail());
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
    public List<Tag> listAlltag(User user) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM tag WHERE cod_email=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getCodEmail());

                try (ResultSet result = preparedStatement.executeQuery()) {
                    List<Tag> listAllTag = null;

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
    public Long searchTagByName(String nomeTag) {

        try {
            Long id;
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "SELECT seq_Tag FROM Tag WHERE nom_tag=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, nomeTag);
                    
                    ResultSet result = preparedStatement.executeQuery();
                    id = result.getLong("seq_Tag");
                    preparedStatement.executeUpdate();
                }
            }

            return id;
        } catch (Exception ex) {
            //Adicionar Exceção 
        }

        return null;
    }

}
