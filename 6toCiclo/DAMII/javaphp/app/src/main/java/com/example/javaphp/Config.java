package com.example.javaphp;

public class Config {
    public static String getServerURL() {
        if (android.os.Build.PRODUCT.contains("sdk") || android.os.Build.PRODUCT.contains("emulator")) {
            return "http://10.0.2.2/DAMII_java_php_mysql/"; // Emulador
        } else {
            return "http://192.168.137.1/DAMII_java_php_mysql/"; // Dispositivo real
        }
    }
}

