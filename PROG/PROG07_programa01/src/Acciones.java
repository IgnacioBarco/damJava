
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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Nacho
 */

public class Acciones {
 
    //declaramos las variables   
    //formulario
    String tipoFormulario, titulo;
    JPanel formulario, altaTrabajo,edicionTrabajo; 
    JButton eliminar;
    JPanel jp1, jp2, jp3,jp31,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11,jp12,jp13,jp14,jp15,
            jp17,jp18,jp19,jp20,jp21,jp22,jp23,jp24,jp25,jp26; 
    JPanel botonesFormulario,botonesFormularioEdicion1,botonesFormularioEdicion2;
    JLabel  jlTrabajo,jlNombre, jlApellidos, jlSexo, jlEdad, jlNif, jlEmail, jlTelefono,jlFechaAlta,
            jlTrabajo2,jlRegistroE;           
    JTextField nombre, apellidos, sexo,edad,nif, email, telefono,fechaAlta,trabajo,
            descripcionE, trabajoE;
    JComboBox comboTrabajos;
    DefaultComboBoxModel modeloComboTrabajos;
    JToggleButton interino;
    String [] campos ;
    Vector vectorTipoTrabajos;
    JButton guardar, salir, editar, borrar, siguiente, anterior, guardarTrabajo,
            anteriorE,editarE,guardarE,siguienteE,salirE;
    JLabel numRegistroTexto;
    boolean validarTrabajador;
    
    //tabla
    File fichero;
    JTable tabla;
    DefaultTableModel datos;
    JFrame ventanaTablaTrabajos; 
    JDialog mensaje;
    JPanel tablaEmpleados;
    JScrollPane scrollTabla;
    String[] titulos = {"Tipo de trabajador","Interino","Nombre","Apellidos","Sexo",
                        "Edad","NIF","email","Telefono","Fecha de ingreso"} ;
    JList listaTrabajos;
    DefaultListModel modeloListaTrabajos;
    JPanel jpLista;
    
    
    //ficheros
    FileReader flujoLectura;
    FileWriter flujoEscritura;
    BufferedReader bufferLectura;
    BufferedWriter bufferEscritura;
    String linea;      
    int contadorLineas; 
    int registro=1,i;
    File archivoGuardadoEmpleados, archivoTemporalEmpleados;
    File archivoGuardadoTrabajos, archivoTemporalTrabajos;
    File archivoTemporalEmpleados2,archivoTemporalTrabajos2;
    String res, valida;
    
    
    
