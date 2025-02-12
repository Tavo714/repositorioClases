<?php
session_start();
$_SESSION['nombre']="";
$_SESSION['clave']="";
$_SESSION['rol']="";
header("Location:login.php");
?>
