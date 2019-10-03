/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.List;
import maps.Film;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Nacho
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    static List<Film> resultado= null;
    static Session sesion=null;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            sessionFactory =new Configuration().configure
                  (new File("src/resources/hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void abrirSesion(){
        sesion=null;
        sesion=getSessionFactory().openSession();
        sesion.beginTransaction();
    }
    
    public static void cerrarSesion(){
        sesion.close();
    }
    
    public static List realizarConsulta(String hql){
        try{
        abrirSesion();
        Query resultado = sesion.createQuery(hql);
        return resultado.list();
        } catch(Exception ex){
            System.out.println("Error "+ex); 
            return null;
        } finally {
            cerrarSesion();
        }
    }  
    
    public static List<Film> realizarConsultaActor(String hql){
        try{
        abrirSesion();
        Query resultado = sesion.createQuery(hql);
        return (List<Film>)resultado.list();
        } catch(Exception ex){
            System.out.println("Error "+ex); 
            return null;
        } finally {
            cerrarSesion();
        }
    }  
    
    
    
    
}
