for $ASIG in collection("/Asignaturas")/asignatura
let $CODASIG:= ($ASIG/@codasig)
let $MATRICULA:= collection("/Matriculas")/matricula[codasig=$CODASIG]
let $ALUMNO:=  collection("/Alumnos")/alumno[@codalum=$MATRICULA/codalum]
return 
<asignatura>
	<codasig>{data($CODASIG)}</codasig>
	<nombreasig>{data($ASIG/nombreasig)}</nombreasig>
	<alumnos>{$ALUMNO/nombre}</alumnos>
</asignatura>