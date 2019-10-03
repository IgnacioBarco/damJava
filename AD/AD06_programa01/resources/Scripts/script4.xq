for $ALUMNO in collection("/Alumnos")//alumno
let $MATRICULA:= collection("/Matriculas")/matricula[codalum=$ALUMNO/@codalum]
let $ASIG:=  collection("/Asignaturas")//asignatura[@codasig = $MATRICULA/codasig]
return 
if($ALUMNO/poblacion = 'Talavera') then( 
<alumnostipoa>
	<codalum>{data($ALUMNO/@codalum)}</codalum>
	<alumno>{data($ALUMNO/nombre)}</alumno>
	<asignaturasA>{data($ASIG/nombreasig)}</asignaturasA>	
</alumnostipoa>
)else()