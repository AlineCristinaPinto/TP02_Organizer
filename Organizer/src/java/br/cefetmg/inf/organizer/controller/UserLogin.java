package br.cefetmg.inf.organizer.controller;


import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepUser;
import br.cefetmg.inf.organizer.model.service.impl.KeepUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eduardo Cotta
 */
public class UserLogin implements GenericProcess{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        IKeepUser keepUser = new KeepUser();
        User user = keepUser.getUserLogin(email, password);
        
        if(user == null){
            //Tratamento de erros (COMO FAZER?)
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            pageJSP = "/index.jsp";
        }
        
        return pageJSP;
    }
    
}
