
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author Nacho
 */
public class Cliente {
    
    String datosIn, dni, nombre, apellidos, telefonoAux;
    ArrayList<String> telefonos, emails, noCoincidentes;
    ArrayList<String> emailsDuplicados, telefonosDuplicados; 
    String [] todosLosDatos;
    int camposIntroducidos,i,totalTelefonos=0;
    boolean validacion;
    Element e,t,m;
    Document documento;
    Comment error;
    Comparator<String> comparaTelefonos;
    
    //seccion de patrones
    
    /**
    * ***** "[XYxy]?[0-9]{1,9}[A-Za-z]" ****
    * primera letra opcional, x ó y (en mayuscula o minuscula) ---
    *entre 1 y 9 digitos de 0 a 9 ---
    *letra entre a y z(en mayuscula o minuscula)
    */
    Pattern patronDNI = Pattern.compile("[XYxy]?[0-9]{1,9}[A-Za-z]");
    Matcher mDni;
    
    
    /**
     * ***** "\"[A-Za-z]*\"" *****
     * todas las letras que quieran entre comillas
     */
    Pattern patronNombreYApellido = Pattern.compile("\"[A-Za-z]*\"");
    Matcher mNYA;
    
    /**
     * ***** "[a-z]*@[a-z]*\\.[a-z]{1,3}" *****
     * utilizamos solo minusculas ya que luego lo pasamos a minusculas antes de tratarlo ---
     * numero ilimitado de letras entre a-z ---
     * @ ---
     * numero ilimitado de letras entre a-z ---
     * . ---
     * 3 letras para la extension
     */
    Pattern patronEmail = Pattern.compile("[a-z]*@[a-z]*\\.[a-z]{1,3}");
    Matcher mEmail;
    
    
    /**
     * ***** "\\+?[0-9]*" *****
     * + opcional ---
     * numero ilimitado de numeros
     */
    Pattern patronTelefono = Pattern.compile("\\+?[0-9]*");
    Matcher mTelefono;
    
    /**
     * ***** "\\+?[0-9]{9,11}" *****
     * + opcional ---
     * entre 9 y 11 digitos de 0 a 9
     */
    Pattern patronTelefono2 = Pattern.compile("\\+?[0-9]{9,11}");
    Matcher mTelefono2;
    
    public Cliente(String datos){
    
        datosIn = datos;
        telefonos = new ArrayList<String>();
        telefonosDuplicados = new ArrayList<String>();
        emails = new ArrayList<String>();
        emailsDuplicados = new ArrayList<String>();
        noCoincidentes = new ArrayList<String>();
                
    }
    
    /**
    * Validamos si hay al menos 5 valores entre comas
    * @return true si es un formato valido o false si no tiene al menos 5 campos
    */
    public boolean checkearFormatoDatosIntroducidos(){
        validacion=false;
        todosLosDatos=datosIn.split(",");
        camposIntroducidos=todosLosDatos.length;
        //System.out.println("campos = "+camposIntroducidos);
        
        if (camposIntroducidos>=5){
            validacion=true;
        } else {
            System.out.println("La linea tiene menos de 5 campos");
        }
        
        return validacion;
    }   
    
