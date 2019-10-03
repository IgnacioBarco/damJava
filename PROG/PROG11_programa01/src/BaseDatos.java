
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Nacho
 */
public class BaseDatos {
        
    /**
     * "jdbc:mysql://localhost/notarbd?useSSL=false"
     * Direccion de la base de datos. Le ponemos el useSSL en false
     * para que no nos de un warning de conexion no segura
     */
    String dirDB = "jdbc:mysql://localhost/notarbd?useSSL=false";
    
    /**
     * Usuario de la base de datos
     */
    String usuario = "root";
    
    /**
     * Password del usuario de la base de datos
     */
    String pass = "pdccalculo";
    
    
    //definimos variables
    Connection conexion= null;
    String tablaClientes, tablaEscrituras, tablaEscCli;
    String insertCliente, insertEscritura, insertEscCli;
    String consultaCliente, consultaEscrituras, consultaEscCli, consultaCPVE;
    Statement sentencia;
    ResultSet rsCliente, rsEscrituras, rsEscCli, rsEscriturasCPVE;
    String opcion, actualizar;
    JOptionPane panelOpciones;
    int cont=0;
    
    /**
     * para crear el objeto
     */
    public BaseDatos(){
            
    }
    
    /**
     * Abre la conexion con la base de datos
     * y crea un Statement para enviar sentencias a la bd
     */
    public void abrirConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection (dirDB,usuario,pass);
            sentencia = conexion.createStatement();
        }catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Fallo al intentar conectar la base de datos. "+ex);
        }
    }
    
    /**
     * cierra las conexiones abiertas
     */
    public void cerrarConexion(){
        
        try {
            rsCliente.close();
        } catch (java.lang.NullPointerException | SQLException ex) {
            System.out.println("Fallo al intentar desconectar rsCliente. "+ex);
        }
        try {
            rsEscrituras.close();
        } catch (java.lang.NullPointerException | SQLException ex) {
            System.out.println("Fallo al intentar desconectar rsEscrituras. "+ex);
        }
        try {
            rsEscCli.close();
        } catch (java.lang.NullPointerException | SQLException ex) {
            System.out.println("Fallo al intentar desconectar rsEscCli. "+ex);
        }
        try {
            rsEscriturasCPVE.close();
        } catch (java.lang.NullPointerException | SQLException ex) {
            System.out.println("Fallo al intentar desconectar rsEscriturasCPVE. "+ex);
        }
        try {
            sentencia.close();
        } catch (java.lang.NullPointerException | SQLException ex) {
            System.out.println("Fallo al intentar desconectar la sentencia. "+ex);
        }
        try {
            conexion.close();
        } catch (java.lang.NullPointerException | SQLException ex) {
            System.out.println("Fallo al intentar desconectar la conexion de la base de datos. "+ex);
        }
        
    }
    
    /**
     * crea las 3 tablas
     */
    public void crearTablas(){
        
        int contador=3;
        //definimos las tablas
        tablaClientes="CREATE TABLE CLIENTES("
                + "Cod_Cliente INT NOT NULL,"
                + "Nombre VARCHAR(45) NOT NULL,"
                + "Telefono VARCHAR(19) NOT NULL,"
                + "PRIMARY KEY(Cod_CLIENTE))";
        
        tablaEscrituras="CREATE TABLE TABLAESCRITURAS("
                + "Codigo VARCHAR(11) NOT NULL,"
                + "Tipo VARCHAR(19) NOT NULL,"
                + "NombreFichero VARCHAR(45) NOT NULL,"
                + "Num_Interv INT NOT NULL,"
                + "PRIMARY KEY(Codigo))";
        
        tablaEscCli="CREATE TABLE ESCCLI("
                + "CodCli INT NOT NULL,"
                + "CodEsc VARCHAR(11) NOT NULL,"
                + "PRIMARY KEY (CodCli))";
             
        try {
            sentencia.executeUpdate(tablaClientes);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al crear la tabla CLIENTES. "+ex);
            contador--;
        }
        try {
            sentencia.executeUpdate(tablaEscrituras);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al crear la tabla ESCRITURAS. "+ex);
            contador--;
        }
        try {
            sentencia.executeUpdate(tablaEscCli);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al crear la tabla ESCCLI. "+ex);
            contador--;
        }
        
        if (contador==3){
            Programa01.mostrarMensaje("Se han creado las 3 tablas");
        }
    }
    
    /**
     * inserta datos por defecto
     * y despues nos pide que le indiquemos que registro queremos meter
     */
    public void insertarDatos(){
        //insertamos datos por defecto
        if(cont==0){
            insertCliente="INSERT INTO CLIENTES "
                    + "(Cod_Cliente, Nombre, Telefono)"
                    + "VALUES ('111','AAA','666666661')";
            try {
                sentencia.executeUpdate(insertCliente);
            } catch (SQLException ex) {
                Programa01.mostrarMensaje("Fallo al crear el usuario 1. "+ex);
            }

            insertCliente="INSERT INTO CLIENTES "
                    + "(Cod_Cliente, Nombre, Telefono)"
                    + "VALUES ('222','BBB','666666662')";
            try {
                sentencia.executeUpdate(insertCliente);
            } catch (SQLException ex) {
                Programa01.mostrarMensaje("Fallo al crear el usuario 2. "+ex);
            }

            insertCliente="INSERT INTO CLIENTES "
                    + "(Cod_Cliente, Nombre, Telefono)"
                    + "VALUES ('333','CCC','666666663')";
            try {
                sentencia.executeUpdate(insertCliente);
            } catch (SQLException ex) {
                Programa01.mostrarMensaje("Fallo al crear el usuario 3. "+ex);
            }


            insertEscritura="INSERT INTO TABLAESCRITURAS "
                    + "(Codigo, Tipo, NombreFichero, Num_Interv )"
                    + "VALUES ('ESC01','TEST','TESTAMENTO1.DOC','3')";
            try {
                sentencia.executeUpdate(insertEscritura);
            } catch (SQLException ex) {
                Programa01.mostrarMensaje("Fallo al crear la escritura 1. "+ex);
            }

            insertEscritura="INSERT INTO TABLAESCRITURAS "
                    + "(Codigo, Tipo, NombreFichero, Num_Interv )"
                    + "VALUES ('ESC02','CPVE','COMPRAVENTA1.DOC','4')";
            try {
                sentencia.executeUpdate(insertEscritura);
            } catch (SQLException ex) {
                Programa01.mostrarMensaje("Fallo al crear la escritura 2. "+ex);
            }

            insertEscCli="INSERT INTO ESCCLI "
                    + "(CodCli, CodEsc)"
                    + "VALUES ('111','ESC01')";
            try {
                sentencia.executeUpdate(insertEscCli);
            } catch (SQLException ex) {
                Programa01.mostrarMensaje("Fallo al crear la EscCli 1. "+ex);
            }
            
            insertEscCli="INSERT INTO ESCCLI "
                    + "(CodCli, CodEsc)"
                    + "VALUES ('222','ESC02')";
            try {
                sentencia.executeUpdate(insertEscCli);
            } catch (SQLException ex) {
                Programa01.mostrarMensaje("Fallo al crear la EscCli 2. "+ex);
            }
        }
        cont++;
        //pedimos datos para meter a mano
        insertarDatosAMano();
        
                
    }
    
    /**
     * muestra un panel con cada tabla y sus elementos
     */
    public void recuperarDatos(){
    
        //definimos las consultas
        consultaCliente="SELECT * FROM CLIENTES";
        consultaEscrituras="SELECT * FROM TABLAESCRITURAS";
        consultaEscCli="SELECT * FROM ESCCLI";
        
        try {
            rsCliente=sentencia.executeQuery(consultaCliente);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al recopilar datos de los clientes. "+ex);
        }
        String resultado="";
        try {
            while (rsCliente.next ()) {
                resultado= resultado
                        +"\nCod.Cliente--" + rsCliente.getString("Cod_cliente")
                        + " | \t\tNombre-- " + rsCliente.getString("nombre")
                        + " | \t\tTeléfono-- "+ rsCliente.getString("telefono");
                }
            Programa01.mostrarMensaje("Tabla CLIENTES\n"
                                        + resultado);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al mostrarlos datos de los clientes. "+ex);
        }
        
        try {
            rsEscrituras=sentencia.executeQuery(consultaEscrituras);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al recopilar datos de las escrituras. "+ex);
        }
        String resultado2="";
        try {
            while (rsEscrituras.next ()) {
                resultado2= resultado2
                        +"\nCodigo-- " + rsEscrituras.getString("Codigo")
                        + " | \t\tTipo-- " + rsEscrituras.getString("tipo")
                        + " | \t\tNombreFichero-- " + rsEscrituras.getString("NombreFichero")
                        + " | \t\tNumInterv-- "+ rsEscrituras.getString("num_Interv");
                }
            Programa01.mostrarMensaje("Tabla ESCRITURAS\n"
                                        + resultado2);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al mostrarlos datos de las escrituras. "+ex);
        }
        
        try {
            rsEscCli=sentencia.executeQuery(consultaEscCli);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al recopilar datos de las escrituras. "+ex);
        }
        String resultado3="";
        try {
            while (rsEscCli.next ()) {
                resultado3= resultado3
                        +"\nCodigo_Cliente-- " + rsEscCli.getString("CodCli")
                        + " | \t\tCodigo_Esc-- "+ rsEscCli.getString("codEsc");
                }
            Programa01.mostrarMensaje("Tabla ESCCLI\n"
                                        + resultado3);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al mostrarlos datos de las EscCli. "+ex);
        }
        
        
    }
    
    
    /**
     * primero recopila los datos de clientes.
     * despues pide que le pongas un codigo, y recupera los
     * datos de ese cliente, y te muestra paneles para 
     * modificar sus datos
     */
    public void actualizarTabla(){
        
        consultaCliente="SELECT * FROM CLIENTES";
         
        //recopilamos datos de clientes
        try {
            rsCliente=sentencia.executeQuery(consultaCliente);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al recopilar datos de los clientes. "+ex);
        }
        String resultado4="";
        try {
            while (rsCliente.next ()) {
                resultado4= resultado4
                        +"\nCod.Cliente--" + rsCliente.getString("Cod_cliente")
                        + " | \t\tNombre-- " + rsCliente.getString("nombre")
                        + " | \t\tTeléfono-- "+ rsCliente.getString("telefono");
                }
            
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al mostrarlos datos de los clientes. "+ex);
        }
        
        //muestra panel con todos los clientes, para decirle un codigo
        actualizar=panelOpciones.showInputDialog("Tabla CLIENTES\n"+resultado4
                                                    ,"Introduce el codigo del cliente que quieras modificar");
        
        try {
            rsCliente=sentencia.executeQuery(consultaCliente);
            boolean verif=false;
            while (rsCliente.next()) {
                //si el codigo es el que hemos puesto
                //nos muestra un panel con el valor actual,
                //por si lo queremos cambiar
                if (actualizar.equals(rsCliente.getString("cod_Cliente"))){
                    String cod = panelOpciones.showInputDialog("el codigo antiguo es "
                            +rsCliente.getString("Cod_cliente")+ ". Pulse intro para dejar el mismo valor"
                                ,rsCliente.getString("Cod_cliente"));
                    String nom = panelOpciones.showInputDialog("el nombre antiguo es "
                            +rsCliente.getString("nombre")+ ". Pulse intro para dejar el mismo valor"
                                ,rsCliente.getString("nombre"));
                    String tel = panelOpciones.showInputDialog("el telefono antiguo es "
                            +rsCliente.getString("telefono")+ ". Pulse intro para dejar el mismo valor"
                                ,rsCliente.getString("telefono"));
                    String update="";

                    update="UPDATE CLIENTES SET "
                            + "Cod_Cliente='"+cod+"', "
                            + "nombre='"+nom+"', "
                            + "Telefono='"+tel+"' "
                            + "WHERE (Cod_Cliente='"+rsCliente.getString("cod_Cliente")+"')";

                    sentencia.executeUpdate(update);
                    Programa01.mostrarMensaje("Usuario actualizado");
                    //verificamos que el usuario existe
                    verif=true;
                }
            }
            //si no hemos encontrado el codigo solicitado
            if (!verif){
                Programa01.mostrarMensaje("No hay ningun cliente con ese código");
            }
        } catch (SQLException ex) {
        }
    }
    
    /**
     * recuperamos los datos de cliente que han hecho una compraventa
     */
    public void listarNombres()
    {
        
        consultaCPVE="SELECT * FROM CLIENTES, TABLAESCRITURAS, ESCCLI "
                + "WHERE (CLIENTES.COD_CLIENTE=ESCCLI.CODCLI "
                + "AND TABLAESCRITURAS.CODIGO=ESCCLI.CODESC)"
                + "AND TABLAESCRITURAS.TIPO='CPVE'";
        
        try {
            rsEscriturasCPVE=sentencia.executeQuery(consultaCPVE);
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al recopilar datos de las escrituras CPVE. "+ex);
        }
        
        String resultado3="";
        try {
            while (rsEscriturasCPVE.next ()) {
                resultado3= resultado3
                        +"\nCod.Cliente--" + rsEscriturasCPVE.getString("Cod_cliente")
                        + " | \t\tNombre-- " + rsEscriturasCPVE.getString("nombre")
                        + " | \t\tTeléfono-- "+ rsEscriturasCPVE.getString("telefono")
                        +" | \t\tCodigo-- " + rsEscriturasCPVE.getString("Codigo")
                        + " | \t\tTipo-- " + rsEscriturasCPVE.getString("tipo")
                        + " | \t\tNombreFichero-- " + rsEscriturasCPVE.getString("NombreFichero")
                        + " | \t\tNumInterv-- "+ rsEscriturasCPVE.getString("num_Interv");
            }
            Programa01.mostrarMensaje(resultado3);
        } catch (SQLException ex1) {
            Programa01.mostrarMensaje("Fallo al mostrarlos datos de las escrituras CPVE. "+ex1);
        }
        
        
        
    }
    
    /**
     * borra las 3 tablas creadas
     */
    public void borrarTablas(){
        
        int contador = 3;
        
        try {
            sentencia.executeUpdate("DROP TABLE ESCCLI ");
            Programa01.mostrarMensaje("Se ha borrado la tabla ESCCLI");
            contador--;
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al borrar la tabla ESCCLI. "+ex);
        }
                
        try {
            sentencia.executeUpdate("DROP TABLE CLIENTES ");
            Programa01.mostrarMensaje("Se ha borrado la tabla CLIENTES");
            contador--;
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al borrar la tabla CLIENTES. "+ex);
        }
        
        try {
            sentencia.executeUpdate("DROP TABLE TABLAESCRITURAS");
            Programa01.mostrarMensaje("Se ha borrado la tabla ESCRITURAS");
            contador--;
        } catch (SQLException ex) {
            Programa01.mostrarMensaje("Fallo al borrar la tabla ESCRITURAS. "+ex);
        }
        
        if (contador==0){
            Programa01.mostrarMensaje("Se han borrado las 3 tablas");
        }
    }
    
    /**
     * nos muestra un menu para insertar los datos en alguna de las 3 tablas
     */
    public void insertarDatosAMano(){
        boolean salir = false;
        do{
            opcion="";
            opcion=panelOpciones.showInputDialog("Elige tu numero de opción:"
                    +"\n1. Insertar cliente"
                    +"\n2. Insertar escritura"
                    +"\n3. Insertar EscCli"
                    +"\n4. Salir"
                        ,"Introduce tu selección");
            System.out.println(opcion);
            //por si damos a cancelar, que no de fallo
            if (opcion==null){
                opcion="4";
            }
            switch(opcion){
                case "1":
                    System.out.println("opcion1");
                    insertarCliente();
                    break;
                case "2":
                    System.out.println("opcion2");
                    insertarEscritura();
                    break;
                case "3":
                    System.out.println("opcion3");
                    insertarEscCli();
                    break;
                case "4":
                    System.out.println("salir");
                    salir=true;
                    break;
                                   
                default:
                    System.out.println("Opcion incorrecta");
                    Programa01.mostrarMensaje("opcion incorrecta");
            } 
        }while(!salir); 
        
    }
    
    /**
     * inserta cliente
     */
    public void insertarCliente(){
        insertCliente="";
        insertCliente="'"+
                        panelOpciones.showInputDialog("Dame el codigo", "Introduce el codigo")
                        +"',";
        insertCliente=insertCliente+"'"+
                        panelOpciones.showInputDialog("Dame el nombre", "Introduce el nombre")
                        +"',";
        insertCliente=insertCliente+"'"+
                        panelOpciones.showInputDialog("Dame el telefono", "Introduce el telefono")
                        +"'";
        System.out.println(insertCliente);
        
        insertCliente="INSERT INTO CLIENTES "
                + "(Cod_Cliente, Nombre, Telefono)"
                + "VALUES ("+insertCliente+")";
        try {
            sentencia.executeUpdate(insertCliente);
        } catch (SQLException ex3) {
            Programa01.mostrarMensaje("Error al insertar cliente. "+ex3);
        }
        
    }
    
    /**
     * inserta escritura
     */
    public void insertarEscritura(){
        insertEscritura="";
        
        insertEscritura="'"+
                        panelOpciones.showInputDialog("Dame el codigo", "Introduce el codigo")
                        +"',";
        insertEscritura=insertEscritura+"'"+
                        panelOpciones.showInputDialog("Dame el tipo", "Introduce el tipo")
                        +"',";
        insertEscritura=insertEscritura+"'"+
                        panelOpciones.showInputDialog("Dame el nombreFichero", "Introduce el nombreFichero")
                        +"',";
        insertEscritura=insertEscritura+"'"+
                        panelOpciones.showInputDialog("Dame el numInterv", "Introduce el num_Interv")
                        +"'";
        System.out.println(insertEscritura);
        
        insertEscritura="INSERT INTO TABLAESCRITURAS "
                + "(Codigo, Tipo, NombreFichero, Num_interv)"
                + "VALUES ("+insertEscritura+")";
        try {
            sentencia.executeUpdate(insertEscritura);
        } catch (SQLException ex3) {
            Programa01.mostrarMensaje("Error al insertar escritura. "+ex3);
        }
    }
    
    /**
     * inserta ESCCLI
     */
    public void insertarEscCli(){
        
        insertEscCli="";
        
        insertEscCli="'"+
                        panelOpciones.showInputDialog("Dame el codigo del cliente", "Introduce el codigo del cliente")
                        +"',";
        insertEscCli=insertEscCli+"'"+
                        panelOpciones.showInputDialog("Dame el codigo de la escritura", "Introduce el cod de la escritura")
                        +"'";
        System.out.println(insertEscCli);
        
        insertEscCli="INSERT INTO ESCCLI "
                + "(CodCli, CodEsc)"
                + "VALUES ("+insertEscCli+")";
        try {
            sentencia.executeUpdate(insertEscCli);
        } catch (SQLException ex3) {
            Programa01.mostrarMensaje("Error al insertar EscCli. "+ex3);
        }
    }
}
