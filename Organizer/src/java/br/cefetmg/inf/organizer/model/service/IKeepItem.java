/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.service;

import br.cefetmg.inf.organizer.model.domain.Item;

/**
 *
 * @author aline
 */
public interface IKeepItem {
    
    boolean create (Item item);
    boolean update(Item item);
    boolean delete(Item item);
    
}
