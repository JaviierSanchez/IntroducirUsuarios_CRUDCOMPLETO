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
$password = $_POST['password'];

//$user = "Jorge";
//$password = "9827364";

$sql = "SELECT * FROM usuarios WHERE user = '$user'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Usuario encontrado, devolver un mensaje correspondiente
    echo "Usuario ya existe";
} else {
    // Insertar datos en la tabla
    $sql = "INSERT INTO usuarios (user, password) VALUES ('$user', '$password')";

    if ($conn->query($sql) === TRUE) {
        echo "Datos insertados correctamente";
    } else {
        echo "Error al insertar datos: " . $conn->error;
    }
}

// Cerrar la conexión
$conn->close();
