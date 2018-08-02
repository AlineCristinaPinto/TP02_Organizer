
package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserValidation {
    
    public static boolean validate(User user){        
        return (user != null);
    }
}
