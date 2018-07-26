/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.service.IKeepItem;
import br.cefetmg.inf.organizer.model.service.IKeepItemTag;
import br.cefetmg.inf.organizer.model.service.impl.KeepItem;
import br.cefetmg.inf.organizer.model.service.impl.KeepItemTag;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aline
 */
public class CreateItem implements GenericProcess{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    
        String pageJSP = "";
        
        String selectType = req.getParameter("selectType");
        String name = req.getParameter("nameItem");
        String description = req.getParameter("descriptionItem");
        
        // Tratamento de data
        String datItem = req.getParameter("dateItem");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateItem = formatter.parse(datItem);
        
        String tag = req.getParameter("inputTag");
        /*ArrayList<String> tagItem = new ArrayList();
        
        String[] vetTag = tag.split(";");
        
        for(int i = 0; i < vetTag.length; i++){
            tagItem.add(vetTag[i]);
        }*/
        
        Item item = new Item();
        
        item.setNameItem(name);
        item.setDescriptionItem(description);
        item.setIdentifierItem(selectType);
        item.setDateItem(dateItem);
        
        if(selectType.equals("TAR")){
            item.setIdentifierStatus("A");
        }
        
        IKeepItem keepItem = new KeepItem();
        boolean result = keepItem.createItem(item);
        
        if(result == false){
            //exceção
        } else {
                 
            Item idItem = keepItem.searchItemByName(name);
            
            if(idItem == null){
                //Exceção
            } else {
                
                ItemTag itemTag = new ItemTag();
                
                itemTag.setItem(idItem);
                //itemTag.setListTags(tagItem);
                
                IKeepItemTag keepItemTag = new KeepItemTag();
                
            }
            
        }
        
        return pageJSP;
        
    }
    
}
