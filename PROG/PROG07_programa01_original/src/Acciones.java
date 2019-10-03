
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Nacho
 */
public class Acciones {
 
    //formulario
    String tipoFormulario, titulo;
    JDialog formulario2, altaTrabajo, edicionTrabajo;
    JPanel formulario; 
    JPanel jp1, jp2, jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11,jp12,jp13,jp14,jp15,jp16,
            jp17,jp18,jp19,jp20,jp21,jp22,jp23; 
    JPanel botonesFormulario,botonesFormularioEdicion1,botonesFormularioEdicion2;
    JLabel  jlTrabajo,jlNombre, jlApellido1, jlApellido2,jlNif, jlEmail, jlTelefono,jlFechaAlta,
            jlTrabajo2,jlDescripcion,jlRegistroE;           
    JTextField nombre, apellido1, apellido2,nif, email, telefono,fechaAlta,trabajo,descripcion,
            descripcionE, trabajoE;
    JComboBox comboTrabajos;
    DefaultComboBoxModel modeloComboTrabajos;
    JToggleButton interino;
    String [] campos ;
    Vector vectorTipoTrabajos;
    JButton guardar, salir, editar, borrar, siguiente, anterior, guardarTrabajo,
            anteriorE,editarE,guardarE,siguienteE,salirE;
    JLabel numRegistroTexto;
    VentanaPrincipal aaa;
    
