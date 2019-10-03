for $ALUMNO in  collection("/Alumnos")//alumno
let $MATRICULA:= collection("/Matriculas")/matricula[codalum=$ALUMNO/@codalum]
return 
<estadistica>
	<codalum>{data($ALUMNO/@codalum)}</codalum>
	<nombre>{data($ALUMNO/nombre)}</nombre>
	<notamedia>{avg($MATRICULA/notaasig)}</notamedia>
	<numeroasig>{count($MATRICULA/codasig)}</numeroasig>
</estadistica>