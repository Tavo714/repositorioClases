<?php
session_start();
if ($_SESSION['nombre'] == "") {
    header("Location:login.php");
    return;
} else {
    $nombreTrabajador = $_SESSION['nombre']; // Nombre del trabajador
    $usuario = $_SESSION['usuario'];
    $rol = $_SESSION['rol'];
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú Principal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color:rgb(207, 222, 237); /* Fondo gris claro */
        }
        /* Navbar personalizado */
        .custom-navbar {
            background-color: #155724; /* Verde oscuro */
            box-shadow: 0 4px 6px rgba(54, 51, 51, 0.1); /* Sombra */
        }
        .dropdown-menu-dark {
            background-color: #155724; /* Verde oscuro */
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg custom-navbar">
        <div class="container-fluid">
            <!-- Menú desplegable (icono de hamburguesa) -->
            <div class="dropdown me-2">
                <button class="btn btn-outline-light" type="button" id="menuDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    <span class="navbar-toggler-icon"></span> <!-- Ícono hamburguesa -->
                </button>
                <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="menuDropdown">
                    <li><a class="dropdown-item text-white" href="#" onclick="ir(1)">Estudiante</a></li>
                    <li><a class="dropdown-item text-white" href="#" onclick="ir(2)">Matrícula</a></li>
                    <li><a class="dropdown-item text-white" href="#" onclick="ir(3)">Consultar Matrícula</a></li>
                    <li><a class="dropdown-item text-white" href="#" onclick="ir(4)">Listar Matrículas</a></li>
                </ul>
            </div>
            <!-- Título -->
            <a class="navbar-brand text-white" href="#">Menú Principal</a>
            <!-- Saludo y Cerrar Sesión -->
            <div class="ms-auto d-flex align-items-center">
                <span class="navbar-text text-white me-3">
                    Bienvenido, <b><?php echo $nombreTrabajador; ?></b>
                </span>
                <a href="logout.php" class="btn btn-outline-light">Cerrar Sesión</a>
            </div>
        </div>
    </nav>

    <!-- Contenido Principal -->
    <div class="container mt-4">
        <iframe id="marco" src="" width="100%" height="500" frameborder="0"></iframe>
    </div>

    <script>
        function ir(dato) {
            var marco = document.getElementById("marco");
            if (dato == 1) {
                marco.src = "guardarestudiante.php";
            }
            if (dato == 2) {
                marco.src = "guardarmatricula.php";
            }
            if (dato == 3) {
                marco.src = "consultarmatricula.php";
            }
            if (dato == 4) {
                marco.src = "listarmatriculas.php";
            }
        }
    </script>

    <!-- Scripts de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
