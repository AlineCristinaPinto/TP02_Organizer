
package br.cefetmg.inf.organizer.model.service.impl;

import br.cefetmg.inf.organizer.model.dao.IUserDAO;
import br.cefetmg.inf.organizer.model.dao.impl.TagDAO;
import br.cefetmg.inf.organizer.model.dao.impl.UserDAO;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepUser;
import br.cefetmg.inf.util.exception.PersistenceException;


public class KeepUser implements IKeepUser {

    private final IUserDAO userDAO;
    
    public KeepUser() {
        userDAO = new UserDAO();
    }
    
    @Override
    public boolean registerUser(User user) throws PersistenceException {
        
        User temp = userDAO.readUser(user);
        
        if(temp != null || (user.getCodEmail() == null || user.getCodEmail().isEmpty()) || (user.getUserPassword() == null || user.getUserPassword().isEmpty()) ||
                (user.getUserName() == null || user.getUserName().isEmpty()) || (user.getCurrentTheme().getIdTheme()== 0)){
            //adicionar exceção por usuário já registrado ou falta de atributo;
        }
        return userDAO.createUser(user);
    }

    @Override
    public User searchUser(User user) throws PersistenceException {
        User temp = userDAO.readUser(user); 
        if(temp==null){
           //adicionar exceção por usuário logado não encontrado (??)
        }
        return temp;
    }

    @Override
    public boolean updateUser(User user) throws PersistenceException {
        User temp = userDAO.readUser(user);
        
        if(User.compareUser(user, temp)){
            return true; // Se não houver mudança, nem manda pro BD
        }
        if((temp.getCodEmail() == null || temp.getCodEmail().isEmpty()) || (temp.getUserPassword() == null || temp.getUserPassword().isEmpty()) ||
                (temp.getUserName() == null || temp.getUserName().isEmpty()) || (temp.getCurrentTheme().getIdTheme()== 0)){
            //adicionar por falta de atributo;
        }
        
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteAccount(User user) throws PersistenceException {
        if(user.getCodEmail() == null || user.getCodEmail().isEmpty()){
            //adicionar exceção para usuário não achado, (acho que essa clausula é unreachable)
        }
        return userDAO.deleteUser(user);
    }

    @Override
    public User getUserLogin(String email, String password) throws PersistenceException {
        return userDAO.getUserLogin(email, password);
    }
    
}
