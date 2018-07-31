package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.IThemeDAO;
import br.cefetmg.inf.organizer.model.domain.Theme;
import br.cefetmg.inf.util.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThemeDAO implements IThemeDAO {

    @Override
    public Theme readIdTheme(int seqTheme) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM theme WHERE seq_tema=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, seqTheme);

                try (ResultSet result = preparedStatement.executeQuery()) {
                    if (result.next()) {
                        Theme theme = new Theme();
                        theme.setIdTheme(seqTheme);
                        theme.setBackgroundColor(result.getString("cor_fundo"));
                        theme.setLetterColor(result.getString("cor_letra"));
                        theme.setRadiusLevel(result.getInt("nvl_arrendondamento"));
                        theme.setSecondColor(result.getString("cor_secundaria"));
                        return theme;
                    }
                }
            }
        } catch (Exception ex) {
            //exception
        }
        return null;
    }
}