    //tabla
    File fichero;
    JTable tabla;
    DefaultTableModel datos;
    JFrame tablaEmpleados, ventanaTablaTrabajos, mensaje;
    JScrollPane scrollTabla;
    String[] titulos = {"Tipo de trabajador","Interino","Nombre","Apellido1","Apellido2","NIF",
                            "email","Telefono","Fecha de ingreso"} ;
    JList listaTrabajos;
    JPanel jpLista;
    
    
    //ficheros
    FileReader flujoLectura;
    FileWriter flujoEscritura;
    BufferedReader bufferLectura;
    BufferedWriter bufferEscritura;
    String linea;      
    int contadorLineas; 
    int registro=1;
    int registroT=1;
    File archivoGuardadoEmpleados, archivoTemporalEmpleados;
    File archivoGuardadoTrabajos, archivoTemporalTrabajos;
    String res;
    
            
    public Acciones(){
        
        archivoGuardadoEmpleados = new File("empleados.dat");
        archivoTemporalEmpleados = new File("emp.temp");
        archivoGuardadoTrabajos = new File("trabajos.dat");
        archivoTemporalTrabajos = new File("trab.temp");   
    }
    
    
//Parte grafica de los empleados
    public void crearFormulario(VentanaPrincipal frame, String tipoFormulario){
        
        titulo = tipoFormulario;
        formulario2 = new JDialog(frame, titulo, true);
        formulario2.setSize(500, 500);
        formulario2.setResizable(false);
        formulario2.setLocationRelativeTo(null);
        //formulario2.setUndecorated(true);// para quitar la x
        
        
        formulario = new JPanel();
        formulario.setLayout(new BoxLayout(formulario,BoxLayout.Y_AXIS));
        
        if(titulo.equals("Edición Trabajador")){
            jp8 = new JPanel();
            siguiente = new JButton("Siguiente");
            EventoPulsarSiguiente pulsarSiguiente =new EventoPulsarSiguiente();
            siguiente.addActionListener(pulsarSiguiente);
            numRegistroTexto = new JLabel("Registro numero "+registro+ " de "+numerarRegistro(archivoTemporalEmpleados));
            anterior = new JButton("Anterior");
            EventoPulsarAnterior pulsarAnterior =new EventoPulsarAnterior();
            anterior.addActionListener(pulsarAnterior);
            jp8.add(anterior);
            jp8.add(numRegistroTexto);
            jp8.add(siguiente);
            formulario.add(jp8);
        }
        
        jp12 = new JPanel();
        jlTrabajo = new JLabel("Tipo de trabajador: ");
        jp12.add(jlTrabajo);
        
        //ponemos en el combo los tipos de trabajadores que hay dados de alta
        if(titulo.equals("Alta Profesor")){
            comboTrabajos = new JComboBox();
            comboTrabajos.addItem("Profesor");
            comboTrabajos.setEnabled(false);
           
        } else if(titulo.equals("Edición Trabajador")){
            //modeloComboTrabajos = new DefaultComboBoxModel(obtenerTrabajos(archivoGuardadoTrabajos, ""));
            modeloComboTrabajos = new DefaultComboBoxModel(obtenerTrabajos(archivoTemporalTrabajos, ""));
            comboTrabajos = new JComboBox(modeloComboTrabajos);
            //comboTrabajos.addItem("");
        } else {
            String aux;
            modeloComboTrabajos = new DefaultComboBoxModel(obtenerTrabajos(archivoTemporalTrabajos, "Profesor"));
            comboTrabajos = new JComboBox(modeloComboTrabajos); 
        }
        jp12.add(comboTrabajos);
        
        
        if(titulo.equals("Alta Profesor")||titulo.equals("Edición Trabajador")){
            interino = new JToggleButton("Si es interino", true);
            EventoCambiaBotonInterino pulsarInterino = new EventoCambiaBotonInterino();
            interino.addActionListener(pulsarInterino);
            jp12.add(interino);
        }    
        formulario.add(jp12);        
        
        jp1 = new JPanel();
        jlNombre = new JLabel("Nombre: ");
        nombre = new JTextField(30);
        jp1.add(jlNombre);
        jp1.add(nombre);
        formulario.add(jp1);
        
        jp2 = new JPanel();
        jlApellido1 = new JLabel("Apellido 1: "); 
        apellido1 = new JTextField(29);
        jp2.add(jlApellido1);
        jp2.add(apellido1);
        formulario.add(jp2);
        
        jp3 = new JPanel();
        jlApellido2 = new JLabel("Apellido 2: "); 
        apellido2 = new JTextField(29);
        jp3.add(jlApellido2);
        jp3.add(apellido2);
        formulario.add(jp3);
        
        jp4 = new JPanel();
        jlNif = new JLabel("Nif: ");
        nif = new JTextField(9);
        jp4.add(jlNif);
        jp4.add(nif);
        formulario.add(jp4);
        
        jp5 = new JPanel();
        jlEmail = new JLabel("Email: ");
        email = new JTextField(37);
        jp5.add(jlEmail);
        jp5.add(email);
        formulario.add(jp5);
        
        jp6 = new JPanel();
        jlTelefono = new JLabel("Telefono: ");
        telefono = new JTextField(9);
        jp6.add(jlTelefono);
        jp6.add(telefono);
        formulario.add(jp6);
        
        jp7 = new JPanel();
        jlFechaAlta = new JLabel("Fecha Alta: ");
        fechaAlta = new JTextField(10);
        jp7.add(jlFechaAlta);
        jp7.add(fechaAlta);
        formulario.add(jp7);
        
        
        botonesFormulario = new JPanel();
        if(titulo.equals("Edición Trabajador")){
            
            
            editar = new JButton("Editar");
            borrar = new JButton("Borrar");
            botonesFormulario.add(editar);
            botonesFormulario.add(borrar);
        }
        
        guardar = new JButton("Guardar");
        EventoGuardarEmpleado guardarEmpleado = new EventoGuardarEmpleado();
        guardar.addActionListener(guardarEmpleado);
        botonesFormulario.add(guardar);
        
        salir = new JButton("Salir");
        
        botonesFormulario.add(salir);
        
          
        formulario.add(botonesFormulario);
        
        formulario2.add(formulario);
        
        
        
        //error en ventana nueva
        //JOptionPane.showMessageDialog(ventanaPadre, "mensaje de error", "título de la ventana", JOptionPane.ERROR_MESSAGE);
        
        //formulario2.setVisible(true);
    }
    