    //en el constructor creamos los ficheros que vamos a utilizar        
    public Acciones(){
        
        archivoGuardadoEmpleados = new File("empleados.dat");
        archivoTemporalEmpleados = new File("emp.temp");
        archivoTemporalEmpleados2 = new File("emp2.temp");
        archivoGuardadoTrabajos = new File("trabajos.dat");
        archivoTemporalTrabajos = new File("trab.temp");   
        archivoTemporalTrabajos2 = new File("trab2.temp");
    }
    
    
    //Parte grafica de los empleados 
    //aqui vamos a crear el menu de alta y edicion de los empleados
    public JPanel crearFormulario(String tipoFormulario){
        
        titulo = tipoFormulario;
        
        formulario = new JPanel();
        formulario.setLayout(new BoxLayout(formulario,BoxLayout.Y_AXIS));
        
        //si le pasamos que es edicion, le añadimos los botones de anterior y siguiente
        if(titulo.equals("Edición Trabajador")){
            registro=1;
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
            if (numerarRegistro(archivoTemporalEmpleados)==1 & registro==1){
                siguiente.setEnabled(false);
                anterior.setEnabled(false);
            }
            
        }
        
        jp12 = new JPanel();
        jlTrabajo = new JLabel("Tipo de trabajador: ");
        jp12.add(jlTrabajo);
        //aqui recuperamos de el archivo temporal todos los posibles trabajadores
        //y los metemos en un combobox
        modeloComboTrabajos = new DefaultComboBoxModel(obtenerTrabajos(archivoTemporalTrabajos, ""));
        comboTrabajos = new JComboBox(modeloComboTrabajos);
        EventoCheckearCombo cambiarCheckTrabajos = new EventoCheckearCombo();
        comboTrabajos.addActionListener(cambiarCheckTrabajos);
        jp12.add(comboTrabajos);
        
        //aqui si el trabajador es un profesor, hacemos que aparezca un boton 
        //para saber si es interino o no
        //en el caso de que sea otro tipo de trabajador no aparece ese boton
        interino = new JToggleButton("Si es interino", true);
        EventoCambiaBotonInterino pulsarInterino = new EventoCambiaBotonInterino();
        interino.addActionListener(pulsarInterino);
        if(comboTrabajos.getSelectedItem().equals("Profesor")){
                interino.setVisible(true);
            } else {
                interino.setVisible(false);
            }
        jp12.add(interino);
        
           
        formulario.add(jp12);        
        
        jp1 = new JPanel();
        jlNombre = new JLabel("Nombre: ");
        nombre = new JTextField(33);
        jp1.add(jlNombre);
        jp1.add(nombre);
        formulario.add(jp1);
        
        jp2 = new JPanel();
        jlApellidos = new JLabel("Apellidos: "); 
        apellidos = new JTextField(32);
        jp2.add(jlApellidos);
        jp2.add(apellidos);
        formulario.add(jp2);
        
        jp3 = new JPanel();
        jlSexo = new JLabel("Sexo: "); 
        sexo = new JTextField(34);
        jp3.add(jlSexo);
        jp3.add(sexo);
        formulario.add(jp3);
        
        jp31 = new JPanel();
        jlEdad = new JLabel("Edad: "); 
        edad = new JTextField(34);
        jp31.add(jlEdad);
        jp31.add(edad);
        formulario.add(jp31);
        
        jp4 = new JPanel();
        jlNif = new JLabel("Nif: ");
        nif = new JTextField(35);
        jp4.add(jlNif);
        jp4.add(nif);
        formulario.add(jp4);
        
        jp5 = new JPanel();
        jlEmail = new JLabel("Email:  ");
        email = new JTextField(33);
        jp5.add(jlEmail);
        jp5.add(email);
        formulario.add(jp5);
        
        jp6 = new JPanel();
        jlTelefono = new JLabel("Telefono: ");
        telefono = new JTextField(32);
        jp6.add(jlTelefono);
        jp6.add(telefono);
        formulario.add(jp6);
        
        jp7 = new JPanel();
        jlFechaAlta = new JLabel("Fecha Alta: ");
        fechaAlta = new JTextField(31);
        jp7.add(jlFechaAlta);
        jp7.add(fechaAlta);
        formulario.add(jp7);
        
        
        botonesFormulario = new JPanel();
        //si es edicion, le añadimos los botones modificar y borrar
        if(titulo.equals("Edición Trabajador")){
            editar = new JButton("Editar");
            EventoEditarEmpleado pulsarEditarEmpleado = new EventoEditarEmpleado();
            editar.addActionListener(pulsarEditarEmpleado);
            botonesFormulario.add(editar);
            
            borrar = new JButton("Borrar");
            EventoBorrarEmpleado pulsarBorrarEmpleado = new EventoBorrarEmpleado();
            borrar.addActionListener(pulsarBorrarEmpleado);
            botonesFormulario.add(borrar);
        }
        
        guardar = new JButton("Guardar");
        EventoGuardarEmpleado guardarEmpleado = new EventoGuardarEmpleado();
        guardar.addActionListener(guardarEmpleado);
        botonesFormulario.add(guardar);
        
        formulario.add(botonesFormulario);
        
        //si es edicion, deshabilitamos el boton de guardar(hasta quie le demos a editar)
        if(titulo.equals("Edición Trabajador")){
            guardar.setEnabled(false);
        }
        
        return formulario;
}
    //donde creamos la tabla de los empleados
    public JScrollPane crearTablaEmpleados(){
        
        scrollTabla = new JScrollPane();
        datos = new DefaultTableModel();         
        datos.setColumnIdentifiers(titulos);
        tabla = new JTable(datos);
        
        scrollTabla.setViewportView(tabla);
        scrollTabla.createHorizontalScrollBar();
        scrollTabla.createVerticalScrollBar();

        bufferLectura = null;
    
        //leemos el fichero, linea a linea hasta que no haya nada
        //separamos los campos con las comas y los añadimos a la tabla
        try {
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
                System.out.println("fallo al abrir el fichero");
            }
      
      //deshabilitamos la tabla para que no se pueda modificar
      tabla.setEnabled(false);
      
      return scrollTabla;
      
         
    }
    
  
//Parte grafica de los trabajos
    //creamos el formulario para dar de alta nuevos tipos de trabajos
    public JPanel crearFormularioTrabajos(){
        
        altaTrabajo = new JPanel();
        jp13 = new JPanel();
        jp14 = new JPanel();
        jlTrabajo2 = new JLabel("Trabajo a añadir: ");
        trabajo = new JTextField(30);
        jp14.add(jlTrabajo2);
        jp14.add(trabajo);
        jp13.add(jp14);
        
        altaTrabajo.add(jp13);
        guardarTrabajo = new JButton("Guardar");
        EventoGuardarTrabajo pulsarGuardarTrabajo = new EventoGuardarTrabajo();
        guardarTrabajo.addActionListener(pulsarGuardarTrabajo);
        jp13.add(guardarTrabajo);
        altaTrabajo.setVisible(true);
        
        return altaTrabajo;
    }
    
