<?php
session_start();
if (isset($_SESSION['usuario']) && $_SESSION['usuario'] != "") {
    header("Location:../menu/menu.php");
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/4f789d7d62.js" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="fonts.css"/>
    <link rel="icon" href="iconoDragon.png" type="icon/png">
    
</head>
<body>
    <main class="login">
        <section class="login__contenedor">
                <form class="login__form" method="POST">
                    <h2 class="login__titulo">Acceder al Sistema</h2>
                    <div class="login__formgroup">
                        <label class="login__label">
                            <i class="fa-solid fa-envelope"></i>
                            <input class="login__input" type="text" name="usuario" id="email" placeholder="joe@gmail.com" required >
                            <span>Usuario</span>
                        </label>
                    </div>
                    <div class="login__formgroup">
                        <label class="login__label">
                            <i class="fa-solid fa-lock"></i>
                            <input class="login__input" type="password" name="password" id="password" required >
                            <i id="ojo" class="fa-regular fa-eye"></i>
                            <i id="ojo-tachado" class="fa-regular fa-eye-slash"></i>
                            <span>Password</span>
                        </label>
                    </div>
                    <p>
                        <label for="recordar">
                        <input class="login__input" type="checkbox" id="recordar">
                        Recordar
                        </label>
                        
                        <a href="#" class="login__input input--link">¿Olvido su contraseña?</a>
                    </p>
                    
                    <button class="login__boton boton--acceder" type='submit' name= 'btnAceptar'>Acceder</button>
                    <p>
                        ¿No te has registrado? <a class="login__input input--link" href="#">Registrate</a>
                    </p>
                </form>
        </section>
    </main>
    <script src="script.js"></script>
    
</body>
</html>

<?php
if(isset($_POST["btnAceptar"])){
    $usuario =  $_POST["usuario"];
    $password =  $_POST["password"];
    $contenido = file_get_contents("http://localhost:8070/validar/{$usuario}/{$password}");
    $reg = json_decode($contenido, true);
    if(empty($reg)){
        echo "<center> Error de usuario-pass</center>";
    }
    else{
        session_start();
        $_SESSION['usuario'] = $usuario;
        $_SESSION['password'] = $password;
        header("Location: ../menu/menu.php");
        exit();
    }
}