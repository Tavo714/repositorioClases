<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Listar Matriculas</title>
</head>
<body>
    <fieldset>
        <legend>Formulario de Listado de Matriculas</legend>
        <form name="frmListarMatriculas" method="post" action="listarMatriculas.php">
            <label for="NumeroPeriodo">
                Numero Periodo:
                <input type="text" name="txtNumeroPeriodo" required autocomplete="off">
            </label><br><br>
            <label for="codigoEscuela">
                Codigo Escuela:
                <input type="number" name="txtCodigoEscuela" required autocomplete="off">
            </label><br><br>
            <label for="ciclo">
                Ciclo:
                <input type="number" name="txtCiclo" required autocomplete="off">
            </label><br><br>
            <label for="turno">
                Elige el Turno:
                <select name="turno" id="select" required>
                    <option value="">Seleccione</option>
                    <option value="M">Mañana</option>
                    <option value="T">Tarde</option>
                    <option value="N">Noche</option>
                </select>
            </label><br><br>
            <input type="submit" value="Listar Matriculas" name="btnListar">
        </form>
    </fieldset>
    <?php
if (isset($_POST["btnListar"])) {
        $NumeroPeriodo = urlencode($_POST["txtNumeroPeriodo"]);
        $CodigoEscuela = urlencode($_POST["txtCodigoEscuela"]);
        $Ciclo = urlencode($_POST["txtCiclo"]);
        $turno = urlencode($_POST["turno"]);

        $url = "http://localhost:8070/filtrar?NumeroPeriodo=$NumeroPeriodo&CodigoEscuela=$CodigoEscuela&Ciclo=$Ciclo&Turno=$turno";
    
        //obtener datos del servicio
        $res = file_get_contents($url);

        if ($res === false) {
            echo "<p>Error al conectar con el servidor. Por favor, inténtelo más tarde.</p>";
        } else {
            $reg = json_decode($res, true);

            if (!is_array($reg) || empty($reg)) {
                echo "<p>No se encontraron registros para los criterios proporcionados.</p>";
            } else {
                // Mostrar tabla si hay datos
                echo '<fieldset>';
                echo '<legend>Listado de Matriculas</legend>';
                echo '<table>';
                echo '<thead>';
                echo '<tr>';
                echo '<th>Numero Matricula</th>';
                echo '<th>Fecha</th>';
                echo '<th>Codigo Escuela</th>';
                echo '<th>Codigo Trabajador</th>';
                echo '<th>Codigo Estudiante</th>';
                echo '<th>Numero Periodo</th>';
                echo '<th>Ciclo</th>';
                echo '<th>Turno</th>';
                echo '<th>Importe</th>';
                echo '</tr>';
                echo '</thead>';
                echo '<tbody>';
                
                foreach ($reg as $valor) {
                    echo '<tr>';
                    echo "<td>{$valor['NumeroMatricula']}</td>";
                    echo "<td>{$valor['Fecha']}</td>";
                    echo "<td>{$valor['CodigoEscuela']}</td>";
                    echo "<td>{$valor['CodigoTrabajador']}</td>";
                    echo "<td>{$valor['CodigoEstudiante']}</td>";
                    echo "<td>{$valor['NumeroPeriodo']}</td>";
                    echo "<td>{$valor['Ciclo']}</td>";
                    echo "<td>{$valor['Turno']}</td>";
                    echo "<td>{$valor['Importe']}</td>";
                    echo '</tr>';
                }

                echo '</tbody>';
                echo '</table>';
                echo '</fieldset>';
            }
        }
    }
    ?>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>