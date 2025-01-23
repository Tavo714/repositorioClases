const passwordInput = document.getElementById("password");
        const ojo = document.getElementById("ojo");
        const ojoTachado = document.getElementById("ojo-tachado");

        ojo.addEventListener("click", function () {
            // Cambiar el tipo de input a "text" para mostrar la contraseña
            if (passwordInput.type === "password") {
                passwordInput.type = "text";
                ojo.style.display = "none";  // Oculta el ícono de ojo normal
                ojoTachado.style.display = "inline";  // Muestra el ícono de ojo tachado
            }
        });

        ojoTachado.addEventListener("click", function () {
            // Cambiar el tipo de input a "password" para ocultar la contraseña
            if (passwordInput.type === "text") {
                passwordInput.type = "password";
                ojoTachado.style.display = "none";  // Oculta el ícono de ojo tachado
                ojo.style.display = "inline";  // Muestra el ícono de ojo normal
            }
        });