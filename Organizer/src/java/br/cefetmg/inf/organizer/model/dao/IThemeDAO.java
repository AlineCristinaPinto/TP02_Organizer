package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.Theme;

public interface IThemeDAO {

    public Theme readTheme(int seqTheme); //Criei já porque preciso dele em User, mas basicamente ele pesquisa um tema por id e retorna ele
    
}
