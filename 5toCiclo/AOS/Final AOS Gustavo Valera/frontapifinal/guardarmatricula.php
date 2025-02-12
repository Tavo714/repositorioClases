<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Matrícula</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Gris claro */
        }
        .card-header {
            background-color: rgb(38, 162, 67); 
            color: white;
        }
    </style>
</head>
<body>
    <?php
    // Conexión a la base de datos
    $conexion = new mysqli("localhost", "root", "", "academico");

    if ($conexion->connect_error) {
        die("Error al conectar a la base de datos: " . $conexion->connect_error);
    }

    // Consultar escuelas
    $escuelas = $conexion->query("SELECT codesc, desesc FROM escuela");

    // Consultar trabajadores
    $trabajadores = $conexion->query("SELECT codtra, CONCAT(nomtra, ' ', apetra) AS nombre FROM trabajador");

    // Consultar periodos
    $periodos = $conexion->query("SELECT codper, desper FROM periodo");
    ?>
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header text-center">
                <h4>Registrar Matrícula</h4>
            </div>
            <div class="card-body">
                <form name="frmguardarmatricula" method="post">
                    <div class="mb-3">
                        <label for="fecmat" class="form-label">Fecha de Matrícula</label>
                        <input type="date" name="fecmat" id="fecmat" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="codesc" class="form-label">Escuela</label>
                        <select name="codesc" id="codesc" class="form-select" required>
                            <option value="">Seleccione una escuela</option>
                            <?php while ($row = $escuelas->fetch_assoc()): ?>
                                <option value="<?php echo $row['codesc']; ?>"><?php echo $row['desesc']; ?></option>
                            <?php endwhile; ?>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="codtra" class="form-label">Trabajador</label>
                        <select name="codtra" id="codtra" class="form-select" required>
                            <option value="">Seleccione un trabajador</option>
                            <?php while ($row = $trabajadores->fetch_assoc()): ?>
                                <option value="<?php echo $row['codtra']; ?>"><?php echo $row['nombre']; ?></option>
                            <?php endwhile; ?>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="codest" class="form-label">Código del Estudiante</label>
                        <input type="number" name="codest" id="codest" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="codper" class="form-label">Periodo</label>
                        <select name="codper" id="codper" class="form-select" required>
                            <option value="">Seleccione un periodo</option>
                            <?php while ($row = $periodos->fetch_assoc()): ?>
                                <option value="<?php echo $row['codper']; ?>"><?php echo $row['desper']; ?></option>
                            <?php endwhile; ?>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="cicmat" class="form-label">Ciclo</label>
                        <input type="number" name="cicmat" id="cicmat" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="turmat" class="form-label">Turno</label>
                        <select name="turmat" id="turmat" class="form-select" required>
                            <option value="M">Mañana</option>
                            <option value="T">Tarde</option>
                            <option value="N">Noche</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="impmat" class="form-label">Importe</label>
                        <input type="number" step="0.01" name="impmat" id="impmat" class="form-control" required>
                    </div>
                    <div class="d-grid">
                        <button type="submit" name="btnguardar" class="btn btn-success">Registrar Matrícula</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <?php
    if (isset($_POST["btnguardar"])) {
        // Capturar datos del formulario
        $fecmat = $_POST["fecmat"];
        $codesc = intval($_POST["codesc"]);
        $codtra = intval($_POST["codtra"]);
        $codest = intval($_POST["codest"]);
        $codper = $_POST["codper"];
        $cicmat = intval($_POST["cicmat"]);
        $turmat = $_POST["turmat"];
        $impmat = floatval($_POST["impmat"]);

        // Enviar datos
        $datos = json_encode([
            "fecmat" => $fecmat,
            "codesc" => $codesc,
            "codtra" => $codtra,
            "codest" => $codest,
            "codper" => $codper,
            "cicmat" => $cicmat,
            "turmat" => $turmat,
            "impmat" => $impmat
        ]);

        $url = "http://localhost:8077/registromatricula";
        $ch = curl_init($url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, ['Content-Type: application/json']);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $datos);
        $respuesta = curl_exec($ch);
        curl_close($ch);

        if ($respuesta) {
            echo "<div class='alert alert-success text-center mt-3'>Matrícula registrada correctamente!</div>";
        } else {
            echo "<div class='alert alert-danger text-center mt-3'>Error al registrar matrícula.</div>";
        }
    }
    ?>
</body>
</html>
