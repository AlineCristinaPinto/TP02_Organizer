package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.Theme;
import br.cefetmg.inf.util.exception.PersistenceException;

public interface IThemeDAO {

    public Theme readIdTheme(int seqTheme) throws PersistenceException; 
    
}
