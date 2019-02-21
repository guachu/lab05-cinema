/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.Filters.impl;

import edu.eci.arsw.cinema.Filters.FiltrosPersitence;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jfmor
 */

public class FiltroSillasPersistence implements FiltrosPersitence{

    @Override
    public List<Cinema> FiltredBy(Cinema cine, String date, String filtro) {
        int valorSillas = Integer.decode(filtro);
        List<Cinema> cinesAceptados = new ArrayList<Cinema>();
        List<CinemaFunction> listaFunciones = cine.getFunctions();
        for(CinemaFunction i : listaFunciones){
//            if(i.){
//                
//            }
        }
    }
    
}