    /**
     * Guarda los campos dni, nombre y apellidos en variables 
     * y los telefonos y emails los separa en dos ArrayList
     * Tambien crea otros dos ArrayList con los telefonos y emails duplicados.
     * Por ultimo crea un ArrayList con los datos que no corresponden con ningun patron dado
     */
    public void obtenerCampos(){
        i=0;
        dni = todosLosDatos[0].trim();
        nombre = todosLosDatos[1].trim();
        apellidos = todosLosDatos[2].trim();
        
        //para evaluar los campos variables, si son emails o telefonos
        //hacemos una primera valoracion rapida, si lleva @ es un email
        //despues al crear el documento XML se validara mas severamente
        for (String dat : todosLosDatos) {
            //evaluamos a partir del cuarto campo
            if (i>2){
                //System.out.println("i"+i);
                dat=dat.toLowerCase().trim();
                
                mEmail = patronEmail.matcher(dat);
                
                //limpiamos el telefono de caracteres "raros"
                telefonoAux=dat.replace("(", "");
                telefonoAux=telefonoAux.replace(")", "");
                telefonoAux=telefonoAux.replace("\"", "");
                mTelefono=patronTelefono.matcher(telefonoAux);
                
                if (mEmail.matches()){
                    //este if lo ponemos para que no intente buscar en un ArrayList vacio
                    if (emails.isEmpty()){
                       emails.add(dat); 
                       //System.out.println("encontrado email "+dat);
                    } else if (!emails.isEmpty()){
                        validacion=false;
                        for (String dat2 : emails) {
                            if (dat.equals(dat2)){
                                    validacion=true;
                                    //System.out.println("encontrados email iguales "+dat+dat2);
                            }
                        }
                        //si validacion sigue siendo false, no esta duplicado
                        if (!validacion){
                            emails.add(dat);  
                            //System.out.println("encontrado email "+dat);
                        //si es true, el email esta duplicado y lo metemos en otro ArrayList
                        } else {
                            emailsDuplicados.add(dat);
                        }
                        
                    } 
                } else if (mTelefono.matches()) {
                    //este if lo ponemos para que no intente buscar en un ArrayList vacio
                    if (telefonos.isEmpty()){
                        telefonos.add(telefonoAux);
                        //System.out.println("primer telefono encontrado"+dat);
                    } else if (!telefonos.isEmpty()){
                        validacion=false;
                        for (String dat3 : telefonos) {
                            dat3=dat3.replace("(", "");
                            dat3=dat3.replace(")", "");
                            dat3=dat3.replace("\"", "");
                            //System.out.println("comparando "+telefonoAux+" "+dat3);
                            if(telefonoAux.equals(dat3)){
                                validacion=true;
                                //System.out.println("encontrados telefonos duplicados"+dat+dat3);
                            }
                        }
                        //si la validacion es falsa lo añadimos a los telefonos
                        if (!validacion){
                            telefonos.add(telefonoAux);
                            //System.out.println("encontrado telefono "+dat);
                        //si es true, el telefono esta duplicado y lo metemos en otro ArrayList
                        } else {
                            telefonosDuplicados.add(telefonoAux);
                        }
                    }
                
                //lo que no coinciden con ningun patron, por ejemplo fdg4f56dgs45df6s4gdfs54, 
                //los guardamos en otro ArrayList
                } else {
                    noCoincidentes.add(dat);
                    //System.out.println("No coincide "+dat);
                }
            }
            
            i++;
        }
    }
    
    /**
     * Crea el fichero XML
     */
    public void construirXML(){
        //creamos el documento 
        documento = DOMUtil.crearDOMVacio("datos_del_cliente");
        
        //insertamos los datos
        
        ///////////////////////////
        //parte del dni///////////
        /////////////////////////
        e = null;
        mDni = patronDNI.matcher(dni);
        if (mDni.matches()){
            e=documento.createElement("id");
            e.setTextContent(dni);
            documento.getDocumentElement().appendChild(e); 
        //si no corresponde con el patron, le ponemos ERROR 
        //y mostramos comentario de error en el XML
        } else {
            mostrarMensajeErrorEnXML("Fallo al procesar el campo del dni. "
                    + "Se ha introducido "+dni+", que no corresponde con el patron");
            e=documento.createElement("id");
            e.setTextContent("ERROR");
            documento.getDocumentElement().appendChild(e);
            
        }
                
        
        
        ///////////////////////////
        //parte de los nombre/////
        /////////////////////////
        e = null;
        mNYA=patronNombreYApellido.matcher(nombre);
        if(mNYA.matches()){
            e=documento.createElement("nombre");
            //le quitamos las comillas
            nombre=nombre.replace("\"", "");
            e.setTextContent(nombre);
            documento.getDocumentElement().appendChild(e);
        //si no corresponde con el patron, le ponemos ERROR 
        //y mostramos comentario de error en el XML
        } else {
            mostrarMensajeErrorEnXML("Fallo al procesar el campo del nombre. "
                    + "Se ha introducido "+nombre+", que no corresponde con el patron");
            e=documento.createElement("nombre");
            e.setTextContent("ERROR");
            documento.getDocumentElement().appendChild(e);
        }
        
        
        
        //////////////////////////////
        //parte de los apellidos/////
        ////////////////////////////
        e = null;
        mNYA=patronNombreYApellido.matcher(apellidos);
        if(mNYA.matches()){
            e=documento.createElement("apellidos");
            apellidos=apellidos.replace("\"", "");
            e.setTextContent(apellidos);
            documento.getDocumentElement().appendChild(e);
        //si no corresponde con el patron, le ponemos ERROR 
        //y mostramos comentario de error en el XML
        } else {
            mostrarMensajeErrorEnXML("Fallo al procesar el campo de los apellidos. "
                    + "Se ha introducido "+apellidos+", que no corresponde con el patron");
            e=documento.createElement("apellidos");
            e.setTextContent(apellidos);
            documento.getDocumentElement().appendChild(e);
        }
        
        
        
        //////////////////////////////
        //parte de los telefonos/////
        ////////////////////////////
        e = null;
        t=null;
        
        /**
         * ordenamos los telefonos para que ponga primero los que no llevan "+"
         * ordenados de mayor a menor, y despues los que llevan
         * "+" tambien ordenados de mayor a menor
        */
        comparaTelefonos= new Comparator<String>() {
            @Override
            public int compare(String tlf1, String tlf2) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              
                int orden=0;
                int res = tlf1.compareTo(tlf2);
                if (res<0){
                    orden=1;
                } else if (res>0){
                    orden=-1;
                }
                
              return orden;  
            }
        };
        
