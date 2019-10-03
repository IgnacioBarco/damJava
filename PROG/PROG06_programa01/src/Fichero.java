
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;





/**
 *
 * @author Nacho
 */

//Clase que usamos para hacer todos las operaciones con el fichero
public class Fichero {
    
    File fichero = new File("clientes.dat");
    Cliente clienteNuevo;
    
    FileOutputStream oFichero;
    FileOutputStream oTFichero;
    FileInputStream iFichero;
    ObjectInputStream ios;
    ObjectOutputStream oos;
    ObjectOutputStream oTos;
    int i;
    
    //en el constructor por defecto simplemente comprobamos si existe el fichero clientes.dat
    public Fichero(){
       if(fichero.exists()){
            System.out.println("El fichero clientes.dat ya existe y esta situado en "+fichero.getAbsolutePath()+"\n");
        }else {
            System.out.println("El fichero clentes.dat no existe\n");
        }
    }
    
    //pedimos que nos den los datos del cliente y creamos un objeto con dichos datos
    //en cada campo hacemos unas verificaciones para que los datos sean correctos
    public Cliente pedirDatosCliente(){
        
        Scanner datos = new Scanner(System.in);
        String nif, nombre,direccion, telefono, deudaString;
        int deuda=0;
        boolean verificar=false;
        
        do{
            System.out.println("\nEl nombre debe tener entre 1 y 20 letras");
            System.out.print("Dame el nombre: ");
            nombre=datos.nextLine();
            if (nombre.matches("[A-Za-z]{1,20}")){
                verificar=true;
            }
        }while(!verificar);
        
        verificar=false;
        do{
            System.out.println("\nEl nif debe tener 8 digitos y una letra");
            System.out.print("Dame el NIF: ");
            nif=datos.nextLine();
            if(nif.matches("[0-9]{8}+[a-zA-Z]{1}")){
                verificar=true;
            }
        }while(!verificar);
        
        verificar=false;
        do{
            System.out.println("\nLa direccion debe tenet entre 1 y 20 letras, seguido de una coma, y despues entre 1 y 3 digitos");
            System.out.println("Por ejemplo: weqrwerqwer,12");
            System.out.print("Dame la dirección: ");
            direccion=datos.nextLine();
            if(direccion.matches("[A-Za-z]{1,20}+\\,+[0-9]{1,3}")){
                verificar=true;
            }
        }while(!verificar);
        
        verificar=false;
        do{
            System.out.println("\nEl telefono debe tener 9 digitos");
            System.out.print("Dame el telefono: ");
            telefono=datos.nextLine();
            if(telefono.matches("[0-9]{9}")){
                verificar=true;
            }
        }while(!verificar);
        
        verificar=false;
        do{
            System.out.println("\nLa deuda tiene que ser un numero entero entre 0 y "+Integer.MAX_VALUE);
            System.out.print("Dame la deuda: ");
            deudaString=datos.nextLine();
            if(deudaString.matches("[0-9]*")){
            try{ 
                deuda=Integer.parseInt(deudaString);
                if(deuda>=0){
                    verificar=true;
                }
            }catch(NumberFormatException ex){
                System.out.println("Se ha introducido un valor erroneo");
                deuda=-5;
            }
            }
        }while(!verificar);
        
        //creamos el objeto nuevo y lo devolvemoscomo valor
        clienteNuevo= new Cliente(nombre,nif,direccion,telefono,deuda);
        return clienteNuevo;
    }
    
    //añadimos el cliente, pasandole el objeto desde el metodo pedirDatosCliente
    public void anadeCliente(Cliente clienteNuevo){
        //comprobamos si el fichero existe o no
        //si no existe, creamos abrimos el fichero y le pasamos el objeto
        //si el fichero existe, utilizamos el metodo sobreescrito de ObjectOutpotStream( al que le hemos llamdoNuevoObjectOutputStream)
        //para pasarle los objetos y que no escriba la cabecera de nuevo
        if (!fichero.exists()){
            try { 
                fichero.createNewFile();
                System.out.println("Fichero creado en "+fichero.getAbsolutePath());
            } catch (IOException ex) {
                System.out.println("Fallo al crear el archivo");
            }
            try {
               oFichero = new FileOutputStream("clientes.dat");
               oos = new ObjectOutputStream(oFichero);
               oos.writeObject(clienteNuevo);
               System.out.print("escrito "+ clienteNuevo.toString());
               oos.close();
               oFichero.close();
               
           } catch (IOException ex) {
               System.out.print("fallo al crear el objeto");
           }
            
        } else {
            try {
               oFichero = new FileOutputStream("clientes.dat",true);
               oos = new NuevoObjectOutputStream(oFichero);
               oos.writeObject(clienteNuevo);
               System.out.print("\nSe ha introducido en el fichero el siguiente registro: "+ clienteNuevo.toString()+"\n\n");
               oos.close();
               oFichero.close();
               
           } catch (IOException ex) {
               System.out.print("fallo al crear el objeto");
           }
        }
    }
    