    //creamos el formulario para borrar los tipos de trabajo
    public JPanel crearFormularioEdicionTrabajos(){
        
        edicionTrabajo = new JPanel();
        edicionTrabajo.setLayout(new BoxLayout(edicionTrabajo,BoxLayout.Y_AXIS));
        
        jp24 = new JPanel();
        jp24.add(crearTablaTrabajos());
        edicionTrabajo.add(jp24);
        
        jp26 = new JPanel();
        eliminar = new JButton("Eliminar");
        EventoBorrarTrabajo pulsarBorrarTrabajo = new EventoBorrarTrabajo();
        eliminar.addActionListener(pulsarBorrarTrabajo);
        jp26.add(eliminar);
        edicionTrabajo.add(jp26);
        
        
        return edicionTrabajo;
    }
    
    //para crear la jlist de los tipos de trabajo
    public JList crearTablaTrabajos(){
        
        listaTrabajos = new JList();
        modeloListaTrabajos = new DefaultListModel();
        listaTrabajos.setModel(modeloListaTrabajos);
        modeloListaTrabajos.removeAllElements();
        bufferLectura = null;
        
        //leemos el fichero linea a linea hasta que este vacio
        //y lo añadimos a la lista
        try{
            bufferLectura = new BufferedReader(new FileReader(archivoTemporalTrabajos));
            linea = bufferLectura.readLine();

            while (linea != null ){
                modeloListaTrabajos.addElement(linea);
                System.out.println(linea);
                linea = bufferLectura.readLine();
            }
            bufferLectura.close();

        }
        catch(Exception e)
            {
                System.out.println("fallo al abrir fichero");
            }

    return listaTrabajos;
    }

    
//parte metodos para uso de ficheros
    //crea un fichero
    public void crearFichero(File fichero){
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el fichero");
        }
    }
    
    //abre flujo de lectura de un fichero
    public void abrirFlujoLectura(File fichero){
        try {
            flujoLectura = new FileReader(fichero);
        } catch (FileNotFoundException ex) {
            System.out.println("Fallo de apertura de buffer de lectura");
        }
    }
    
    //cierra el flujo de lectura de un fichero
    public void cerrarFlujoLectura(File fichero){
        try {
            flujoLectura.close();
        } catch (IOException ex) {
            System.out.println("Fallo en el cierre de buffer de lectura");
        }
    }
    
    //abre flujo de escritura de un fichero
    public void abrirFlujoEscritura(File fichero){
        try {
            flujoEscritura = new FileWriter(fichero,true);
        } catch (IOException ex) {
            System.out.println("Fallo de apertura de buffer de escritura");
        }
    }
    
    //cierra el flujo de escritura de un fichero
    public void cerrarFlujoEscritura(File fichero){
        try {
            flujoEscritura.close();
        } catch (IOException ex) {
            System.out.println("Fallo en el cierre de buffer de escritura");
        }
    }
    
    //pasa los datos de un fichero a otro
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
    
    //guarda los datos temporales a los .dat
    public void guardarDatos(){
        pasarDatosEntreFicheros(archivoTemporalEmpleados, archivoGuardadoEmpleados);
        pasarDatosEntreFicheros(archivoTemporalTrabajos, archivoGuardadoTrabajos);
    }
    
    //crea los tipo de trabajo por defecto y los guarda en el fichero temporal
    public void crearFicheroTrabajosInicial(){
        crearFichero(archivoTemporalTrabajos);
        abrirFlujoEscritura(archivoTemporalTrabajos);
        try{
        
        bufferEscritura = new BufferedWriter(flujoEscritura);
        
        bufferEscritura.write("Equipo Directivo");
        bufferEscritura.newLine();
        bufferEscritura.write("Profesor");
        bufferEscritura.newLine();
        bufferEscritura.write("Tutor");
        bufferEscritura.newLine();
        bufferEscritura.write("Administrativo");
        
        bufferEscritura.close();
     }catch(Exception e){
          	System.out.println("Fallo en el traspaso de informacion");
      }
        cerrarFlujoEscritura(archivoTemporalTrabajos);
    }
    
    
    
