/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.services.CinemaServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.fail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;






/**
 *
 * @author jfmor
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext appCont = new ClassPathXmlApplicationContext("applicationContext.xml");
        CinemaServices cinServ = appCont.getBean(CinemaServices.class);
        
        
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        CinemaFunction funct3 = new CinemaFunction(new Movie("Mora Potter y el despertar de las moras","Adventure"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        functions.add(funct3);
        Cinema c=new Cinema("Movies Bogotá",functions);
        try {
            cinServ.addNewCinema(c);
        } catch (CinemaPersistenceException ex) {
            fail("Cinema persistence failed inserting the first cinema.");
        }
        Map<String,Cinema> cinesDisponibles = cinServ.getAllCinemas();
        System.out.println("Este cinema se a encunetra registrado en nuestros cines? " + (cinesDisponibles.get("Movies Bogotá").getName().equals(c.getName())));
        Cinema cineBuscado = cinesDisponibles.get("Movies Bogotá");
        List<CinemaFunction> listafunciones = cinServ.getFunctionsbyCinema("Movies Bogotá");
        for(int i = 0; i < listafunciones.size(); i++){
            System.out.println("Estas son las funciones disponibles en el cine "+ cineBuscado.getName() + " " + listafunciones.get(i).getMovie().getName() + " " + listafunciones.get(i).getDate());
        }
        try {
            cinServ.buyTicket(0, 0, cineBuscado.getName(), "2018-12-18 15:30", listafunciones.get(0).getMovie().getName());
            System.out.println("La compra se a realizado con exito");
        } catch (CinemaException e) {
            fail("No se compro el ticket por que la silla esta reservada.");
        }
        

        
        
        functionDate = "2018-12-20 15:30";
        functions= new ArrayList<>();
        funct1 = new CinemaFunction(new Movie("Moramon y la piedra del morador","Action"),functionDate);
        funct2 = new CinemaFunction(new Movie("La noche de las moras 2","Horror"),functionDate);
        funct3 = new CinemaFunction(new Movie("Mora Potter y el despertar de las moras","Adventure"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        functions.add(funct3);
        c=new Cinema("Movies Medellin",functions);
        try {
            cinServ.addNewCinema(c);
        } catch (CinemaPersistenceException ex) {
            fail("Cinema persistence failed inserting the first cinema.");
        }
        
        cinesDisponibles = cinServ.getAllCinemas();
        System.out.println("Este cinema se a encunetra registrado en nuestros cines? " + (cinesDisponibles.get("Movies Medellin").getName().equals(c.getName())));
        cineBuscado = cinesDisponibles.get("Movies Medellin");
        listafunciones = cinServ.getFunctionsbyCinema("Movies Medellin");
        for(int i = 0; i < listafunciones.size(); i++){
            System.out.println("Estas son las funciones disponibles en el cine "+ cineBuscado.getName() + " " + listafunciones.get(i).getMovie().getName() + " " + listafunciones.get(i).getDate());
        }
        try {
            cinServ.buyTicket(0, 0, cineBuscado.getName(), "2018-12-20 15:30", listafunciones.get(0).getMovie().getName());
            System.out.println("La compra se a realizado con exito");
        } catch (CinemaException e) {
            fail("No se compro el ticket por que la silla esta reservada.");
        }
        
    }
}
