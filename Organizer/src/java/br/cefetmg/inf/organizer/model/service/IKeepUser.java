/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.User;

/**
 *
 * @author aline
 */
public interface IKeepUser {
    
    boolean registerUser(User user);
    User searchUser(User user);
    boolean updateUser(User user);
    boolean deleteAccount(User user);
    User getUserLogin(String email, String password);
}