    public void crearTablaEmpleados(){
        
        
        tablaEmpleados = new JFrame("Tabla de empleados");
        tablaEmpleados.setSize(500,500);
        tablaEmpleados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tablaEmpleados.setLocationRelativeTo(null);
        tablaEmpleados.setResizable(false);
        
        scrollTabla = new JScrollPane();
        tablaEmpleados.add(scrollTabla);
        
        datos = new DefaultTableModel();         
        datos.setColumnIdentifiers(titulos);
        //datos.addRow(titulos);
        tabla = new JTable(datos);
        
        scrollTabla.setViewportView(tabla);
        scrollTabla.createHorizontalScrollBar();
        scrollTabla.createVerticalScrollBar();
        tabla.setEnabled(false);
        
        //tabla.setAutoCreateRowSorter(true);
        
        ///////////////////////////
         bufferLectura = null;
         
      try
     {
        bufferLectura = new BufferedReader(new FileReader(archivoTemporalEmpleados));
        linea = bufferLectura.readLine();
       
       while (linea != null )
       {
        campos = linea.split(",");
        datos.addRow(campos);
        System.out.println(linea);
        linea = bufferLectura.readLine();
        }
       bufferLectura.close();
       
     }
     catch(Exception e)
      {
          	System.out.println("sdfsdaf");
      }
      
      //tablaEmpleados.add(tabla);
      
      tablaEmpleados.setVisible(true);
      
    /*    archivoTemporalEmpleados = new File("aaaa.dat");
        if(consultarExistenciaFichero(archivoTemporalEmpleados)){
            System.out.println("true");
            
        } else {
            System.out.println("false");
        }  */
        
    }
    
    public void crearTablaTrabajos(){
        
        
        tablaEmpleados = new JFrame("Tabla");
        tablaEmpleados.setSize(500,500);
        tablaEmpleados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tablaEmpleados.setLocationRelativeTo(null);
        tablaEmpleados.setResizable(false);
        
        scrollTabla = new JScrollPane();
        tablaEmpleados.add(scrollTabla);
        
        datos = new DefaultTableModel();
        Vector aaa = new Vector();
        aaa.addElement("Trabajo");
        aaa.addElement("Descripción");
        
        datos.setColumnIdentifiers(aaa);
        //datos.addRow(aaa);
        tabla = new JTable(datos);
        
        scrollTabla.setViewportView(tabla);
        scrollTabla.createHorizontalScrollBar();
        scrollTabla.createVerticalScrollBar();
        tabla.setEnabled(false);
        
        //tabla.setAutoCreateRowSorter(true);
        
        ///////////////////////////
         bufferLectura = null;
         
      try
     {
        bufferLectura = new BufferedReader(new FileReader(archivoTemporalTrabajos));
        linea = bufferLectura.readLine();
       
       while (linea != null )
       {
        campos = linea.split(",");
        datos.addRow(campos);
        System.out.println(linea);
        linea = bufferLectura.readLine();
        }
       bufferLectura.close();
       
     }
     catch(Exception e)
      {
          	System.out.println("sdfsdaf");
      }
      
      //tablaEmpleados.add(tabla);
      
      tablaEmpleados.setVisible(true);
      
    /*    archivoTemporalEmpleados = new File("aaaa.dat");
        if(consultarExistenciaFichero(archivoTemporalEmpleados)){
            System.out.println("true");
            
        } else {
            System.out.println("false");
        }  */
        
    }
    
  
//Parte grafica de los trabajos
    public void crearFormularioTrabajos(VentanaPrincipal frame){
        altaTrabajo = new JDialog(frame, "Alta de trabajos", true);
        altaTrabajo.setSize(450,140);
        altaTrabajo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        altaTrabajo.setLocationRelativeTo(null);
        altaTrabajo.setResizable(false);
        
        jp13 = new JPanel();
        jp14 = new JPanel();
        jlTrabajo2 = new JLabel("Trabajo a añadir: ");
        trabajo = new JTextField(30);
        jp14.add(jlTrabajo2);
        jp14.add(trabajo);
        jp13.add(jp14);
        
        jp16 = new JPanel();
        jlDescripcion = new JLabel("Descripcion: ");
        descripcion = new JTextField(30);
        jp16.add(jlDescripcion);
        jp16.add(descripcion);
        jp13.add(jp16);
        
        altaTrabajo.add(jp13);
        guardarTrabajo = new JButton("Guardar");
        jp13.add(guardarTrabajo);
        altaTrabajo.setVisible(true);
        
    }
    
