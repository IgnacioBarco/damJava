
import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class OperacionesBD {

    Set<Alumno> setAlumnos = null;

    public OperacionesBD() {

        //ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"colegio.db4o");
    }

    public String almacenarAlumno(String id, Alumno alumno) {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        try {
            ObjectSet consulta = baseDatos.queryByExample(alumno);
            if (consulta.isEmpty()) {
                baseDatos.store(alumno);
                return id + " creado";
            } else {
                return id + " ya existe";
            }

        } catch (Exception ex) {
            System.out.println("Error al crear el " + id + ": " + ex);
            return "Se ha producido un error al intentar insertar al " + id + ": " + ex;
        } finally {
            baseDatos.close();
        }
    }

    public String almacenarAsignatura(String id, Asignatura asignatura) {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        try {
            ObjectSet consulta = baseDatos.queryByExample(asignatura);
            if (consulta.isEmpty()) {
                baseDatos.store(asignatura);
                return id + " creada";
            } else {
                return id + " ya existe";
            }

        } catch (Exception ex) {
            System.out.println("Error al crear el " + id + ": " + ex);
            return "Se ha producido un error al intentar insertar la " + id + ": " + ex;
        } finally {
            baseDatos.close();
        }
    }

    public String almacenarNota(String id, Nota nota) {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        try {
            ObjectSet consulta = baseDatos.queryByExample(nota);
            if (consulta.isEmpty()) {
                baseDatos.store(nota);
                return id + " creada";
            } else {
                return id + " ya existe";
            }

        } catch (Exception ex) {
            System.out.println("Error al crear el " + id + ": " + ex);
            return "Se ha producido un error al intentar insertar la " + id + ": " + ex;
        } finally {
            baseDatos.close();
        }
    }

//consulta SODA
    public String consultarNotas() {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        String res = "Nombre\tAsignatura\t\tNota"
                + "\n-----------------------------------------------------------------------\n";
        Query consulta = baseDatos.query();
        consulta.constrain(Nota.class);
        try {
            ObjectSet resultado = consulta.execute();
            if (resultado.isEmpty()) {
                return "no ha datosde notas que consultar";
            } else {
                while (resultado.hasNext()) {
                    Nota nota = (Nota) resultado.next();
                    res = res
                            + nota.getAlumno().getNombre() + "\t"
                            + nota.getAsignatura().getDenom() + "\t\t"
                            + nota.getNota() + "\n";
                }
                return res;
            }

        } catch (Exception ex) {
            System.out.println("Error al crear la consulta de notas: " + ex);
            return "Se ha producido un error al intentar recuperar los datos: " + ex;
        } finally {
            baseDatos.close();
        }

    }

    public String consultarAlumno(int id) {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        String res = "";
        Query consulta = baseDatos.query();
        consulta.constrain(Alumno.class);
        consulta.descend("codigo").constrain(id);
        try {
            ObjectSet resultado = consulta.execute();
            if (resultado.isEmpty()) {
                return "no ha ningun alumno con ese codigo";
            } else {
                if (resultado.hasNext()) {
                    Alumno alumno = (Alumno) resultado.next();
                    res = res
                            + "Codigo alumno: " + alumno.getCodigo() + "\n"
                            + "Nombre alumno: " + alumno.getNombre() + "\n"
                            + "Poblacion:     " + alumno.getPoblacion() + "\n";

                }
            }

        } catch (Exception ex) {
            System.out.println("Error al crear la consulta de notas: " + ex);
            return "Se ha producido un error al intentar recuperar los datos: " + ex;
        }

        Query consulta2 = baseDatos.query();
        consulta2.constrain(Nota.class);
        boolean ver = false;
        int numAsig = 0;
        String aux = "";
        try {
            ObjectSet resultado2 = consulta2.execute();

            while (resultado2.hasNext()) {
                Nota nota = (Nota) resultado2.next();
                if (nota.getAlumno().getCodigo() == id) {
                    aux = aux
                            + "\n" + nota.getAsignatura().getDenom() + "\t"
                            + nota.getNota() + "\n";
                    numAsig++;
                    ver = true;
                }

            }

        } catch (Exception ex) {
            System.out.println("Error al crear la consulta de notas2: " + ex);
            return "Se ha producido un error al intentar recuperar los datos: " + ex;
        } finally {
            baseDatos.close();
        }

        res = res
                + "Numero Asignaturas: " + numAsig + "\n"
                + "Asignatura\tNOTA\n"
                + "-----------------------------"
                + aux;
        if (!ver) {
            res = res + "\nel alumno no tienen notas";
        }
        return res;

    }

    public String borrarDuplicadosAlumnos() {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        String res = "";
        Query consulta = baseDatos.query();
        consulta.constrain(Alumno.class);
        //consulta.descend("codigo").constrain(id);
        try {
            ObjectSet resultado = consulta.execute();
            if (resultado.isEmpty()) {
                return "no ha ningun alumno con ese codigo";
            } else {
                while (resultado.hasNext()) {
                    Alumno alumno = (Alumno) resultado.next();
                    res = res
                            + alumno.getNombre() + "\t"
                            + alumno.getPoblacion() + "\t"
                            + alumno.getCodigo() + "\n";
                }
                return res;
            }

        } catch (Exception ex) {
            System.out.println("Error al crear la consulta de notas: " + ex);
            return "Se ha producido un error al intentar recuperar los datos: " + ex;
        } finally {
            baseDatos.close();
        }

    }

    public String InsertarNota(String alumno, String asignatura, String not) {
        String res = "";
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        Query consulta = baseDatos.query();
        consulta.constrain(Nota.class);
        boolean ver = false;
        try {
            ObjectSet resultado = consulta.execute();
            while (resultado.hasNext()) {
                Nota nota = (Nota) resultado.next();
                if (nota.getAlumno().getNombre().equalsIgnoreCase(alumno)
                        && nota.getAsignatura().getDenom().equalsIgnoreCase(asignatura)) {
                    ver = true;
                }

            }

        } catch (Exception ex) {
            System.out.println("Error al crear la consulta de notas2: " + ex);
            return "Se ha producido un error al intentar recuperar los datos: " + ex;
        } finally {
            baseDatos.close();
        }

        if (ver) {
            res = "El usuario ya tiene una nota en esa asignatura";
        } else {

            Alumno nuevoAl = new Alumno();
            Asignatura nuevaAs = new Asignatura();
            baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
            Alumno alumn = new Alumno(0, alumno, null);
            ObjectSet consultaAl = baseDatos.queryByExample(alumn);
            if (consultaAl.hasNext()) {
                nuevoAl = (Alumno) consultaAl.next();
            }

            Asignatura asign = new Asignatura(0, asignatura, 0);
            ObjectSet consultaAs = baseDatos.queryByExample(asign);
            if (consultaAs.hasNext()) {
                nuevaAs = (Asignatura) consultaAs.next();
            }

            //obtenemos el id max
            List<Nota> listaNotas = baseDatos.queryByExample(new Nota());
            Comparator<Nota> comparador = (nota1, nota2) -> Double.compare(nota1.getNota(), nota2.getNota());
            int notaMax = listaNotas.stream().max(comparador).get().getIdNota();

            Nota notaNueva = new Nota(notaMax, nuevoAl, nuevaAs, Double.valueOf(not));

            baseDatos.close();

            res = almacenarNota("Nota nueva", notaNueva);
        }

        return res;
    }

    public void borrarDatosAlumnos() {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        Query consulta = baseDatos.query();
        consulta.constrain(Alumno.class);
        try {
            ObjectSet resultado = consulta.execute();
            if (resultado.isEmpty()) {
                System.out.println("no ha datos de alumnos que borrar");
            } else {
                while (resultado.hasNext()) {

                    baseDatos.delete(resultado.next());
                }
                System.out.println("ok");
            }

        } catch (Exception ex) {
            System.out.println("error: " + ex);
        } finally {
            baseDatos.close();
        }
    }

    public void borrarDatosAsignaturas() {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        Query consulta = baseDatos.query();
        consulta.constrain(Asignatura.class);
        try {
            ObjectSet resultado = consulta.execute();
            if (resultado.isEmpty()) {
                System.out.println("no ha datos de asignaturas que borrar");
            } else {
                while (resultado.hasNext()) {

                    baseDatos.delete(resultado.next());
                }
                System.out.println("ok");
            }

        } catch (Exception ex) {
            System.out.println("error: " + ex);
        } finally {
            baseDatos.close();
        }
    }

    public void borrarDatosNotas() {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        Query consulta = baseDatos.query();
        consulta.constrain(Nota.class);
        try {
            ObjectSet resultado = consulta.execute();
            if (resultado.isEmpty()) {
                System.out.println("no ha datosde notas que borrar");
            } else {
                while (resultado.hasNext()) {

                    baseDatos.delete(resultado.next());
                }
                System.out.println("ok");
            }

        } catch (Exception ex) {
            System.out.println("error: " + ex);
        } finally {
            baseDatos.close();
        }
    }

    public String borrarDatosAsignaturasId(String idS) {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "colegio.db4o");
        Query consulta = baseDatos.query();
        consulta.constrain(Asignatura.class);
        int id = Integer.valueOf(idS);
        String res = "";
        try {
            ObjectSet resultado = consulta.execute();
            if (resultado.isEmpty()) {
                res = "no ha datos de asignaturas que borrar";
            } else {
                while (resultado.hasNext()) {
                    Asignatura aaa = new Asignatura();
                    aaa = (Asignatura) resultado.next();
                    if (aaa.getCodigo() == id) {
                        baseDatos.delete(resultado.next());
                        res = "asignatura borrada";
                    }
                }
                System.out.println("ok");
            }

        } catch (Exception ex) {
            res = "error: " + ex;
        } finally {
            baseDatos.close();
        }

        return res;
    }

}
