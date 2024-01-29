<?php
// Configuración de la conexión a la base de datos
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "inicio";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Recibir datos de la aplicación Android
$user = $_POST['user'];
$oldPassword =$_POST["password"];
$newPassword = $_POST['new_password'];

//$user = "Jorge";
//$newPassword = "nueva_contraseña";

// Verificar si el usuario existe
$sqlCheckUser = "SELECT * FROM usuarios WHERE user = '$user' and password = '$oldPassword'";
$resultCheckUser = $conn->query($sqlCheckUser);

if ($resultCheckUser->num_rows > 0) {
    // Usuario encontrado, actualizar la contraseña
    $sqlUpdatePassword = "UPDATE usuarios SET password = '$newPassword' WHERE user = '$user'";

    if ($conn->query($sqlUpdatePassword) === TRUE) {
        echo "Contraseña modificada correctamente";
    } else {
        echo "Error al modificar la contraseña: " . $conn->error;
    }
} else {
    // Usuario no encontrado, devolver un mensaje correspondiente
    echo "Usuario no existe, comprueba credenciales";
}

// Cerrar la conexión
$conn->close();
?>
