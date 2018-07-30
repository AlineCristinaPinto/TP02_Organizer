/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepItem;
import br.cefetmg.inf.organizer.model.service.IKeepItemTag;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import br.cefetmg.inf.organizer.model.service.impl.KeepItem;
import br.cefetmg.inf.organizer.model.service.impl.KeepItemTag;
import br.cefetmg.inf.organizer.model.service.impl.KeepTag;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aline
 */
public class UpdateItem implements GenericProcess{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        String pageJSP = "";
        
        // Pegando usuário
       //HttpSession session = req.getSession();
       //User user = (User) session.getAttribute("user");
                
        User user = new User();
       
        user.setCodEmail("ninanerd15@gmail.com");
        user.setUserName("Aline Cristina");
        
        // Pega os dados dos inputs
        String name = req.getParameter("nameItem");
        String description = req.getParameter("descriptionItem");
        
        // Tratamento de data
        String datItem = req.getParameter("dateItem");
        Date dateItem;
        if(datItem == null || datItem.equals("") || datItem.isEmpty()){
            dateItem = null;
        } else {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            dateItem = formatter.parse(datItem);
        }
        
        // Tratamento de Tag
        String tag = req.getParameter("inputTag");
        
        ArrayList<Tag> tagItem = new ArrayList();
            
        if(!tag.isEmpty()){
            String[] vetTag = tag.split(";");
            
            IKeepTag keepTag = new KeepTag();

            for (String vetTag1 : vetTag) {
                if (keepTag.searchTagByName(vetTag1.trim(), user) == null) {
                    //exceção
                } else {
                    Tag tagOfUser = new Tag();
                    
                    tagOfUser.setSeqTag(keepTag.searchTagByName(vetTag1.trim(), user));
                    tagOfUser.setTagName(vetTag1.trim());
                    tagOfUser.setUser(user);

                    tagItem.add(tagOfUser);
                }
            }
        }
        
        IKeepItemTag keepItemTag = new KeepItemTag();
        ArrayList<Tag> oldTags;
        
        // Pega as tags adicionadas anteriormente a atualização
        oldTags = keepItemTag.listAllTagInItem(Long.MIN_VALUE);
        
        ArrayList<Tag> keepTag = new ArrayList();
        ArrayList<Tag> deleteTag = new ArrayList();
        ArrayList<Tag> newTag = new ArrayList();
        
        // Adiciona as tags antigas que permanecem em keepTag e as novas em newTag
        for(int i=0;i<tagItem.size();i++){
            for(int j=0;j<oldTags.size();j++){
                if(tagItem.get(i).getTagName().equals(oldTags.get(j).getTagName())){
                    keepTag.add(tagItem.get(i));
                } else {
                    newTag.add(tagItem.get(i));
                }                
            }
        }
        
        // Adiciona as tags que não existem mais apos a atualização em deleteTag
        for(int i=0;i<oldTags.size();i++){
            for(int j=0;j<keepTag.size();j++){
                if(!(keepTag.get(j).getTagName().equals(oldTags.get(i).getTagName()))){
                    deleteTag.add(oldTags.get(i));
                }
            }
        }
        
        // Instanciando item para update
        Item item = new Item();
        
        item.setNameItem(name);
        item.setDescriptionItem(description);
        item.setDateItem(dateItem);
        item.setUser(user);
        
        IKeepItem keepItem = new KeepItem();
        boolean result = keepItem.updateItem(item);
        
        if(result == false){
            //exceção
        } else {
            
            // Deleta as tags que foram retiradas
            result = keepItemTag.deleteTagInItem(deleteTag, Long.MIN_VALUE);
            
            if(result == false){
            //exceção
            } else {
            
                // Adiciona as novas tags
                ItemTag itemTag = new ItemTag();
                itemTag.setItem(item);
                itemTag.setListTags(newTag);
                
                result = keepItemTag.createTagInItem(itemTag);
                
                if(result == false){
                //exceção
                } else {
                    pageJSP = "/index.jsp";
                }
            }
        }
        
        return pageJSP;
    }
    
}
