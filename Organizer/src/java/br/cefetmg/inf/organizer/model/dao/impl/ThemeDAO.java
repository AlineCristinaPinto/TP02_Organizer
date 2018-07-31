package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.IThemeDAO;
import br.cefetmg.inf.organizer.model.domain.Theme;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThemeDAO implements IThemeDAO {

    @Override
    public Theme readIdTheme(int seqTheme) throws PersistenceException {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM tema WHERE seq_tema=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, seqTheme);

                try (ResultSet result = preparedStatement.executeQuery()) {
                    if (result.next()) {
                        Theme theme = new Theme();
                        theme.setIdTheme(seqTheme);
                        theme.setBackgroundColor(result.getString("cor_fundo"));
                        theme.setLetterColor(result.getString("cor_letra"));
                        theme.setRadiusLevel(result.getInt("nvl_arredondamento"));
                        theme.setSecondColor(result.getString("cor_secundaria"));
                        return theme;
                    }
                }
            }
        } catch (Exception ex) {
            throw new PersistenceException("Erro ao buscar o tema no banco: " + ex.getMessage());
        }
        return null;
    }
}
