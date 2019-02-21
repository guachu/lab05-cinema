/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.Filters;

import edu.eci.arsw.cinema.model.Cinema;
import java.util.List;

/**
 *
 * @author jfmor
 */
public interface FiltrosPersitence {
    
    public List<Cinema> FiltredBy(Cinema cine, String date, String filtro);
    
}
