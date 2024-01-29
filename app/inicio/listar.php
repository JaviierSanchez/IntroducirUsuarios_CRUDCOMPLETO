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

// Verificar si el usuario existe
$sql = "SELECT * FROM usuarios";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Mostrar los resultados de la consulta
    while ($row = $result->fetch_assoc()) {
        echo "ID: " . $row["id_usuarios"] . " - Usuario: " . $row["user"] . " - Contraseña: " . $row["password"]  . "<br>";
    }
} else {
    // No hay resultados
    echo "No hay usuarios en la base de datos.";
}

// Cerrar la conexión
$conn->close();
?>
