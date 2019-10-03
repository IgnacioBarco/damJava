for $ALUMNO in  collection("/Alumnos")//alumno
let $MATRICULA:= collection("/Matriculas")/matricula[codalum=$ALUMNO/@codalum]
let $NOTAMEDIA:= <notamedia>{avg($MATRICULA/notaasig)}</notamedia>
return insert node $NOTAMEDIA into $ALUMNO