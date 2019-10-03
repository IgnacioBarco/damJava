for $ASIG in collection("/Asignaturas")//asignatura
let $TIPO := $ASIG/tipoasig
group by $TIPO
return concat('Tipo: ', $TIPO, ', Numero asignaturas: ', count($ASIG))