package br.cefetmg.inf.organizer.model.dao;

import br.cefetmg.inf.organizer.model.domain.User;
import java.util.ArrayList;

/**
 *
 * @author aline
 */
public interface IUserDAO {
    
    void createUser(User user);
    User readUser(User user); //temp, não sei se vou usar
    void updateUser(User user);
    boolean deleteUser(User user);

}
