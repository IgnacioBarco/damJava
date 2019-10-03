for $PRECIO in collection("/Asignaturas")/asignatura/precioasig
let $MAT:= collection("/Matriculas")/matricula[codasig=$PRECIO/@codasig]
let $ALUMNOS:=count($MAT)
return 
if ($ALUMNOS>=4) then (replace node $PRECIO with <precioasig>{10+data($PRECIO)})</precioasig> ) else()