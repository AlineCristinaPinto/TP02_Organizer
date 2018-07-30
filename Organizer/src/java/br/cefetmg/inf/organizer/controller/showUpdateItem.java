/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aline
 */
public class showUpdateItem implements GenericProcess{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        String pageJSP = "";
        
        String id = req.getParameter("takeIdU");
        String typeItem = req.getParameter("takeTypeU");
        
        long seq_item;
        seq_item = Long.parseLong(id);
      
        // Session
        req.getSession().setAttribute("idItem", seq_item);
        
        switch (typeItem) {
            case "SIM":
                pageJSP = "/updateSimples.jsp";
                break;
            case "TAR":
                pageJSP = "/updateTarefa.jsp";   
                break;
            case "LEM":
                pageJSP = "/updateLembrete.jsp";
                break;
            default:
                break;
        }
        
        return pageJSP;    
    }    
}
