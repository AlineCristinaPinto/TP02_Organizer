package br.cefetmg.inf.organizer.controller;


import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepUser;
import br.cefetmg.inf.organizer.model.service.impl.KeepUser;
import br.cefetmg.inf.util.PasswordCriptography;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUser implements GenericProcess {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";

        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = PasswordCriptography.generateMd5(req.getParameter("password"));

        User user = new User();

        user.setCodEmail(email);
        user.setUserName(name);
        user.setUserPassword(password);
        user.setUserPhoto(null);
        user.setCurrentTheme(1);

        IKeepUser keepUser = new KeepUser();
        boolean success = keepUser.registerUser(user);

        if (!success) {
            //trata erros
        } else {

            pageJSP = "/login.jsp";

        }

        return pageJSP;
    }

}
