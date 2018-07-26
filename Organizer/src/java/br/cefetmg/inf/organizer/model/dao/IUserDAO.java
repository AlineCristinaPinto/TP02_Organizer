package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.User;
import java.util.ArrayList;

/**
 *
 * @author aline
 */
public interface IUserDAO {
    
    boolean createUser(User user);
    User readUser(User user); //temp, não sei se vou usar
    boolean updateUser(User user);
    boolean deleteUser(User user);
    User getUserLogin(String email, String password);

}
