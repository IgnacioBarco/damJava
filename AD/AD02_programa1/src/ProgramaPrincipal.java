
import generated.Alumnos;
import generated.CursoType;
import generated.DatosProf;
import generated.ObjectFactory;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ProgramaPrincipal {

    File archivo;
    CursoType cursoType;
    Alumnos alumnos;
    Alumnos.Alumno alumno1, alumno2, alumno3, alumnoNuevo, alumnoEliminado;
    DatosProf datosProf;
    ObjectFactory miXML;
    Marshaller m;
    JAXBElement<CursoType> element;
    JAXBContext contexto;
    Scanner scaner;
    boolean salida = false;
    String res;

    public ProgramaPrincipal() {

        crearEstructuraXML();

        archivo = new File("fichero.xml");
        if (archivo.exists()) {
            archivo.delete();
        } else {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                System.out.println("Fallo al crear el archivo: " + ex);
            }
        }

        crearXML();

        ejecutarConsola();
    }

    /**
     * Crea los datos del XML
    *
     */
    public void crearEstructuraXML() {

        cursoType = new CursoType();

        datosProf = new DatosProf();
        alumnos = new Alumnos();
        alumno1 = new Alumnos.Alumno();
        alumno2 = new Alumnos.Alumno();
        alumno3 = new Alumnos.Alumno();
        alumnoNuevo = new Alumnos.Alumno();

        datosProf.setNombre("Jesus Dieguez");
        datosProf.setAsignatura("acceso a datos");
        datosProf.setEspecialidad("DAM");
        datosProf.setCurso("Distancia");
        datosProf.setModalidad(BigDecimal.valueOf(2));
        datosProf.setPais("Espana");

        alumno1.setNombreAlumno("Luis");
        alumno1.setEdad(18);
        alumno1.setDireccion("Calle AAAAAAAA");
        alumno1.setComentario("aaaaaaaaaaaaaa");
        alumno1.setTelefono(BigInteger.valueOf(666123456));
        alumnos.getAlumno().add(alumno1);

        alumno2.setNombreAlumno("Antonio");
        alumno2.setEdad(31);
        alumno2.setDireccion("Calle BBBBBBB");
        alumno2.setComentario("bbbbbbbbbbbbbb");
        alumno2.setTelefono(BigInteger.valueOf(666222222));
        alumnos.getAlumno().add(alumno2);

        alumno3.setNombreAlumno("Alfredo");
        alumno3.setEdad(45);
        alumno3.setDireccion("Calle CCCCCC");
        alumno3.setComentario("cccccccccccccc");
        alumno3.setTelefono(BigInteger.valueOf(666000123));
        alumnos.getAlumno().add(alumno3);

        cursoType.setAlumnos(alumnos);
        cursoType.setProfesor(datosProf);
        cursoType.setComentario("este el un curso del ribera");

    }

    /**
     * Crea el fichero XML
     */
    public void crearXML() {

        miXML = new ObjectFactory();
        element = miXML.createCurso(cursoType);

        try {
            contexto = JAXBContext.newInstance(ObjectFactory.class);
            m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(element, archivo);
            System.out.println("Fichero XML creado.");
        } catch (JAXBException ex) {
            System.out.println("Error al crear el .xml: " + ex);
        }

    }

    /**
     * Nos muestra el menu por la consola
     */
    public void ejecutarConsola() {
        do {
            System.out.println("\n\n1. Modificar profesor.");
            System.out.println("2. Añadir nuevo alumno.");
            System.out.println("3. Eliminar alumno.");
            System.out.println("4. Imprimir fichero XML.");
            System.out.println("5. Salir\n");
            System.out.println("Elige una opción: ");

            scaner = new Scanner(System.in);
            String opcion = scaner.nextLine();

            int opcionN = 6;
            try {
                opcionN = Integer.valueOf(opcion);
            } catch (Exception e) {
                opcionN = 6;
            }

            switch (opcionN) {
                case 1:
                    System.out.println(modificarProfesor());
                    break;
                case 2:
                    System.out.println(addAlumno());
                    break;
                case 3:
                    System.out.println(eliminarAlumno());
                    break;
                case 4:
                    imprimeFichero();

                    break;
                case 5:
                    salida = true;
                    break;

                default:
                    System.out.println("Opción incorrecta");
            }

        } while (!salida);

    }

    /**
     * Modifica el profesor
     *
     * @return devuelve el resultado en un String
     */
    public String modificarProfesor() {
        res = "";
        System.out.println("Dime la asignatura nueva");
        datosProf.setAsignatura(scaner.nextLine());
        System.out.println("Dime el curso nuevo");
        datosProf.setCurso(scaner.nextLine());
        actualizarFichero();
        res = "datos del profesor cambiados";
        return res;
    }

    /**
     * Añade alumno
     *
     * @return devuelve el resultado en un String
     */
    public String addAlumno() {
        res = "";
        boolean verificarDatos = true;

        System.out.println("nombre:");
        alumnoNuevo.setNombreAlumno(scaner.nextLine());

        System.out.println("edad:");
        try {
            alumnoNuevo.setEdad(scaner.nextInt());
        } catch (Exception e) {
            verificarDatos = false;
        }
        System.out.println("direccion:");
        alumnoNuevo.setDireccion(scaner.next());

        System.out.println("comentario:");
        alumnoNuevo.setComentario(scaner.next());

        System.out.println("Telefono:");
        try {
            alumnoNuevo.setTelefono(BigInteger.valueOf(scaner.nextInt()));
        } catch (Exception e) {
            verificarDatos = false;
        }

        if (verificarDatos) {
            alumnos.getAlumno().add(alumnoNuevo);
            actualizarFichero();
            res = "Alumno creado!";
        } else {
            res = "Datos erroneos, no se ha podido crear el usuario.";
        }

        return res;
    }

    /**
     * Elimina alumno
     *
     * @return devuelve el resultado en un String
     */
    public String eliminarAlumno() {
        res = "";
        boolean existe = false;;
        alumnoEliminado = new Alumnos.Alumno();
        System.out.println("Escribe el nombre del alumno que desees borrar:");
        String elemento = scaner.nextLine();
        for (Alumnos.Alumno alum : alumnos.getAlumno()) {
            if (alum.getNombreAlumno().equals(elemento)) {
                alumnos.getAlumno().remove(alum);
                res = "Alumno " + elemento + " eliminado.";
                actualizarFichero();
                existe = true;
                break;
            }

        }

        if (!existe) {
            res = "No existe ningun Alumno con ese nombre";
        }

        return res;
    }

    /**
     * Saca por consola los valores del xml
     */
    public void imprimeFichero() {
        try {
            m.marshal(element, System.out);
        } catch (JAXBException ex) {
            System.out.println("Error al imprimir los datos: " + ex);
        }

    }

    /**
     * Actualiza el fichero .xml
     */
    public void actualizarFichero() {

        if (archivo.exists()) {
            archivo.delete();
        }
        try {
            m.marshal(element, archivo);
        } catch (JAXBException ex) {
            System.out.println("Fallo al guardar el fichero: " + ex);
        }
    }
}
