for $ASIGNATURA in collection("/Asignaturas")/asignatura
let $MAT:= collection("/Matriculas")/matricula[codasig=$ASIGNATURA/@codasig]
let $ALUM:=count($MAT)
return 
if($ALUM=0) then (delete node $ASIGNATURA/nombreasig ) else()