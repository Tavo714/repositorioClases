<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultar Matrículas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Gris claro */
        }
        .card-header {
            background-color: rgb(38, 162, 67); /* Verde oscuro */
            color: white;
        }
        .table th {
            background-color: rgb(38, 162, 67);
            color: white;
        }
    </style>    
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header text-center">
                <h4>Matrículas</h4>
            </div>
            <div class="card-body">
                <form method="post" action="listarmatriculas.php" class="mb-4">
                    <!-- Periodo -->
                    <div class="mb-3">
                        <label for="codper" class="form-label">Periodo</label>
                        <select name="codper" id="codper" class="form-select" required>
                            <?php
                            $conexion = new mysqli("localhost", "root", "", "academico");
                            $periodos = $conexion->query("SELECT codper, desper FROM periodo");
                            while ($row = $periodos->fetch_assoc()) {
                                echo "<option value='{$row['codper']}'>{$row['desper']}</option>";
                            }
                            ?>
                        </select>
                    </div>
                    <!-- Escuela -->
                    <div class="mb-3">
                        <label for="codesc" class="form-label">Escuela</label>
                        <select name="codesc" id="codesc" class="form-select" required>
                            <?php
                            $escuelas = $conexion->query("SELECT codesc, desesc FROM escuela");
                            while ($row = $escuelas->fetch_assoc()) {
                                echo "<option value='{$row['codesc']}'>{$row['desesc']}</option>";
                            }
                            ?>
                        </select>
                    </div>
                    <!-- Ciclo -->
                    <div class="mb-3">
                        <label for="cicmat" class="form-label">Ciclo</label>
                        <select name="cicmat" id="cicmat" class="form-select" required>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                    </div>
                    <!-- Turno -->
                    <div class="mb-3">
                        <label for="turmat" class="form-label">Turno</label>
                        <select name="turmat" id="turmat" class="form-select" required>
                            <option value="M">Mañana</option>
                            <option value="T">Tarde</option>
                            <option value="N">Noche</option>
                        </select>
                    </div>
                    <!-- Botón Buscar -->
                    <div class="d-grid">
                        <button type="submit" name="btnbuscar" class="btn btn-success">Buscar Matrículas</button>
                    </div>
                </form>

                <?php
                if (isset($_POST["btnbuscar"])) {
                    // Capturar parámetros
                    $codper = $_POST["codper"];
                    $codesc = intval($_POST["codesc"]);
                    $cicmat = intval($_POST["cicmat"]);
                    $turmat = $_POST["turmat"];

                    // Validar parámetros
                    if (!empty($codper) && !empty($codesc) && !empty($cicmat) && !empty($turmat)) {
                        // Construir la URL
                        $url = "http://localhost:8077/filtrarmatricula/$codper/$codesc/$cicmat/$turmat";

                        // Consumir el endpoint
                        $respuesta = file_get_contents($url);
                        $datos = json_decode($respuesta, true);

                        if ($datos && count($datos) > 0) {
                            echo "<table class='table table-striped table-bordered mt-3'>";
                            echo "<thead><tr>
                                    <th>#</th>
                                    <th>Fecha</th>
                                    <th>Escuela</th>
                                    <th>Ciclo</th>
                                    <th>Turno</th>
                                    <th>Importe</th>
                                  </tr></thead>";
                            echo "<tbody>";

                            foreach ($datos as $matricula) {
                                // Obtener nombres desde la base de datos
                                $escuela = $conexion->query("SELECT desesc FROM escuela WHERE codesc = {$matricula['codesc']}")->fetch_assoc()['desesc'];

                                echo "<tr>
                                        <td>{$matricula['codmat']}</td>
                                        <td>{$matricula['fecmat']}</td>
                                        <td>{$escuela}</td>
                                        <td>{$matricula['cicmat']}</td>
                                        <td>{$matricula['turmat']}</td>
                                        <td>{$matricula['impmat']}</td>
                                      </tr>";
                            }

                            echo "</tbody></table>";
                        } else {
                            echo "<div class='alert alert-warning text-center mt-3'>No se encontraron matrículas.</div>";
                        }
                    } else {
                        echo "<div class='alert alert-danger text-center mt-3'>Por favor, complete todos los campos.</div>";
                    }

                    $conexion->close();
                }
                ?>
            </div>
        </div>
    </div>
</body>
</html>