    public void crearFormularioEdicionTrabajos(VentanaPrincipal frame){
        edicionTrabajo = new JDialog(frame, "Editar trabajos", true);
        edicionTrabajo.setSize(450,180);
        edicionTrabajo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        edicionTrabajo.setLocationRelativeTo(null);
        edicionTrabajo.setResizable(false);
        
        //18 19 20
        
        jp18 = new JPanel();
        
        jp23 = new JPanel();
        jlRegistroE = new JLabel("Registro "+ registroT +" de "+ numerarRegistro(archivoTemporalTrabajos));
        jp18.add(jlRegistroE);
        
        jp19 = new JPanel();
        jlTrabajo2 = new JLabel("Trabajo: ");
        trabajoE = new JTextField(30);
        jp19.add(jlTrabajo2);
        jp19.add(trabajoE);
        jp18.add(jp19);
        
        jp20 = new JPanel();
        jlDescripcion = new JLabel("Descripcion: ");
        descripcionE = new JTextField(30);
        jp20.add(jlDescripcion);
        jp20.add(descripcionE);
        jp18.add(jp20);
        
        jp21 = new JPanel();
        anteriorE = new JButton("Anterior");
        editarE = new JButton("Editar");
        guardarE = new JButton("Guardar");
        siguienteE = new JButton("Siguiente");
        jp21.add(anteriorE);
        jp21.add(editarE);
        jp21.add(guardarE);
        jp21.add(siguienteE);
        jp18.add(jp21);
        
        jp22 = new JPanel();
        salirE = new JButton("Salir");
        jp22.add(salirE);
        jp18.add(jp22);
        
        //jp18.add(jp21);
        edicionTrabajo.add(jp18);
        rellenarFormularioEdicionTrabajador(1);
        edicionTrabajo.repaint();
        edicionTrabajo.setVisible(true);
        
    }
        
    
    
    
    

//parte metodos para uso de ficheros
    public void crearFichero(File fichero){
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el fichero");
        }
    }
    
    public void abrirFlujoLectura(File fichero){
        try {
            flujoLectura = new FileReader(fichero);
        } catch (FileNotFoundException ex) {
            System.out.println("Fallo de apertura de buffer de lectura");
        }
    }
    
    public void cerrarFlujoLectura(File fichero){
        try {
            flujoLectura.close();
        } catch (IOException ex) {
            System.out.println("Fallo en el cierre de buffer de lectura");
        }
    }
    
    public void abrirFlujoEscritura(File fichero){
        try {
            flujoEscritura = new FileWriter(fichero,true);
        } catch (IOException ex) {
            System.out.println("Fallo de apertura de buffer de escritura");
        }
    }
    
    public void cerrarFlujoEscritura(File fichero){
        try {
            flujoEscritura.close();
        } catch (IOException ex) {
            System.out.println("Fallo en el cierre de buffer de escritura");
        }
    }
    
    public void pasarDatosEntreFicheros(File archivoOrigen, File archivoDestino){
        
        abrirFlujoLectura(archivoOrigen);
        abrirFlujoEscritura(archivoDestino);
        
        try{
        
        bufferEscritura = new BufferedWriter(flujoEscritura);
        bufferLectura = new BufferedReader(flujoLectura);
        linea = bufferLectura.readLine();
        
        while (linea != null ){
            bufferEscritura.write(linea);
            bufferEscritura.newLine();
            linea = bufferLectura.readLine();
        }
        
        bufferLectura.close();
        bufferEscritura.close();
     }catch(Exception e){
          	System.out.println("Fallo en el traspaso de informacion");
      }
        
        cerrarFlujoLectura(archivoOrigen);
        cerrarFlujoEscritura(archivoDestino);
        
        
    }
    
    public void guardarDatos(File fichero){
        abrirFlujoEscritura(fichero);
        ////
        
        cerrarFlujoEscritura(fichero);
    }
    