    //comprobamos si existe el fichero
    //en el caso de que exista, abrimos el fichero, recuperamos uno a uno los objetos y 
    //utilizamos el metodo toString del objeto para imprimirlo por pantalla
    //tambien comprobamos que el fichero tenga algun cliente guardado, si no es asi, 
    //mostramos el mensaje de que no hay clientes guardados
    public void listarClientes(){
        if (!fichero.exists()){
            System.out.println("\nNo existe ningun fichero que consultar\n");
        } else {
            i=0;
            try {
                iFichero = new FileInputStream("clientes.dat");
                ios = new ObjectInputStream(iFichero);
                while(iFichero.available()>0){
                    Cliente objeto = (Cliente)ios.readObject();
                    System.out.println("\n"+objeto.toString());
                    i++;
                }
                   
                } catch (ClassNotFoundException ex) {
                    System.out.println("fallo 1");
                } catch (IOException ex) {
                    System.out.println("fallo 2");
                }
                       
           try {
               ios.close();
               iFichero.close();
           } catch (IOException ex2) {
               System.out.println("fallo 3");
           }
            if (i==0){
            System.out.println("El fichero no tiene clientes guardados");
          }
        
        }
               
    }
        
    
    //abrimos el fichero, y comprobamos todos los objetos, si alguno tiene el mismo nif lo sacamos por pantalla
    public void buscarCliente(){
        if (!fichero.exists()){
            System.out.println("\nNo existe ningun fichero que consultar\n");
        } else {
            Scanner dato = new Scanner(System.in);
            System.out.print("dame el nif del cliente que quieras buscar: ");
            String nif=dato.nextLine();
            boolean encontrar=false;
            try {
                iFichero = new FileInputStream("clientes.dat");
                ios = new ObjectInputStream(iFichero);
                while(iFichero.available()>0){
                    Cliente objeto = (Cliente)ios.readObject();
                    if (objeto.nif.equals(nif)){
                    System.out.println("\n"+objeto.toString());
                    encontrar=true;
                    }
                }                   
                } catch (ClassNotFoundException ex) {
                    System.out.println("fallo");
                } catch (IOException ex) {
                    System.out.println("fallo");
                }
                       
           try {
               ios.close();
               iFichero.close();
           } catch (IOException ex2) {
               System.out.println("fallo");
           }
        
           if (!encontrar){
               System.out.println("No hay ningun cliente con ese nif");
           }
            
        }
    }
    
    //borra un cliente que coincida con el nif introducido
    public void borrarCliente(){
        //creamos un fichero temporal para pasarle los datos
        File ficheroTemp = new File("clientes.temp");
        
        //comprobamos que existe y pedimos el nif
        if (!fichero.exists()){
            System.out.println("\nNo existe ningun fichero que consultar\n");
        } else {
            Scanner dato = new Scanner(System.in);
            System.out.print("Dame el nif del cliente que quieras borrar: ");
            String nif=dato.nextLine();
            boolean encontrar=false;
            
            //abrimos flujos en los 2 archivos 
            try {
                iFichero = new FileInputStream(fichero);
                ios = new ObjectInputStream(iFichero);
                
                oTFichero=new FileOutputStream(ficheroTemp);
                oTos=new ObjectOutputStream(oTFichero);
                
                //recorremos el fichero y validamos uno a uno los objetos
                //si no es el nif, se lo pasamos al fichero temporal
                //si es el nif, cambiamos la variable encontrar y no hacemos nada
                while(iFichero.available()>0){
                    Cliente objeto = (Cliente)ios.readObject();
                    if (objeto.nif.equals(nif)){
                        encontrar=true;
                    } else {
                        oTos.writeObject(objeto);
                    }
                }
                   
                } catch (ClassNotFoundException ex) {
                    System.out.println("fallo 1");
                } catch (IOException ex) {
                    System.out.println("fallo 2");
                }
                       
           try {
               ios.close();
               iFichero.close();
               oTos.close();
               oTFichero.close();
           } catch (IOException ex2) {
               System.out.println("fallo 3");
           }
        
           //si no lo hemos encontrado, borramos el fichero temporal
           //si lo encontramos, borramos el original y renombramos el temporal
           if (!encontrar){
               ficheroTemp.delete();
               System.out.println("No se puede borrar el registro ya que no hay ningun cliente con ese nif");
           } else {
               fichero.delete();
               ficheroTemp.renameTo(fichero);
               System.out.println("fichero acualizado.");
           }
        }
    }
    
    
    //borra el fichero clintes.dat si existe
    public void borrarFichero(){
        if (!fichero.exists()){
            System.out.println("\nNo existe el fichero, no se puede borrar\n");
        } else {
            fichero.delete();
            System.out.println("Fichero borrado.");
        }   
    }
    
    
}
