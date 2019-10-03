
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 *
 * @author Nacho
 */
public class VentanaPrincipal extends JFrame {
    
    Acciones accion = new Acciones();
    
    JMenuBar menuBarra; 
    JPanel marco1;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8; 
    JLabel mensaje;
    
    
    File archivoGuardadoEmpleados, archivoTemporalEmpleados;
    File archivoGuardadoTrabajos, archivoTemporalTrabajos;
    File archivoTemporalEmpleados2,archivoTemporalTrabajos2;
    
    public VentanaPrincipal(){
        
    //en el constructor creamos los ficheros que vamos a utilizar      
    archivoGuardadoEmpleados = new File("empleados.dat");
    archivoTemporalEmpleados = new File("emp.temp");
    archivoTemporalEmpleados2 = new File("emp2.temp");
    archivoGuardadoTrabajos = new File("trabajos.dat");
    archivoTemporalTrabajos = new File("trab.temp");
    archivoTemporalTrabajos2 = new File("trab2.temp");
    
    archivoTemporalEmpleados.deleteOnExit();
    archivoTemporalEmpleados2.deleteOnExit();
    archivoTemporalTrabajos.deleteOnExit();
    archivoTemporalTrabajos2.deleteOnExit();
   
    //validamos que no haya datos temporales anteriores
    if (archivoTemporalEmpleados.exists()){
        archivoTemporalEmpleados.delete();
        System.out.println("Fichero temporal de los empleados borrado");
    }
    if (archivoTemporalEmpleados2.exists()){
        archivoTemporalEmpleados.delete();
        System.out.println("Fichero temporal de los empleados2 borrado");
    }
    
    if (archivoTemporalTrabajos.exists()){
        archivoTemporalTrabajos.delete();
        System.out.println("Fichero temporal de los trabajos borrado");
    }
    
    if (archivoTemporalTrabajos2.exists()){
        archivoTemporalTrabajos2.delete();
        System.out.println("Fichero temporal de los trabajos2 borrado");
    }
    
    
    
    
    //creamos la ventana principal del programa
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800,450);
    setTitle("Gestión Trabajadores IES Ribera del Tajo");
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    //cambiamos el icono del programa
    Toolkit pantalla= Toolkit.getDefaultToolkit();
    Image icono = pantalla.getImage("icono.png");  
    setIconImage(icono);
    
    crearMenuBarra();
    
