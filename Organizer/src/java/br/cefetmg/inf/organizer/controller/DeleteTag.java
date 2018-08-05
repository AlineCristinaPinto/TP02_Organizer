package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import br.cefetmg.inf.organizer.model.service.impl.KeepTag;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteTag implements GenericProcess {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String nameTag = req.getParameter("tagMenu");
        System.out.println(nameTag);

        IKeepTag keepTag = new KeepTag();

        Tag tag = new Tag();
        tag.setSeqTag(keepTag.searchTagByName(nameTag, user));
        tag.setTagName(nameTag);
        tag.setUser(user);

        boolean result = keepTag.deleteTag(tag);

        if (result == false) {
            System.out.println("oi");
        } else {
            pageJSP = "/index.jsp";
        }

        return pageJSP;
    }

}
