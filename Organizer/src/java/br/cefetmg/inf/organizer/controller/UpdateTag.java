package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import br.cefetmg.inf.organizer.model.service.impl.KeepTag;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateTag implements GenericProcess {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String oldNameTag = req.getParameter("takeOldName");
        String nameTag = req.getParameter("nameEdited");

        IKeepTag keepTag = new KeepTag();

        Tag tag = new Tag();
        tag.setSeqTag(keepTag.searchTagByName(oldNameTag, user));
        tag.setTagName(nameTag);
        tag.setUser(user);

        boolean result = keepTag.updateTag(tag);

        if (result == false) {
            //exception
        } else {
            pageJSP = "/index.jsp";
        }

        return pageJSP;
    }

}