    //creamos el panel donde vamos a "imprimir" los menus
    marco1 = new JPanel();
    marco1.setVisible(false);
    add(marco1);
       
    }


    //creamos la barra del programa, con acceso a teclas directas incluidas
    public void crearMenuBarra(){
        
        menuBarra = new JMenuBar();        
        
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic('A');
        JMenuItem archivoAbrir = new JMenuItem("Abrir archivos",'A' );
        EventoAbrirArchivo pulsarAbrirMenu = new EventoAbrirArchivo();
        archivoAbrir.addActionListener(pulsarAbrirMenu);
        menuArchivo.add(archivoAbrir);
        JMenuItem archivoGuardar = new JMenuItem("Guardar archivos",'G');
        EventoGuardarArchivo pulsarGuardarMenu = new EventoGuardarArchivo();
        archivoGuardar.addActionListener(pulsarGuardarMenu);
        menuArchivo.add(archivoGuardar);
        menuBarra.add(menuArchivo);
        
        JMenu menuAlta = new JMenu("Dar de Alta");
        menuAlta.setMnemonic('D');
        JMenuItem altaEmpleado = new JMenuItem("Empleado",'E');
        EventoAltaEmpleado pulsarAltaEmpleado = new EventoAltaEmpleado();
        altaEmpleado.addActionListener(pulsarAltaEmpleado);
        menuAlta.add(altaEmpleado);
        JMenuItem altaTrabajo = new JMenuItem("Trabajo",'T');
        EventoAltaTrabajo pulsarAltaTrabajo = new EventoAltaTrabajo();
        altaTrabajo.addActionListener(pulsarAltaTrabajo);
        menuAlta.add(altaTrabajo);
        menuBarra.add(menuAlta);
        
        
        JMenu menuDatos = new JMenu("Mostrar Datos");
        menuDatos.setMnemonic('M');
        JMenuItem datosEmpleado = new JMenuItem("Empleados",'E');
        EventoVerEmpleado pulsarVerEmpleado = new EventoVerEmpleado();
        datosEmpleado.addActionListener(pulsarVerEmpleado);
        menuDatos.add(datosEmpleado);
        JMenuItem datosTrabajo = new JMenuItem("Trabajos",'T');
        EventoVerTrabajo pulsarVerTrabajo = new EventoVerTrabajo();
        datosTrabajo.addActionListener(pulsarVerTrabajo);
        menuDatos.add(datosTrabajo);
        menuBarra.add(menuDatos);
        
        
        JMenu menuListados = new JMenu("Listados");
        menuListados.setMnemonic('L');
        JMenuItem listadosEmpleado = new JMenuItem("Empleados",'E');
        EventoConsultaEmpleados pulsarListarEmpleados = new EventoConsultaEmpleados();
        listadosEmpleado.addActionListener(pulsarListarEmpleados);
        menuListados.add(listadosEmpleado);
        JMenuItem listadosTrabajos = new JMenuItem("Trabajos",'T');
        EventoConsultaTrabajos pulsarListarTrabajos = new EventoConsultaTrabajos();
        listadosTrabajos.addActionListener(pulsarListarTrabajos);
        menuListados.add(listadosTrabajos);
        menuBarra.add(menuListados);
                
        setJMenuBar(menuBarra);
        
        
      
    }
    
    //funcion de ayuda para mostrar un mensaje en el marco1
    public void mostrarMensaje(String mens, Color color){
        marco1.removeAll();
        marco1.setLayout(new BorderLayout());
        mensaje = new JLabel("                       "+mens);
        mensaje.setForeground(color);
        marco1.add(mensaje,BorderLayout.CENTER);
        marco1.setVisible(true);
        VentanaPrincipal.this.setVisible(true);
        VentanaPrincipal.this.repaint();
    }
    
    //funcion para añadir al titulo en que seccion estamos
    public void modificaTitulo(String cambiaTitulo){
        setTitle("Gestión Trabajadores IES Ribera del Tajo"
                    + " ---------- "+cambiaTitulo);
    }
    
    
    //parte de los eventos
    
    //pasamos el archivo.dat a los temporales para trabajar con ellos
    public class EventoAbrirArchivo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Archivo - Abrir archivos");
            VentanaPrincipal.this.setTitle("Gestión Trabajadores IES Ribera del Tajo");
            
           
            System.out.println("abriendo archivo de empleados...");
            if (!archivoTemporalEmpleados.exists()){
                accion.pasarDatosEntreFicheros(archivoGuardadoEmpleados, archivoTemporalEmpleados);
                System.out.println("pasados los datos de empleados");
            } else {
                System.out.println("borramos datos temp antiguos");
                archivoTemporalEmpleados.delete();
                accion.pasarDatosEntreFicheros(archivoGuardadoEmpleados, archivoTemporalEmpleados);
                System.out.println("pasados los datos de empleados despues de borra temporales");
            }


            System.out.println("abriendo archivo de trabajos");
            if (!archivoTemporalTrabajos.exists()){
                accion.pasarDatosEntreFicheros(archivoGuardadoTrabajos, archivoTemporalTrabajos);
                System.out.println("pasados los datos de los trabajos");
            } else {
                System.out.println("borramos datos temp antiguos");
                archivoTemporalTrabajos.delete();
                accion.pasarDatosEntreFicheros(archivoGuardadoTrabajos, archivoTemporalTrabajos);
                System.out.println("pasados los datos de los trabajos despues de borra temporales");
            }
            
            mostrarMensaje("Ficheros .dat cargados en memoria", Color.BLUE);
        }
    }
    
    //pasamos los datos temporales a .dat
    public class EventoGuardarArchivo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Archivo - Guardar archivos");
            VentanaPrincipal.this.setTitle("Gestión Trabajadores IES Ribera del Tajo");
            
            if(!archivoTemporalEmpleados.exists()||!archivoTemporalTrabajos.exists()){
                System.out.println("No hay datos temporales que guardar"); 
                mostrarMensaje("  No hay datos temporales en memoria "
                        + " para poder guardar los datos",Color.RED);
            } else {
                
                archivoGuardadoEmpleados.delete();
                archivoGuardadoTrabajos.delete();
                accion.guardarDatos();
                archivoTemporalEmpleados.delete();
                archivoTemporalTrabajos.delete();
                System.out.println("fichero temporal guardado");
                mostrarMensaje("Los ficheros cargados en memoria han sido pasado al disco duro", Color.BLUE);
                
            }
                
            }
    }   
    
    
    //menu donde damos de alta nuevos empleados
    public class EventoAltaEmpleado implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Dar de Alta - Alta empleado");
            //si no hay trabajos cargados, creamos unos por defecto
            //Equipo directivo-Profesor-Tutor-Administrativo
            if(!archivoTemporalTrabajos.exists()){
                System.out.println("No hay datos temporales sobre los trabajos existentes que abrir");
                System.out.println("Creamos unos trabajos temporales por defecto");
                System.out.println("Equipo directivo-Profesor-Tutor-Administrativo");
                accion.mostrarMensaje(marco1, "Creados trabajos por defecto");
                accion.crearFicheroTrabajosInicial();
            } 
            modificaTitulo("Alta de empleados");
            mostrarMensaje(" ", Color.BLUE);
            marco1.removeAll();
            marco1.add(accion.crearFormulario("Alta Empleado"));
            VentanaPrincipal.this.add(marco1);
            VentanaPrincipal.this.setVisible(true);
            VentanaPrincipal.this.repaint();
            
            
        }
    }  
    
    //donde creamos nuevos trabajos
    public class EventoAltaTrabajo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Dar de Alta - Alta Trabajo");
            modificaTitulo("Alta de Trabajo");
            mostrarMensaje(" ", Color.BLUE);
            marco1.removeAll();
            marco1.add(accion.crearFormularioTrabajos());
            VentanaPrincipal.this.add(marco1);
            VentanaPrincipal.this.setVisible(true);
            VentanaPrincipal.this.repaint();
            
        }
    }  
    
    
    //donde vemos y podemos modificar los empleados uno a uno
    public class EventoVerEmpleado implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Mostrar datos - Empleados");
            modificaTitulo("Edición de empleados");
            if (!archivoTemporalEmpleados.exists()){
                System.out.println("No existe el fichero temporal en memoria empleados");
                mostrarMensaje("  No hay datos temporales en memoria "
                        + " para poder mostrar empleados",Color.RED);
            } else {
                marco1.removeAll();
            
                marco1.add(accion.crearFormulario("Edición Trabajador"));
            
                VentanaPrincipal.this.add(marco1);
                VentanaPrincipal.this.setVisible(true);
                VentanaPrincipal.this.repaint();
                
                accion.rellenarFormularioEdicion(1);
                accion.anterior.setEnabled(false);
                accion.habilitarMenuEdicionTrabajador(false);
                
            }
        } 
    }  
    
    //donde podemos eliminar los trabajos
    public class EventoVerTrabajo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Mostrar datos - Trabajos");
            modificaTitulo("Edición de trabajos");
            if (!archivoTemporalTrabajos.exists()){
                System.out.println("No existe el fichero temporal de trabajos");
                mostrarMensaje("  No hay datos temporales en memoria "
                        + " para poder mostrar trabajos",Color.RED);
            } else {
                marco1.removeAll();
                
                marco1.add(accion.crearFormularioEdicionTrabajos(),BorderLayout.CENTER);
            
                VentanaPrincipal.this.add(marco1);
                VentanaPrincipal.this.setVisible(true);
                VentanaPrincipal.this.repaint();
            }
        } 
    }  
    
    
    //donde vemos un listado de los empleados
    public class EventoConsultaEmpleados implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Listados - Empleados");
            modificaTitulo("Listado de empleados");
            if (!archivoTemporalEmpleados.exists()){
                System.out.println("No existe el fichero temporal de empleados");
                mostrarMensaje("  No hay datos temporales en memoria "
                        + " para poder mostrar un listado de empleados",Color.RED);
                
            } else {
            marco1.removeAll();
            
            marco1.add(accion.crearTablaEmpleados());

            VentanaPrincipal.this.add(marco1);
            VentanaPrincipal.this.setVisible(true);
            VentanaPrincipal.this.repaint();
            }
        }
    }  
    
    //donde listamos los tipos de trabajo existentes
    public class EventoConsultaTrabajos implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado menu Listados - Trabajos");
            modificaTitulo("Listado de trabajos");
            if (!archivoTemporalTrabajos.exists()){
                System.out.println("No existe el fichero temporal de trabajos");
                mostrarMensaje("  No hay datos temporales en memoria "
                        + " para poder mostrar un listado de trabajos",Color.RED);
            } else {
            marco1.removeAll();
            marco1.setLayout(new BoxLayout(marco1,BoxLayout.Y_AXIS));
            marco1.add(accion.crearTablaTrabajos());
            VentanaPrincipal.this.add(marco1);
            VentanaPrincipal.this.setVisible(true);
            VentanaPrincipal.this.repaint();
            }
            
        }
    }  
    
    
    
}