//parte de metodos auxiliares  
    //nos dice cuantas lineas tiene el fichero
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
            System.out.println("lineas: "+contadorLineas);
            bufferLectura.close();
            
        }catch(Exception e){
            System.out.println("Fallo en la captura de numero de registros");
        }
        cerrarFlujoLectura(archivo);
        return contadorLineas;
    }
    
    //nos devuelve un vector con los tipos de trabajo
    //si el diferenciador coincide con alguna de las lineas no la incluye en el vector
    public Vector obtenerTrabajos(File archivo, String diferenciador){
        abrirFlujoLectura(archivo);
        try{
        
            bufferLectura = new BufferedReader(flujoLectura);
            linea = bufferLectura.readLine();
            vectorTipoTrabajos = new Vector();
            
            while (linea != null ){

                if (!linea.matches(diferenciador)){
                    vectorTipoTrabajos.addElement(linea);
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
  
    //rellena el formulario  de edicion de trabajador con el numero de registro(linea)
    //que le indiquemos
    public void rellenarFormularioEdicion(int registro){
        
        abrirFlujoLectura(archivoTemporalEmpleados);
        int i=1;
        try{
            
            bufferLectura = new BufferedReader(flujoLectura);
            linea = bufferLectura.readLine();
            i=1;
            
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
        if (i!=1){
            convertirLineaEnObjeto(res);
        } else {
            System.out.println("fichero vacio");
        }

        
    }
    
    //crea un objeto trabajador y llama a rellenar el formulario con el
    public void convertirLineaEnObjeto(String linea){
        
        campos=null;
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
                campos[8],
                campos[9]);
        System.out.println(empleado.toString());
        rellenaFormularioConObjeto(empleado);
    }
    
    //rellena el formulario con esos datos
    public void rellenaFormularioConObjeto(Trabajador empleado){
        //si es un Profesor, aqui rellenamos si es interino o no
        if (campos[0].equals("Profesor")){
            if (campos[1].equals("No es interino")){
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
        apellidos.setText(campos[3]);
        sexo.setText(campos[4]);
        edad.setText(campos[5]);
        nif.setText(campos[6]);
        email.setText(campos[7]);
        telefono.setText(campos[8]);
        fechaAlta.setText(campos[9]);

        System.out.println(empleado.toString());
    }
    
    //validamos los campos de trabajador
    //solo le hemos puesto para que no esten vacios
    //aqui habria que ponerle todas las validaciones que quisiesemos
    public boolean validarcamposTrabajador(){
        validarTrabajador=true;
        if (nombre.getText().equals("")){
            validarTrabajador=false;
            System.out.println("nombre vacio");
            mostrarMensaje(formulario, "Nombre vacio, no se puede guardar el usuario");
        }
        if (apellidos.getText().equals("")){
            validarTrabajador=false;
            System.out.println("apellidos vacios");
            mostrarMensaje(formulario, "Apellidos vacios, no se puede guardar el usuario");
        }
        if (sexo.getText().equals("")){
            validarTrabajador=false;
            System.out.println("sexo vacio");
            mostrarMensaje(formulario, "Sexo vacio, no se puede guardar el usuario");
        }
        if (edad.getText().equals("")){
            validarTrabajador=false;
            System.out.println("edad vacio");
            mostrarMensaje(formulario, "Edad vacia, no se puede guardar el usuario");
        }
        if (nif.getText().equals("")){
            validarTrabajador=false;
            System.out.println("nif vacio");
            mostrarMensaje(formulario, "Nif vacio, no se puede guardar el usuario");
        }
        if (email.getText().equals("")){
            validarTrabajador=false;
            System.out.println("email vacio");
            mostrarMensaje(formulario, "Email vacio, no se puede guardar el usuario");
        }
        if (telefono.getText().equals("")){
            validarTrabajador=false;
            System.out.println("telefono vacio");
            mostrarMensaje(formulario, "Telefono vacio, no se puede guardar el usuario");
        }
        if (fechaAlta.getText().equals("")){
            validarTrabajador=false;
            System.out.println("fechaAlta vacio");
            mostrarMensaje(formulario, "Fecha de Alta vacia, no se puede guardar el usuario");
        }
          
        return validarTrabajador;
    }
    
    //para habilitar o deshabilirtar los campos en el menu edicion
    public void habilitarMenuEdicionTrabajador(boolean activar){
        comboTrabajos.setEnabled(activar);
        nombre.setEnabled(activar);
        apellidos.setEnabled(activar);
        sexo.setEnabled(activar);
        nif.setEnabled(activar);
        email.setEnabled(activar);
        telefono.setEnabled(activar);
        fechaAlta.setEnabled(activar);
        edad.setEnabled(activar);
        interino.setEnabled(activar);
    }
    
    //limpiamos los campos de edicion
    public void limpiarMenuEdicionTrabajador(){
        nombre.setText("");
        apellidos.setText("");
        sexo.setText("");
        nif.setText("");
        email.setText("");
        telefono.setText("");
        fechaAlta.setText("");
        edad.setText("");
       
    }
    
    
//parte de eventos de los botones
    //pulsar siguiente en menu edicion
    public class EventoPulsarSiguiente implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //habilitamos o deshabilitamos el boton segun sea el registro en el 
            //que estemos y tambien dependiendo del numero de registros maximo
            if (registro != 1 & registro < numerarRegistro(archivoTemporalEmpleados)){
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            } 
            if (registro == 1) {
                anterior.setEnabled(false);
                siguiente.setEnabled(true);
            } 
            if (registro == numerarRegistro(archivoTemporalEmpleados)){
                siguiente.setEnabled(false);
                anterior.setEnabled(true);
            }
            
            //para habilitar el boton despues de pulsarlo, calculando en nuevo registro
            registro++;
                
            if (registro < numerarRegistro(archivoTemporalEmpleados)){
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            } 
             
            if (registro == numerarRegistro(archivoTemporalEmpleados)){
                siguiente.setEnabled(false);
                anterior.setEnabled(true);
            }
            
            numRegistroTexto.setText("Registro numero "+registro+ " de "+numerarRegistro(archivoTemporalEmpleados));
            formulario.repaint();
            rellenarFormularioEdicion(registro);
            System.out.println("pulsado siguiente "+registro);
            habilitarMenuEdicionTrabajador(false);
            guardar.setEnabled(false);
        }
            
    }
    
    //pulsar anterior en el menu edicion
    public class EventoPulsarAnterior implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //habilitamos o deshabilitamos el boton segun sea el registro en el 
            //que estemos y tambien dependiendo del numero de registros maximo
            if (registro != 1 & registro < numerarRegistro(archivoTemporalEmpleados)){
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            } 
            if (registro == 1) {
                anterior.setEnabled(false);
                siguiente.setEnabled(true);
            } 
            if (registro == numerarRegistro(archivoTemporalEmpleados)){
                siguiente.setEnabled(false);
                anterior.setEnabled(true);
            }
            
            //para habilitar el boton despues de pulsarlo, calculando en nuevo registro
            registro--;
            
            if (registro == 1){
                anterior.setEnabled(false);
                siguiente.setEnabled(true);
            } 
             
            if (registro != 1){
                siguiente.setEnabled(true);
                anterior.setEnabled(true);
            }
            
            numRegistroTexto.setText("Registro numero "+registro+ " de "+numerarRegistro(archivoTemporalEmpleados));
            formulario.repaint();
            rellenarFormularioEdicion(registro);
            System.out.println("pulsado anterior "+ registro);
            habilitarMenuEdicionTrabajador(false);
            guardar.setEnabled(false);
        }
    }
    
    //para que al pulsar el boton de interino, nos cambie el texto
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
     
    //pulsar editar en edicion de empleado
    public class EventoEditarEmpleado implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //habilitamos todos los campos y el boton de guardar
            habilitarMenuEdicionTrabajador(true);
            guardar.setEnabled(true);
        }   
    }    
    
    //borra el empleado
    //cramos otro archivo temporal, y mediante el numero de registro, cuando
    //es ese numero, no se lo pasamos al archivo nuevo.
    //despues borramos el temporal y pasamos los datos al nuevo temporal
    public class EventoBorrarEmpleado implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            System.out.println("Estamos en el registro "+ registro);

            try {
                archivoTemporalEmpleados2.createNewFile();
            } catch (IOException ex) {
                System.out.println("fallo al crear el archivo");
            }

            abrirFlujoLectura(archivoTemporalEmpleados);
            abrirFlujoEscritura(archivoTemporalEmpleados2);

            try{

            bufferEscritura = new BufferedWriter(flujoEscritura);
            bufferLectura = new BufferedReader(flujoLectura);
            linea = bufferLectura.readLine();
            i=1;

            while (linea != null ){
                if (i!=registro){
                bufferEscritura.write(linea);
                bufferEscritura.newLine();
                }
                linea = bufferLectura.readLine();
                i++;
            }

            bufferLectura.close();
            bufferEscritura.close();
             }catch(Exception ex){
                        System.out.println("Fallo en el traspaso de informacion");
              }

            cerrarFlujoLectura(archivoTemporalEmpleados);
            cerrarFlujoEscritura(archivoTemporalEmpleados2);

            archivoTemporalEmpleados.delete();
            pasarDatosEntreFicheros(archivoTemporalEmpleados2, archivoTemporalEmpleados);
            archivoTemporalEmpleados2.delete();
            
            mostrarMensaje(formulario, "El empleado ha sido borrado");
            
            //aqui volvemos a rellenar el formulario con el anterior registro al borrado
            rellenarFormularioEdicion(registro);
            if (registro!=1){
                registro=registro-1;
            } 
            if (registro==1){
                anterior.setEnabled(false);
            }    
            if (numerarRegistro(archivoTemporalEmpleados)==1){
                anterior.setEnabled(false);
                siguiente.setEnabled(false);
            }
            if (registro==numerarRegistro(archivoTemporalEmpleados)){
                siguiente.setEnabled(false);
            }
            
            numRegistroTexto.setText("Registro numero "+registro+ " de "+numerarRegistro(archivoTemporalEmpleados));
            habilitarMenuEdicionTrabajador(false);
            formulario.repaint();
        }
    }
    
    //guardar empleado, tanto en alta como en modificacion
    public class EventoGuardarEmpleado implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("pulsado guardar "+titulo);
            String interino;
            
            //para guardar en editar, primero borramos el registro del temporal
            if(titulo.equals("Edición Trabajador")){
                System.out.println("Estamos en el registro "+ registro);
                
                try {
                    archivoTemporalEmpleados2.createNewFile();
                } catch (IOException ex) {
                    System.out.println("fallo al crear el archivo");
                }
                
                abrirFlujoLectura(archivoTemporalEmpleados);
                abrirFlujoEscritura(archivoTemporalEmpleados2);
        
                try{

                bufferEscritura = new BufferedWriter(flujoEscritura);
                bufferLectura = new BufferedReader(flujoLectura);
                linea = bufferLectura.readLine();
                i=1;
                
                while (linea != null ){
                    if (i!=registro){
                    bufferEscritura.write(linea);
                    bufferEscritura.newLine();
                    }
                    linea = bufferLectura.readLine();
                    i++;
                }
        
                bufferLectura.close();
                bufferEscritura.close();
                 }catch(Exception ex){
                            System.out.println("Fallo en el traspaso de informacion");
                  }
        
                cerrarFlujoLectura(archivoTemporalEmpleados);
                cerrarFlujoEscritura(archivoTemporalEmpleados2);
                
                archivoTemporalEmpleados.delete();
                pasarDatosEntreFicheros(archivoTemporalEmpleados2, archivoTemporalEmpleados);
                archivoTemporalEmpleados2.delete();
         
            } 
            
            //para guardar el trabajador
            
            //si la validacion es verdadera guardara, si no no hara nada
            //los mensajes de error se los pasamos en la funcion de validarcamposTrabajador()
            if (validarcamposTrabajador()) {
            
            if ((Acciones.this.comboTrabajos.getSelectedItem()).equals("Profesor")){
                interino = Acciones.this.interino.getText();
            } else {
                interino = "";
            }

            Trabajador empleado = new Trabajador(
                (String)Acciones.this.comboTrabajos.getSelectedItem(),
                interino,
                nombre.getText(),
                apellidos.getText(),
                sexo.getText(),
                edad.getText(),
                nif.getText(),
                email.getText(),
                telefono.getText(),
                fechaAlta.getText()
            );

            System.out.println(empleado.toString());

            //si no existe el temporal de empleados, creamos uno nuevo con ese registro
            if (!archivoTemporalEmpleados.exists()){
                crearFichero(archivoTemporalEmpleados);
                abrirFlujoEscritura(archivoTemporalEmpleados);
                try{
                    bufferEscritura = new BufferedWriter(flujoEscritura);

                    bufferEscritura.write(empleado.toString());

                    bufferEscritura.close();
                }catch(Exception ex){
                    System.out.println("Fallo en la inserción de trabajador nuevo1");
                }
                cerrarFlujoEscritura(archivoTemporalEmpleados);    
             
            
            } else if (archivoTemporalEmpleados.exists()){
                //si el fichero existe pero esta vacio, añadimos el trabajador
                if (numerarRegistro(archivoTemporalEmpleados)==0){
                    abrirFlujoEscritura(archivoTemporalEmpleados);
                    try{
                        bufferEscritura = new BufferedWriter(flujoEscritura);

                        bufferEscritura.write(empleado.toString());

                        bufferEscritura.close();
                    }catch(Exception ex){
                        System.out.println("Fallo en la inserción de trabajador nuevo1.5");
                    }
                    cerrarFlujoEscritura(archivoTemporalEmpleados);
                     
                //si ya existe y hay datos, creamos un temporal nuevo al que pasaremos 
                //todos los datos mas el nuevo empleado, borrando luego el fichero auxiliar
                }else if(numerarRegistro(archivoTemporalEmpleados)>0){
                    crearFichero(archivoTemporalEmpleados2);
                    abrirFlujoLectura(archivoTemporalEmpleados);
                    abrirFlujoEscritura(archivoTemporalEmpleados2);

                    try{


                    bufferLectura = new BufferedReader(flujoLectura);
                    bufferEscritura = new BufferedWriter(flujoEscritura);

                    linea = bufferLectura.readLine();


                    while (linea != null ){

                        bufferEscritura.write(linea);
                        bufferEscritura.newLine();

                        linea = bufferLectura.readLine();
                    }

                    bufferEscritura.write(empleado.toString());

                    bufferLectura.close();
                    bufferEscritura.close();
                    }catch(Exception ex){
                        System.out.println("Fallo en la captura de tipos de trabajo");
                    }
                    cerrarFlujoLectura(archivoTemporalEmpleados);
                    cerrarFlujoEscritura(archivoTemporalEmpleados2);

                    archivoTemporalEmpleados.delete();

                    pasarDatosEntreFicheros(archivoTemporalEmpleados2, archivoTemporalEmpleados);

                    archivoTemporalEmpleados2.delete();
         
                }    
            }

            //segun sea edicion o alta, mostramos un mensaje
            if(titulo.equals("Edición Trabajador")){
                mostrarMensaje(formulario, "Usuario editado");
            } else {
            mostrarMensaje(formulario,"Usuario guardado");
            }
            limpiarMenuEdicionTrabajador();
            if(titulo.equals("Edición Trabajador")){
                rellenarFormularioEdicion(registro);
            }
        }
        }
            
    }
    
    //al cambiar el combobox de tipo de trabajos, si es Profesor
    //que nos muestre el boton de interino
    public class EventoCheckearCombo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(comboTrabajos.getSelectedItem().equals("Profesor")){
                interino.setVisible(true);
            } else {
                interino.setVisible(false);
            }
                formulario.repaint();
        }
    }    
    
    //guarda el trabajo nuevo
    public class EventoGuardarTrabajo implements ActionListener{
        public void actionPerformed(ActionEvent e){
        System.out.println("Pulsado guardar trabajo");
        //si esta vacio, nos muestra un error y no hace nada
        if (trabajo.getText().equals("")){
            System.out.println("trabajo vacio");
            mostrarMensaje(formulario, "Trabajo vacio, no se puede guardar el tipo de trabajo nuevo");
        } else {
            //si no existe el fichero creamos uno nuevo
            if (!archivoTemporalTrabajos.exists()){
                    crearFichero(archivoTemporalTrabajos);
            }

            crearFichero(archivoTemporalTrabajos2);

            abrirFlujoLectura(archivoTemporalTrabajos);
            abrirFlujoEscritura(archivoTemporalTrabajos2);

            try{


            bufferLectura = new BufferedReader(flujoLectura);
            bufferEscritura = new BufferedWriter(flujoEscritura);

            linea = bufferLectura.readLine();


            while (linea != null ){

                bufferEscritura.write(linea);
                bufferEscritura.newLine();

                linea = bufferLectura.readLine();
            }

            bufferEscritura.write(trabajo.getText());

            bufferLectura.close();
            bufferEscritura.close();
            }catch(Exception ex){
                System.out.println("Fallo en la captura de tipos de trabajo");
            }
            cerrarFlujoLectura(archivoTemporalEmpleados);
            cerrarFlujoEscritura(archivoTemporalTrabajos);

            archivoTemporalTrabajos.delete();

            pasarDatosEntreFicheros(archivoTemporalTrabajos2, archivoTemporalTrabajos);

            archivoTemporalTrabajos2.delete();

            mostrarMensaje(formulario, "Trabajo guardado");
            }
        }
    }    

    //borra el trabajo de la lista
    public class EventoBorrarTrabajo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //si no hay ningun trabajo seleccionado, nos muestra un error y no hace nada
            if (listaTrabajos.getSelectedIndex()==-1){
                mostrarMensaje(edicionTrabajo,"No hay nada seleccionado");
            } else {
                //pasamos todos los trabajos menos el que coincida con el seleccionado
                try {
                    archivoTemporalTrabajos2.createNewFile();
                } catch (IOException ex) {
                    System.out.println("fallo al crear el archivo");
                }

                abrirFlujoLectura(archivoTemporalTrabajos);
                abrirFlujoEscritura(archivoTemporalTrabajos2);

                try{

                bufferEscritura = new BufferedWriter(flujoEscritura);
                bufferLectura = new BufferedReader(flujoLectura);
                linea = bufferLectura.readLine();

                valida=(String)modeloListaTrabajos.get(listaTrabajos.getSelectedIndex());
                System.out.println("valida "+valida);

                while (linea != null ){
                    if (!valida.equals(linea)){
                    bufferEscritura.write(linea);
                    bufferEscritura.newLine();
                    }
                    linea = bufferLectura.readLine();

                }

                bufferLectura.close();
                bufferEscritura.close();
                 }catch(Exception ex){
                            System.out.println("Fallo en el traspaso de informacion");
                  }

                cerrarFlujoLectura(archivoTemporalTrabajos);
                cerrarFlujoEscritura(archivoTemporalTrabajos2);

                archivoTemporalTrabajos.delete();
                pasarDatosEntreFicheros(archivoTemporalTrabajos2, archivoTemporalTrabajos);
                archivoTemporalTrabajos2.delete();

                mostrarMensaje(formulario, "El trabajo ha sido borrado");

                jp24.removeAll();
                jp26.removeAll();
                edicionTrabajo.repaint();
            }        
        }
    }

    //nos muestra un mensaje interno del programa
    public void mostrarMensaje(JPanel frame,String mens){
        JOptionPane.showMessageDialog(frame, mens, "Información del sistema", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}