        Collections.sort(telefonos,comparaTelefonos);
        
        e=documento.createElement("telefonos");
        
            //si no se han introducido telefonos validos
            if (telefonos.isEmpty()){
                mostrarMensajeErrorEnXML("No se han introducido telefonos");
                
                t=documento.createElement("telefono");
                t.setTextContent("ERROR");
                e.appendChild(t);
                
                t=documento.createElement("totaltelefonos");
                t.setTextContent("0");
                e.appendChild(t);
                
            } else {
                for (String telefono : telefonos) {
                    mTelefono2=patronTelefono2.matcher(telefono);
                    if (mTelefono2.matches()){
                        t=documento.createElement("telefono");
                        t.setTextContent(telefono);
                        e.appendChild(t);
                        totalTelefonos++;
                    //si no coincide con el patron
                    } else {
                        mostrarMensajeErrorEnXML("Fallo al procesar el campo del telefono. "
                    + "Se ha introducido "+telefono+", que no corresponde con el patron");
                    }
                }

                t=documento.createElement("totaltelefonos");
                    t.setTextContent(""+totalTelefonos);
                e.appendChild(t);
            }    
            
            //si hay telefonos duplicados guardados, mostramos el error en el xml
            if (!telefonosDuplicados.isEmpty()){
                for (String tlfDuplicado : telefonosDuplicados) {
                    mostrarMensajeErrorEnXML("Se ha introducido un telefono duplicado "
                        +tlfDuplicado);
            
                }
            }
            
        
        documento.getDocumentElement().appendChild(e);
        
        
        
        ///////////////////////////
        //parte de los emails/////
        /////////////////////////
        e = null;
        m=null;
        //ordenamos los emails
        Collections.sort(emails);
        
        e=documento.createElement("mails");
            
            //si no se han introducido emails validos
            if (emails.isEmpty()){
                m=documento.createElement("mail");
                m.setTextContent("ERROR");
                e.appendChild(m);
                mostrarMensajeErrorEnXML("No se han introducido emails");
            } else {
                for (String email : emails) {
                    m=documento.createElement("mail");
                        m.setTextContent(email);
                    e.appendChild(m);
                }
            }
            
            //si hay emails duplicados guardados, mostramos el error en el xml
            if (!emailsDuplicados.isEmpty()){
                for (String emailDuplicado : emailsDuplicados) {
                    mostrarMensajeErrorEnXML("Se ha introducido un email duplicado "
                        +emailDuplicado);
            
                }
            }
            
            
            
        documento.getDocumentElement().appendChild(e);
        
       //mostramos el error de los campos que no cuadran con telefono ni email
        for (String error : noCoincidentes) {
                mostrarMensajeErrorEnXML("Se ha introducido un valor que no se reconoce "
                        + "ni como email ni teléfono: "+error);
            
        }
        
        //pasamos el documento a un fichero
        //el fichero esta en la raiz del proyecto
        DOMUtil.DOM2XML(documento,"cliente.xml");
        System.out.println("\n\nDocumento cliente.xml creado.\n\n");
    }
    
    /**
     * Muestra un mensaje de error en el XML
     * @param mensaje Le indicamos el error que debe escribir
     */
    public void mostrarMensajeErrorEnXML(String mensaje){
        error=documento.createComment(mensaje);
        documento.getDocumentElement().appendChild(error);
    }
}
