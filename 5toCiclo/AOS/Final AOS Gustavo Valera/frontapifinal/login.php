<?php
if (isset($_POST["btnaceptar"])) {
    $usuario = $_POST["txtus"];
    $clave = $_POST["txtpa"];
    $contenido = file_get_contents("http://localhost:8077/validar/" . $usuario . "/" . $clave);
    $reg = json_decode($contenido, true);
    if (empty($reg)) {
        echo "<div class='alert alert-danger text-center'>La identificación del usuario no es válida...!!!</div>";
    } else {
        session_start();
        $_SESSION['nombre'] = $reg[0]["nomtra"]; // Nombre del trabajador
        $_SESSION['usuario'] = $usuario;         // Usuario
        $_SESSION['rol'] = $reg[0]["rolus"];     // Rol del trabajador

        header("Location:menu.php");
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Gris claro */
        }
        .card-header {
            background-color: rgb(38, 162, 67); /* Azul marino */
            color: white;
        }
        .btn-primary {
            background-color: rgb(38, 162, 67); /* Azul marino */
        }
        .btn-primary:hover {
            background-color: rgb(3, 248, 60); /* Azul más claro */
        }
    </style>
    <script>
        function desordenar(array) {
            array = array.sort(function () {
                return Math.random() - 0.5;
            });
            return array;
        }
        function numeros() {
            var numeros = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"];
            var numerosdesordenados = desordenar(numeros);
            document.getElementById("bt1").value = numerosdesordenados[0];
            document.getElementById("bt2").value = numerosdesordenados[1];
            document.getElementById("bt3").value = numerosdesordenados[2];
            document.getElementById("bt4").value = numerosdesordenados[3];
            document.getElementById("bt5").value = numerosdesordenados[4];
            document.getElementById("bt6").value = numerosdesordenados[5];
            document.getElementById("bt7").value = numerosdesordenados[6];
            document.getElementById("bt8").value = numerosdesordenados[7];
            document.getElementById("bt9").value = numerosdesordenados[8];
            document.getElementById("bt0").value = numerosdesordenados[9];
        }
        function editar(dato) {
            var cadena = document.getElementById("txtpa").value;
            if (dato == -1 && cadena.length > 0) {
                document.getElementById("txtpa").value = cadena.substr(0, cadena.length - 1);
            } else if (dato > -1) {
                document.getElementById("txtpa").value = document.getElementById("txtpa").value + dato;
            }
        }
    </script>
</head>
<body onload="numeros()">
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card shadow" style="width: 400px;">
            <div class="card-header text-center">
                <h4>Iniciar Sesión</h4>
            </div>
            <div class="card-body">
                <form name="frmsesion" action="login.php" method="post">
                    <!-- Campo Usuario -->
                    <div class="mb-3">
                        <label for="txtus" class="form-label">Usuario:</label>
                        <input type="text" name="txtus" id="txtus" maxlength="20" class="form-control" required autocomplete="off">
                    </div>
                    <!-- Campo Contraseña -->
                    <div class="mb-3">
                        <label for="txtpa" class="form-label">Contraseña:</label>
                        <input type="password" name="txtpa" id="txtpa" maxlength="15" class="form-control" required autocomplete="off" readonly>
                    </div>
                    <!-- Teclado Numérico -->
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt1" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt2" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt3" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt4" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt5" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt6" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt7" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt8" onclick="editar(this.value)"></div>
                            <div class="col-4 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt9" onclick="editar(this.value)"></div>
                            <div class="col-6 mb-2"><input type="button" class="btn btn-secondary w-100" id="bt0" onclick="editar(this.value)"></div>
                            <div class="col-6 mb-2"><input type="button" class="btn btn-danger w-100" value="Borrar" onclick="editar(-1)"></div>
                        </div>
                    </div>
                    <!-- Botón Enviar -->
                    <div class="d-grid">
                        <button type="submit" name="btnaceptar" class="btn btn-primary">Aceptar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
