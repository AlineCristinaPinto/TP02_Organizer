/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aline
 */
public class ItemViewMode implements GenericProcess{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        String pageJSP = "";
        
        // Pegando usuário
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
      
        String orderViewMode = req.getParameter("buttonDisplayValue");
        String typeViewMode =  req.getParameter("display");
        
        // Session
        req.getSession().setAttribute("orderViewMode", orderViewMode);
        req.getSession().setAttribute("typeViewMode", typeViewMode);
        
        pageJSP = "/index.jsp";
        
        return pageJSP;
    }
    
}
