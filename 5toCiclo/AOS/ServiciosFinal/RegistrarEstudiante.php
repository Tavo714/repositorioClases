<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="ccRegistrar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Insertar Estudiantes</title>
</head>
<body>
    <fieldset>
        <legend>Formulario de Estudiantes</legend>
        <form name= "frmEstudiantes" action="RegistrarEstudiante.php" method="POST">
            <div class="row mb-3">
                <div class="col">
                    <input type="text" class="form-control" placeholder="DNI" name="dni" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <input type="text" class="form-control" placeholder="Apellidos" name="apellidos" required>
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Nombres" name="nombres" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col">
                    <input type="text" class="form-control" placeholder="Direccion" name="direccion" required>
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Telefono" name="telefono" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-6">
                    <input type="email" class="form-control" placeholder="Correo electronico" name="correo" required>
                </div>
            </div>
            <div>
                <input  class = "btn btn-primary" type="submit" value="Agregar" name= "btnGuardar">
            </div>
        </form>
    </fieldset>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

<?php
function enviar($url, $datos){
    $curl = curl_init();
    $tiempo = 300;
    curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_POST, true);
    curl_setopt($curl, CURLOPT_POSTFIELDS, $datos);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($curl, CURLOPT_CONNECTTIMEOUT, $tiempo);
    $respuesta = curl_exec($curl);
    curl_close($curl);
    return $respuesta;
}
function calcularID() {
    $url = "http://localhost:8070/ultimoID";
    $contenido = file_get_contents($url);
    if ($contenido === false) {
        echo "<center>Error al conectar con el servidor.</center>";
        return "001";
    }
    $reg = json_decode($contenido, true);
    if (is_array($reg) && isset($reg[0]["max_id"])) {
        $codigo = (int)$reg[0]["max_id"] + 1;
        return "000{$codigo}";
    }
    echo "<center>Error al procesar los datos.</center>";
    return "001";
}

if(isset($_POST["btnGuardar"])){
    $codigo = calcularID();
    $dni = $_POST["dni"];
    $apellidos = $_POST["apellidos"];
    $nombres = $_POST["nombres"];
    $direccion = $_POST["direccion"];
    $telefono = $_POST["telefono"];
    $correo = $_POST["correo"];
    

    $url = "http://localhost:8070/addEstudiante";
    $datos = [
        "CodigoEstudiante" => $codigo,
        "DNI" => $dni,
        "Apellido" => $apellidos,
        "Nombre" => $nombres,
        "Direccion" => $direccion,
        "Telefono" => $telefono,
        "Correo" => $correo,
        
    ];
    $datos = json_encode($datos);
    $respuesta=enviar($url, $datos);
    if(is_null($respuesta) || $respuesta === ""){
        echo "<label>Datos no agregados..!</label>";
    }
    else{
         echo "<label>Datos registrados correctamente..!</label>";
    }
}
?>