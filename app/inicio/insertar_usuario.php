<?php
// Configuración de la conexión a la base de datos
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "inicio";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

$user = $_POST['user'];
$pass = $_POST['password'];


// Verificar si el usuario existe
$sql = "SELECT * FROM usuarios WHERE user = '$user' AND password = '$pass'";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Usuario encontrado, enviar mensaje de que ya está registrado
    echo "Bienvenido";
} else {
    // Usuario no encontrado, puedes registrar aquí si es necesario
    echo "Credenciales erroneas";
}

// Cerrar la conexión
$conn->close();

?>