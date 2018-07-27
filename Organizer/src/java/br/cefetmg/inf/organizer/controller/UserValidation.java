
package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserValidation {
    
    public static boolean validate(HttpServletRequest req, HttpServletResponse res){
        User user = (User) req.getAttribute("user");
        
        return (user != null);
    }
}
