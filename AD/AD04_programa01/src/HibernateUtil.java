/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import maps.Actor;
import maps.Film;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
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
        sesion = getSessionFactory().openSession();
        sesion.beginTransaction();
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
    
    public static String insertarActor(Actor actor, String tipo){
        abrirSesion();
        try{
        sesion.saveOrUpdate(actor);
        if (tipo.equals("creado")){
            sesion.save(actor);
        } else {        
            sesion.saveOrUpdate(actor);
        }
        sesion.getTransaction().commit();
        sesion.flush();
        return "usuario "+tipo;
        }catch(Exception ex){
            System.out.println(ex);
            return "error; "+ex;
        }finally{
            cerrarSesion();
        }
    }
    
    
    public static String eliminarActor(Actor actor){
        abrirSesion();
        try{
        sesion.delete(actor);
        sesion.getTransaction().commit();
        sesion.flush();
        return "usuario borrado";
        }catch(Exception ex){
            System.out.println(ex);
            return "No se ha podido borrar:"+ex;
        }finally{
            cerrarSesion();
        }
    }
        
        
    
    
    public static void cerrarSesion(){
        sesion.close();
    }
}
