<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Estudiante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Gris claro */
        }
        .card-header {
            background-color:rgb(38, 162, 67); 
            color: white;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header text-center">
                <h4>Registrar Estudiante</h4>
            </div>
            <div class="card-body">
                <form name="frmguardarestudiante" method="post" action="guardarestudiante.php">
                    <div class="mb-3">
                        <label for="dniest" class="form-label">DNI del Estudiante</label>
                        <input type="text" name="dniest" id="dniest" maxlength="8" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="apeest" class="form-label">Apellidos del Estudiante</label>
                        <input type="text" name="apeest" id="apeest" maxlength="50" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="nomest" class="form-label">Nombres del Estudiante</label>
                        <input type="text" name="nomest" id="nomest" maxlength="50" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="direst" class="form-label">Dirección</label>
                        <input type="text" name="direst" id="direst" maxlength="100" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="telest" class="form-label">Teléfono</label>
                        <input type="text" name="telest" id="telest" maxlength="9" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="corest" class="form-label">Correo Electrónico</label>
                        <input type="email" name="corest" id="corest" maxlength="50" class="form-control">
                    </div>
                    <div class="d-grid">
                        <button type="submit" name="btnguardar" class="btn btn-success">Registrar Estudiante</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <?php
    // Función para enviar datos al servidor
    function enviar($url, $datos) {
        $curl = curl_init();
        $tiempo = 300;
        curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
        curl_setopt($curl, CURLOPT_URL, $url);
        curl_setopt($curl, CURLOPT_POST, true);
        curl_setopt($curl, CURLOPT_POSTFIELDS, $datos);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($curl, CURLOPT_CONNECTTIMEOUT, $tiempo);
        $resp = curl_exec($curl);
        curl_close($curl);
        return $resp;
    }

    if (isset($_POST["btnguardar"])) {
        // Lectura de las cajas de texto
        $dniest = $_POST["dniest"];
        $apeest = $_POST["apeest"];
        $nomest = $_POST["nomest"];
        $direst = $_POST["direst"];
        $telest = $_POST["telest"] ?? null;
        $corest = $_POST["corest"] ?? null;

        // URL del servicio
        $url = "http://localhost:8077/registroestudiante";

        // Datos del estudiante
        $datos = [
            "dniest" => $dniest,
            "apeest" => $apeest,
            "nomest" => $nomest,
            "direst" => $direst,
            "telest" => $telest,
            "corest" => $corest
        ];

        // Convertir a JSON
        $datos = json_encode($datos);

        // Enviar datos al servidor
        $respuesta = enviar($url, $datos);

        // Mostrar respuesta al usuario
        if ($respuesta == "") {
            echo "<div class='alert alert-danger text-center mt-3'>Error al guardar el registro del estudiante...!!!</div>";
        } else {
            echo "<div class='alert alert-success text-center mt-3'>Estudiante registrado correctamente...!!!</div>";
        }
    }
    ?>
</body>
</html>
