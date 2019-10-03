
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/**
 *
 * @author Nacho
 */
public class VentanaPrincipal extends JFrame {
    
    Acciones accion = new Acciones();
    
    JMenuBar menuBarra; 
    JPanel marco1, marco2, marco3, marco4, marco5;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8; 
    
    JCheckBox archivoCheckEmpleados, archivoCheckTrabajos;
    JButton abrirArchivo, guardarArchivo;
    
    ButtonGroup altaGrupo;
    JRadioButton altaProfesor,altaEmpleado,altaTrabajo;
    JButton darAlta;
    
    ButtonGroup datosGrupo;
    JRadioButton datosEmpleado,datosTrabajo;
    JButton verDatos;
    
    ButtonGroup consultaTabla;
    JRadioButton tablaEmpleados,tablaTrabajos;
    JButton consultar;
    
    File archivoGuardadoEmpleados, archivoTemporalEmpleados;
    File archivoGuardadoTrabajos, archivoTemporalTrabajos;
    
    public VentanaPrincipal(){
        
    //ficheros    
    archivoGuardadoEmpleados = new File("empleados.dat");
    archivoTemporalEmpleados = new File("emp.temp");
    archivoGuardadoTrabajos = new File("trabajos.dat");
    archivoTemporalTrabajos = new File("trab.temp");
    
    archivoTemporalEmpleados.deleteOnExit();
    archivoTemporalTrabajos.deleteOnExit();
    
    if (archivoTemporalEmpleados.exists()){
        archivoTemporalEmpleados.delete();
        System.out.println("Fichero temporal de los empleados borrado");
    }
    if (archivoTemporalTrabajos.exists()){
        archivoTemporalTrabajos.delete();
        System.out.println("Fichero temporal de los trabajos borrado");
    }
    
    
    
    //ventana principal
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800,600);
    setTitle("Gestión Trabajadores IES Ribera del Tajo");
    setResizable(false);
    setLocationRelativeTo(null);
       
    //setIconImage
    Toolkit pantalla= Toolkit.getDefaultToolkit();
    Image icono = pantalla.getImage("icono2.png");  
    setIconImage(icono);
    
    crearMenuBarra();
    crear1();
    crear2();
    crear3();
    crear4();
    crear5();
    
