package br.cefetmg.inf.organizer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eduardo Cotta
 */
public class UserLogout implements GenericProcess{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {    
        String pageJSP = "";
         
        HttpSession session = req.getSession(false);
        
        if(session != null){
          session.invalidate();
        }
        
        pageJSP = "/login.jsp";
        
        return pageJSP;
    }
    
}
