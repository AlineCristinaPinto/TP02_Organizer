/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.PersistenceException;

/**
 *
 * @author aline
 */
public interface IKeepUser {
    
    boolean registerUser(User user) throws PersistenceException;
    User searchUser(User user) throws PersistenceException;
    boolean updateUser(User user) throws PersistenceException;
    boolean deleteAccount(User user) throws PersistenceException;
    User getUserLogin(String email, String password) throws PersistenceException;
}
