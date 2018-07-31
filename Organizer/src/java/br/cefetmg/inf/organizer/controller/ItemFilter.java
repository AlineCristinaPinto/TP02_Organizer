package br.cefetmg.inf.organizer.controller;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepItem;
import br.cefetmg.inf.organizer.model.service.impl.KeepItem;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ItemFilter implements GenericProcess {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";
        ArrayList<Tag> tagList = new ArrayList<>();
        ArrayList<String> typeList = new ArrayList<>();
        List<Item> itemList;
        String[] tags;
        String[] types;
        
        //booleans to check if the filter is being used
        boolean tagFiltering = false, typeFiltering = false;
        
        //getting values from the checkboxes
        tags = req.getParameterValues("tag");
        types = req.getParameterValues("tipo");
        
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        //User user = new User();
        //user.setCodEmail("lgthxt@gmail.com");
        
        //checking if there is any tag to filter
        if(tags != null){
            tagFiltering = true;
            for(String tagName : tags){
                Tag tag = new Tag();
                tag.setTagName(tagName);
                tag.setUser(user);
                tagList.add(tag);
            }
        }
        
        //checking if there is any type to filter
        if(types != null){
            typeFiltering = true;
            for(String type : types){
                //Formatting type to "sim", "lem" or "tar"
                type = type.substring(0, 3);
                typeList.add(type);
            }
        }
        
        IKeepItem keepItem = new KeepItem();
        
        if(tagFiltering && typeFiltering){
            itemList = keepItem.searchItemByTagAndType(tagList, typeList, user);
        }else if(tagFiltering){
            itemList = keepItem.searchItemByTag(tagList, user);
        }else if(typeFiltering){
            itemList = keepItem.searchItemByType(typeList, user);
        }else{
            itemList = keepItem.listAllItem(user);
        }
        
        //maybe swap this to response if using ajax
        //or session (?)
        if(itemList == null){
            req.setAttribute("itemList", new ArrayList());
        }else{
            req.setAttribute("itemList", itemList);
        }
        
        pageJSP = "/index.jsp";
        
        return pageJSP;
    }
    
}
