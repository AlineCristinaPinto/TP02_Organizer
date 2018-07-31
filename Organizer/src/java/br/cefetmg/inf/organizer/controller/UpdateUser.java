package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepUser;
import br.cefetmg.inf.organizer.model.service.impl.KeepUser;
import br.cefetmg.inf.util.PasswordCriptography;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUser implements GenericProcess {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        File userPhoto = new File(req.getParameter("profileIcon"));

        User user = (User) req.getSession().getAttribute("user");
        User tempUser = new User();

        if (password.isEmpty() || password == null) {
            password = user.getUserPassword();
        } else {
            password = PasswordCriptography.generateMd5(password);
        }

        tempUser.setCodEmail(user.getCodEmail());
        tempUser.setUserName(name);
        tempUser.setUserPassword(password);
        tempUser.setCurrentTheme(user.getCurrentTheme());
        tempUser.setUserPhoto(userPhoto);

        IKeepUser keepUser = new KeepUser();
        boolean success = keepUser.updateUser(tempUser);
        if (!success) {
            //erro
        } else {
            req.getSession().setAttribute("user",tempUser);
            pageJSP = "/configuracoes.jsp";
        }
        
        return pageJSP;
    }

}