//parte de metodos auxiliares  
    public int numerarRegistro(File archivo){
        abrirFlujoLectura(archivo);
        try{
        
            bufferLectura = new BufferedReader(flujoLectura);
            linea = bufferLectura.readLine();
            contadorLineas = 0;
            
            while (linea != null ){
                contadorLineas++;
                linea = bufferLectura.readLine();
            }
            System.out.println("lines: "+contadorLineas);
            bufferLectura.close();
            
        }catch(Exception e){
            System.out.println("Fallo en la captura de numero de registros");
        }
        cerrarFlujoLectura(archivo);
        return contadorLineas;
    }
    
    public Vector obtenerTrabajos(File archivo, String diferenciador){
        abrirFlujoLectura(archivo);
        try{
        
            bufferLectura = new BufferedReader(flujoLectura);
            linea = bufferLectura.readLine();
            vectorTipoTrabajos = new Vector();
            String [] aux;

            while (linea != null ){

                if (!linea.matches(diferenciador)){
                    aux=linea.split(",");
                    vectorTipoTrabajos.addElement(aux[0]);
                }   
                linea = bufferLectura.readLine();
            }
            
            bufferLectura.close();
        }catch(Exception e){
            System.out.println("Fallo en la captura de tipos de trabajo");
        }
        cerrarFlujoLectura(archivo);
        return vectorTipoTrabajos;
    }
  
    public void rellenarFormularioEdicion(int registro){
        
        
        abrirFlujoLectura(archivoTemporalEmpleados);
        
        try{
            
            bufferLectura = new BufferedReader(flujoLectura);
            linea = bufferLectura.readLine();
            int i=1;
            
            while (linea != null ){

                if (registro==i){
                    res = linea;
                }  
                linea = bufferLectura.readLine();
                i++;
            }
            
            System.out.println(res);
            bufferLectura.close();
        }catch(Exception e){
            System.out.println("Fallo en la captura de tipos de trabajo");
        }
        cerrarFlujoLectura(archivoTemporalEmpleados);
        convertirLineaEnObjeto(res);
        
    }
    
    public void convertirLineaEnObjeto(String linea){
        
        campos = linea.split(",");
        Trabajador empleado = new Trabajador(
                campos[0],
                campos[1],
                campos[2],
                campos[3],
                campos[4],
                campos[5],
                campos[6],
                campos[7],
                campos[8]);
        System.out.println(empleado.toString());
        rellenaFormularioConObjeto(empleado);
    }
    
    public void rellenarFormularioEdicionTrabajador(int registroT){
        
        
        abrirFlujoLectura(archivoTemporalTrabajos);
        
        try{
            
            bufferLectura = new BufferedReader(flujoLectura);
            linea = bufferLectura.readLine();
            int i=1;
            String[] aux; 
            while (linea != null ){

                if (registroT==i){
                    aux = linea.split(",");
                    trabajoE.setText(aux[0]);
                    System.out.println(aux[0]+","+aux[1]);
                    descripcionE.setText(aux[1]);
                }  
                linea = bufferLectura.readLine();
                i++;
            }
            
            bufferLectura.close();
        }catch(Exception e){
            System.out.println("Fallo en la captura de tipos de trabajo");
        }
        cerrarFlujoLectura(archivoTemporalEmpleados);
        
    }
    
    public void mostrarMensaje(String mens){
        
        mensaje = new JFrame("Mensaje del programa");
        mensaje.setSize(450,100);
        mensaje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mensaje.setLocationRelativeTo(null);
        mensaje.setResizable(false);
        jp15 = new JPanel();
        JLabel texto = new JLabel(mens);
        jp15.add(texto);
        mensaje.add(jp15);
        mensaje.setVisible(true);
        
    }
    
    //parte de eventos
    public void rellenaFormularioConObjeto(Trabajador empleado){
        if (campos[0].equals("Profesor")){
            interino.setVisible(true);
            if (campos[1].equals("No es interino")){
                interino.setSelected(false);
                interino.setText("No es interino");
                System.out.println("No es interino");
            }
            if (campos[1].equals("Si es interino")){
                interino.setSelected(true);
                interino.setText("Si es interino");
                System.out.println("Es interino");
            }
            
        } else {
            interino.setVisible(false);
        }
        comboTrabajos.setSelectedItem(campos[0]);
        nombre.setText(campos[2]);
        apellido1.setText(campos[3]);
        apellido2.setText(campos[4]);
        nif.setText(campos[5]);
        email.setText(campos[6]);
        telefono.setText(campos[7]);
        fechaAlta.setText(campos[8]);


        System.out.println(campos[0]);
        System.out.println(empleado.toString());
        
        
    }
    
    public class EventoPulsarSiguiente implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (registro > 1 & registro < numerarRegistro(archivoTemporalEmpleados)){
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            } 
            if (registro <= 1) {
                anterior.setEnabled(false);
            } 
            if (registro >= (numerarRegistro(archivoTemporalEmpleados)-1)){
                siguiente.setEnabled(false);
            }
            
            registro++;
                
            if (registro > 1 & registro < numerarRegistro(archivoTemporalEmpleados)){
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            } 
            if (registro <= 1) {
                anterior.setEnabled(false);
            } 
            if (registro >= numerarRegistro(archivoTemporalEmpleados)){
                siguiente.setEnabled(false);
            }
            
            numRegistroTexto.setText("Registro numero "+registro+ " de "+numerarRegistro(archivoTemporalEmpleados));
            //comboTrabajos.set
            formulario2.repaint();
            rellenarFormularioEdicion(registro);
            System.out.println("pulsado siguiente "+registro);
        }
            
    }
    
    public class EventoPulsarAnterior implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (registro > 1 & registro < numerarRegistro(archivoTemporalEmpleados)){
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            } 
            if (registro <= 1) {
                anterior.setEnabled(false);
            } 
            if (registro >= (numerarRegistro(archivoTemporalEmpleados)-1)){
                siguiente.setEnabled(false);
            }
            
            registro--;
            
            if (registro > 1 & registro < numerarRegistro(archivoTemporalEmpleados)){
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            } 
            if (registro <= 1) {
                anterior.setEnabled(false);
            } 
            if (registro >= numerarRegistro(archivoTemporalEmpleados)){
                siguiente.setEnabled(false);
            }
            numRegistroTexto.setText("Registro numero "+registro+ " de "+numerarRegistro(archivoTemporalEmpleados));
            formulario2.repaint();
            rellenarFormularioEdicion(registro);
            System.out.println("pulsado anterior "+ registro);
        }
    }
    
     public class EventoCambiaBotonInterino implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado toggle");
            if(interino.isSelected()){
                interino.setText("Si es interino");
            }else {
                interino.setText("No es interino");
            }
            
        }
    }
    
    public class EventoGuardarEmpleado implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado guardar "+titulo);
            String interino;
            if (titulo.equals("Alta Profesor")){
                interino = Acciones.this.interino.getText();
            } else {
                interino = "";
            }
            //if (titulo.equals("Alta Profesor")){
                Trabajador empleado = new Trabajador(
                    (String)Acciones.this.comboTrabajos.getSelectedItem(),
                    //Acciones.this.interino.getText(),
                    interino,
                    Acciones.this.nombre.getText(),
                    Acciones.this.apellido1.getText(),
                    Acciones.this.apellido2.getText(),
                    Acciones.this.nif.getText(),
                    Acciones.this.email.getText(),
                    Acciones.this.telefono.getText(),
                    Acciones.this.fechaAlta.getText());

                System.out.println(empleado.toString());
           // }
            
        }
    }
}
