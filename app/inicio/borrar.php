<?php
// Configuración de la conexión a la base de datos
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "inicio";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar la conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Recibir datos de la aplicación Android
$user = $_POST['user'];
$password = $_POST['password'];

// Verificar si el usuario existe antes de intentar eliminarlo
$sql = "SELECT * FROM usuarios WHERE user = '$user' AND password = '$password'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Usuario encontrado, proceder a eliminarlo
    $deleteSql = "DELETE FROM usuarios WHERE user = '$user' AND password = '$password';";

    if ($conn->query($deleteSql) === TRUE) {
        echo "Datos borrados correctamente";
    } else {
        echo "Error al borrar los datos: " . $conn->error;
    }
} else {
    // Usuario no encontrado, devolver un mensaje correspondiente
    echo "Usuario no encontrado para eliminar";
}

// Cerrar la conexión
$conn->close();
?>
