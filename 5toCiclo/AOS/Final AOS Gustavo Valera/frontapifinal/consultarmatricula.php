<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultar Matrícula</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Gris claro */
        }
        .card-header {
            background-color: rgb(38, 162, 67); 
            color: white;
        }
        .table th {
            background-color: rgb(38, 162, 67); /* Azul marino */
            color: white;
        }
    </style>    
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header text-center">
                <h4>Consultar Matrícula</h4>
            </div>
            <div class="card-body">
                <form method="post" action="consultarmatricula.php" class="mb-4">
                    <div class="mb-3">
                        <label for="codmat" class="form-label">Código de Matrícula</label>
                        <input type="number" name="codmat" id="codmat" class="form-control" required>
                    </div>
                    <div class="d-grid">
                        <button type="submit" name="btnbuscar" class="btn btn-success">Buscar Matrícula</button>
                    </div>
                </form>

                <?php
                if (isset($_POST["btnbuscar"])) {
                    // Conexión a la base de datos
                    $conexion = new mysqli("localhost", "root", "", "academico");

                    if ($conexion->connect_error) {
                        die("<div class='alert alert-danger text-center mt-3'>Error al conectar con la base de datos.</div>");
                    }

                    // Capturar el código ingresado
                    $codmat = intval($_POST["codmat"]);

                    // URL para la consulta
                    $url = "http://localhost:8077/buscarmatricula/" . $codmat;

                    // Realizar la solicitud GET
                    $respuesta = file_get_contents($url);
                    $datos = json_decode($respuesta, true);

                    if ($datos && count($datos) > 0) {
                        echo "<table class='table table-striped table-bordered mt-3'>";
                        echo "<thead><tr>
                                <th>Código</th>
                                <th>Fecha</th>
                                <th>Escuela</th>
                                <th>Trabajador</th>
                                <th>Estudiante</th>
                                <th>Periodo</th>
                                <th>Ciclo</th>
                                <th>Turno</th>
                                <th>Importe</th>
                              </tr></thead>";
                        echo "<tbody>";

                        foreach ($datos as $matricula) {
                            // Obtener nombres adicionales desde la base de datos
                            $escuelaQuery = $conexion->query("SELECT desesc FROM escuela WHERE codesc = {$matricula['codesc']}");
                            $trabajadorQuery = $conexion->query("SELECT CONCAT(nomtra, ' ', apetra) AS nombre FROM trabajador WHERE codtra = {$matricula['codtra']}");

                            $escuela = $escuelaQuery->fetch_assoc()['desesc'];
                            $trabajador = $trabajadorQuery->fetch_assoc()['nombre'];

                            echo "<tr>
                                    <td>{$matricula['codmat']}</td>
                                    <td>{$matricula['fecmat']}</td>
                                    <td>{$escuela}</td>
                                    <td>{$trabajador}</td>
                                    <td>{$matricula['codest']}</td>
                                    <td>{$matricula['codper']}</td>
                                    <td>{$matricula['cicmat']}</td>
                                    <td>{$matricula['turmat']}</td>
                                    <td>{$matricula['impmat']}</td>
                                  </tr>";
                        }

                        echo "</tbody></table>";
                    } else {
                        echo "<div class='alert alert-warning text-center mt-3'>No se encontró ninguna matrícula con el código ingresado.</div>";
                    }

                    $conexion->close();
                }
                ?>
            </div>
        </div>
    </div>
</body>
</html>
