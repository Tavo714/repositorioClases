<?php
session_start();
$_SESSION['usuario']="";
$_SESSION['password']="";
header("Location:./login/Login.php");
