/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.Theme;

/**
 *
 * @author aline
 */
public interface IThemeDAO {

    public Theme readIdTheme(int seqTheme); //Criei já porque preciso dele em User, mas basicamente ele pesquisa um tema por id e retorna ele
    
}
