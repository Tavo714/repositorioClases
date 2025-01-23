<?php
session_start();
if ($_SESSION['usuario']==""){
	header("Location:../login/Login.php");
	return;
}
else{
	$usuario=$_SESSION['usuario'];
	$clave=$_SESSION['password'];
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="icon" href="iconoDragon.png" type="icon/png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Menu</title>
    <script type="text/javascript">
        function ir(dato) {
            var marco = document.getElementById("marco");
            if (dato == 1)
                marco.src = "../ListarMatriculas.php";
            if (dato == 2)
                marco.src = "../RegistrarEstudiante.php";
            if (dato == 3)
                marco.src = "../RegistrarMatricula.php";
            if (dato == 4)
                window.location.href="../logout.php";
        }
    </script>
    <style>
        
        body {
            background: url(fondo-estrellado.jpg) no-repeat;
            background-size: cover;
            background-position: center;
        }
        .navbar {
            background-color:rgb(16, 41, 182);
            color: white;
            margin-bottom: 5%;
        }
        .iframe-container {
            border: 1px solid #dee2e6;
            background-color: #fff;
        }
    </style>
    
</head>
<body>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><img src="iconoDragon.png" alt="icono" width="30"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <button class="btn btn-outline-primary me-2" onclick="ir(1)">ListarMatriculas</button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-secondary me-2" onclick="ir(2)">RegistrarEstudiante</button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-outline-success me-2" onclick="ir(3)">RegistrarMatricula</button>
                    </li>
                </ul>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <span class="me-3">BIENVENIDO USUARIO [<?php echo $usuario ?>]</span>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-danger" onclick="ir(4)">Cerrar Sesión</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Iframe Content -->
    <div class="container iframe-container p-3">
        <iframe id="marco" src="" width="100%" height="500" frameborder="0"></iframe>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>