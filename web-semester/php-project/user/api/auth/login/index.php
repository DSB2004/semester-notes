<?php
session_start();
header("Content-Type: text/xml");

// Check if the request method is POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    echo '<?xml version="1.0" encoding="UTF-8"?>';
    echo "<response>";

    // Get user input
    $username = $_POST['username'];
    $password = $_POST['password'];

    if (!$username || !$password) {
        http_response_code(400);
        echo "<status>failed</status>";
        echo "<message>Username and Password are required</message>";
        echo "</response>";
        return;
    }

    // Establish a connection to the database
    $conn = new mysqli("localhost", "root", "", "mysql");

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // Prepare the SQL query to check if the username exists
    $stmt = $conn->prepare("SELECT * FROM users WHERE username = ?");
    $stmt->bind_param("s", $username);
    $stmt->execute();
    $result = $stmt->get_result();
    
    // Check if user exists
    $user = $result->fetch_assoc();

    if ($user) {
        // Check if password is correct
        if (password_verify($password, $user['password'])) {
            // Set session variables
            $_SESSION["username"] = $user["username"];
            $_SESSION["email"] = $user["email"];
            
            // Optionally, set cookies
            setcookie("username", $user["username"], time() + 24 * 60 * 60, "/");
            setcookie("email", $user["email"], time() + 24 * 60 * 60, "/");

            // Return success response
            echo "<status>success</status>";
            echo "<message>Account Found and Password Verified</message>";
            echo "<user>";
            echo "<username>" . htmlspecialchars($user['username']) . "</username>";
            echo "<email>" . htmlspecialchars($user['email']) . "</email>";
            echo "</user>";
        } else {
            // Invalid password
            http_response_code(400);
            echo "<status>failed</status>";
            echo "<message>Invalid password</message>";
        }
    } else {
        // User not found
        http_response_code(400);
        echo "<status>failed</status>";
        echo "<message>User not found</message>";
    }

    echo "</response>";
} else {
    // Method Not Allowed
    http_response_code(405);
    echo '<?xml version="1.0" encoding="UTF-8"?>';
    echo "<response>";
    echo "<status>failed</status>";
    echo "<message>" . $_SERVER["REQUEST_METHOD"] . " Method Not Allowed for " . $_SERVER["REQUEST_URI"] . "</message>";
    echo "</response>";
    return;
}
?>