    add(marco1);
    add(marco2);
    add(marco3);
    add(marco4);
    add(marco5);
    
       
    }


    public void crearMenuBarra(){
        
        menuBarra = new JMenuBar();        
        
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem archivoAbrir = new JMenuItem("abrir");
        menuArchivo.add(archivoAbrir);
        JMenuItem archivoGuardar = new JMenuItem("guardar");
        menuArchivo.add(archivoGuardar);
        menuBarra.add(menuArchivo);
                
        JMenu menuAlta = new JMenu("Alta");
        JMenuItem altaProfesor = new JMenuItem("profesor");
        menuAlta.add(altaProfesor);
        JMenuItem altaEmpleado = new JMenuItem("empleado");
        menuAlta.add(altaEmpleado);
        JMenuItem altaTrabajo = new JMenuItem("trabajo");
        menuAlta.add(altaTrabajo);
        menuBarra.add(menuAlta);
        
        
        JMenu menuDatos = new JMenu("Datos");
        JMenuItem datosEmpleado = new JMenuItem("empleado");
        menuDatos.add(datosEmpleado);
        JMenuItem datosTrabajo = new JMenuItem("trabajo");
        menuDatos.add(datosTrabajo);
        menuBarra.add(menuDatos);
        
        
        JMenu menuListados = new JMenu("Listado");
        JMenuItem listadosEmpleado = new JMenuItem("empleado");
        menuListados.add(listadosEmpleado);
        JMenuItem listadosProfesor = new JMenuItem("profesor");
        menuListados.add(listadosProfesor);
        menuBarra.add(menuListados);
        
        setJMenuBar(menuBarra);
        
        
      
    }
    
    public void crear1(){
        
        marco1 = new JPanel();
        
        
        //Border borde1;
        //borde1 = new TitleBorder("sdfgsdfag");
        //marco1.setBorder(new TitleBorders("fdsg"));
        
        //marco1.setLayout(new BorderLayout());
        marco1.setBounds(0, 0, 400, 275);
        //marco1.setBackground(Color.RED);
        
        jp1= new JPanel();
        archivoCheckEmpleados = new JCheckBox("Empleados");  
        archivoCheckTrabajos = new JCheckBox("Trabajos");
        jp1.add(archivoCheckEmpleados);
        jp1.add(archivoCheckTrabajos);
        marco1.add(jp1);
        
        jp2 = new JPanel();
        abrirArchivo = new JButton("Abrir Datos Fichero");
        EventoAbrirArchivo pulsarAbrirArchivo = new EventoAbrirArchivo();
        abrirArchivo.addActionListener(pulsarAbrirArchivo);
        jp2.add(abrirArchivo);
        
        guardarArchivo = new JButton("Guardar Datos en Fichero");
        EventoGuardarArchivo pulsarGuardarArchivo = new EventoGuardarArchivo();
        guardarArchivo.addActionListener(pulsarGuardarArchivo);
        jp2.add(guardarArchivo);
        
        marco1.add(jp2);
    
        
         
    }
    
    public void crear2(){
        
        marco2 = new JPanel();
        marco2.setBounds(400, 0, 400, 275);
        marco2.setBackground(Color.BLUE);
        altaGrupo = new ButtonGroup();
        altaGrupo = new ButtonGroup(); 
        altaProfesor = new JRadioButton("Profesor");
        altaEmpleado = new JRadioButton("Empleado");
        altaTrabajo = new JRadioButton("Trabajo");
        altaGrupo.add(altaProfesor);
        altaGrupo.add(altaEmpleado);
        altaGrupo.add(altaTrabajo);
        marco2.add(altaProfesor);
        marco2.add(altaEmpleado);
        marco2.add(altaTrabajo);
        
        
        darAlta = new JButton("Dar de alta");
        EventoAlta pulsarAlta = new EventoAlta();
        darAlta.addActionListener(pulsarAlta);
        marco2.add(darAlta);
        
    }
    
    public void crear3(){
        
        marco3 = new JPanel();
        marco3.setBounds(0, 275, 400, 275);
        marco3.setBackground(Color.WHITE);
       
        datosGrupo = new ButtonGroup(); 
        datosEmpleado = new JRadioButton("Empleado");
        datosTrabajo = new JRadioButton("Trabajo");
        datosGrupo.add(datosEmpleado);
        datosGrupo.add(datosTrabajo);
        marco3.add(datosEmpleado);
        marco3.add(datosTrabajo);
        
        verDatos = new JButton("Ver los datos");
        EventoVer pulsarVer = new EventoVer();
        verDatos.addActionListener(pulsarVer);
        marco3.add(verDatos);
    }
    
    public void crear4(){
        
        marco4 = new JPanel();
        
        marco4.setBounds(400, 275, 400, 275);
        
        marco4.setBackground(Color.YELLOW);
        
        consultaTabla = new ButtonGroup();
        tablaEmpleados = new JRadioButton("Empleados");
        tablaTrabajos = new JRadioButton("Trabajos");
        consultaTabla.add(tablaEmpleados);
        consultaTabla.add(tablaTrabajos);
        marco4.add(tablaEmpleados);
        marco4.add(tablaTrabajos);
        
        consultar = new JButton("Consulta");
        EventoConsulta pulsarConsulta = new EventoConsulta();
        consultar.addActionListener(pulsarConsulta);
        marco4.add(consultar);
        
    }
    
    public void crear5(){
        marco5 = new JPanel();
        
    }

    public class EventoAbrirArchivo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado abrir archivo");
            
            if(archivoCheckEmpleados.isSelected()){
                System.out.println("pulsado abrir archivo - empleados");
                if (!archivoTemporalEmpleados.exists()){
                    accion.pasarDatosEntreFicheros(archivoGuardadoEmpleados, archivoTemporalEmpleados);
                    System.out.println("pasados los datos de empleados");
                } else {
                    System.out.println("borramos datos temp antiguos");
                    archivoTemporalEmpleados.delete();
                    accion.pasarDatosEntreFicheros(archivoGuardadoEmpleados, archivoTemporalEmpleados);
                    System.out.println("pasados los datos de empleados despues de borra temporales");
                }
            }    
            
            if(archivoCheckTrabajos.isSelected()){
                System.out.println("pulsado abrir archivo - trabajos");
                if (!archivoTemporalTrabajos.exists()){
                    accion.pasarDatosEntreFicheros(archivoGuardadoTrabajos, archivoTemporalTrabajos);
                    System.out.println("pasados los datos de los trabajos");
                } else {
                    System.out.println("borramos datos temp antiguos");
                    archivoTemporalTrabajos.delete();
                    accion.pasarDatosEntreFicheros(archivoGuardadoTrabajos, archivoTemporalTrabajos);
                    System.out.println("pasados los datos de los trabajos despues de borra temporales");
                }
            }
        
            if(!archivoCheckEmpleados.isSelected() & !archivoCheckTrabajos.isSelected()){
                System.out.println("no hay nada pulsado");
            }
        }
    }
    
    public class EventoGuardarArchivo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado guardar archivo");
            
            if(archivoCheckEmpleados.isSelected()){
                System.out.println("pulsado guardar archivo - empleados");
                if(!archivoTemporalEmpleados.exists()){
                    System.out.println("No hay datos temporales que guardar");        
                } else {
                    if(archivoGuardadoEmpleados.exists()){
                        archivoGuardadoEmpleados.delete();
                    }
                    accion.pasarDatosEntreFicheros(archivoTemporalEmpleados, archivoGuardadoEmpleados);
                    System.out.println("fichero temporal guardado");
                }
            } 
            if(archivoCheckTrabajos.isSelected()){
                System.out.println("pulsado guardar archivo - trabajos");
            } 
            
            if(!archivoCheckEmpleados.isSelected() & !archivoCheckTrabajos.isSelected()){
                System.out.println("no hay nada pulsado");
            }
        }
    }   
    
    public class EventoAlta implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado alta");
            if (altaProfesor.isSelected()){
                System.out.println("pulsado alta - Profesor");
                accion.crearFormulario(VentanaPrincipal.this, "Alta Profesor");
                accion.formulario2.setVisible(true);
            }else if (altaEmpleado.isSelected()){
                System.out.println("pulsado alta - Empleado");
                accion.crearFormulario(VentanaPrincipal.this, "Alta Empleado");
                accion.formulario2.setVisible(true);
                
            }else if (altaTrabajo.isSelected()){
                accion.crearFormularioTrabajos(VentanaPrincipal.this);
                System.out.println("pulsado alta - Trabajo");
                
            }else{
                System.out.println("no hay nada pulsado");
            }    
        }
    }  
    
    public class EventoVer implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado ver");
            
            if (datosEmpleado.isSelected()){
                System.out.println("pulsado ver trabajador");
                if (!archivoTemporalEmpleados.exists()){
                    System.out.println("No existe el fichero temporal de empleados");
                } else {
                    accion.crearFormulario(VentanaPrincipal.this, "Edición Trabajador");
                    accion.rellenarFormularioEdicion(1);
                    accion.anterior.setEnabled(false);
                    accion.formulario2.setVisible(true);
                }
            } else if  (datosTrabajo.isSelected()){
                accion.crearFormularioEdicionTrabajos(VentanaPrincipal.this);
                //accion.rellenarFormularioEdicionTrabajador(1);
                
                System.out.println("pulsado ver trabajo");
                
            } else /*if (!datosEmpleado.isSelected() & !datosTrabajo.isSelected())*/{
                System.out.println("no hay nada marcado");
            
            }
            
        }
    }  
    
    public class EventoConsulta implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado consulta");
            if(tablaEmpleados.isSelected()){
                System.out.println("pulsado consulta empleados");
                accion.crearTablaEmpleados();
                
                File a1 = new File("aaaa.dat");
                File a2 = new File("bbbb.txt");
                accion.pasarDatosEntreFicheros(a1, a2);
                
            } else if (tablaTrabajos.isSelected()){
                //accion.crearTablaTrabajos();
                accion.crearTablaTrabajos();
                System.out.println("pulsado consulta trabajos");
            } else {
                System.out.println("no hay nada marcado");
            }
        }
    }  
    
}