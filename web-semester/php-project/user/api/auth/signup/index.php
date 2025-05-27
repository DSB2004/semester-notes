<?php 
header("Content-Type: text/xml");
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Collect form data
    $username = $_POST["username"];
    $email = $_POST["email"];
    $password = $_POST["password"];  

    // Validate required fields
    if (!$username || !$email || !$password) {
        http_response_code(400);
        echo '<?xml version="1.0" encoding="UTF-8"?>';
        echo "<response>";
        echo "<status>failed</status>";
        echo "<message>Username, Email, Password are required</message>";
        echo "</response>";
        exit;
    }

    // Hash the password
    $hashedPassword = password_hash($password, PASSWORD_DEFAULT);

    // Database connection
    $conn = new mysqli("localhost", "root", "", "mysql");

    // Check for database connection error
    if ($conn->connect_error) {
        http_response_code(500);
        echo '<?xml version="1.0" encoding="UTF-8"?>';
        echo "<response>";
        echo "<status>failed</status>";
        echo "<message>Database connection failed: " . $conn->connect_error . "</message>";
        echo "</response>";
        exit;
    }

    // Prepare the SQL statement
    $stmt = $conn->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");

    // Check if prepare is successful
    if (!$stmt) {
        http_response_code(500);
        echo '<?xml version="1.0" encoding="UTF-8"?>';
        echo "<response>";
        echo "<status>failed</status>";
        echo "<message>Failed to prepare the SQL query</message>";
        echo "</response>";
        exit;
    }

    // Bind parameters to the SQL query
    $stmt->bind_param("sss", $username, $email, $hashedPassword);

    // Attempt to execute the query
    try {
        if ($stmt->execute()) {
            // Set cookies after successful account creation
            setcookie("username", $username, time() + 24 * 60 * 60, "/");  
            setcookie("email", $email, time() + 24 * 60 * 60, "/");    

            http_response_code(200);
            echo '<?xml version="1.0" encoding="UTF-8"?>';
            echo "<response>";
            echo "<status>success</status>";
            echo "<message>Account created successfully</message>";
            echo "</response>";
        } else {
            http_response_code(400);
            echo '<?xml version="1.0" encoding="UTF-8"?>';
            echo "<response>";
            echo "<status>failed</status>";
            echo "<message>Failed to create account</message>";
            echo "</response>";
        }
    } catch (mysqli_sql_exception $e) {
        // Handle specific errors
        if (str_contains($e->getMessage(), 'Duplicate entry')) {
            http_response_code(400);
            echo '<?xml version="1.0" encoding="UTF-8"?>';
            echo "<response>";
            echo "<status>failed</status>";
            echo "<message>Username or Email already exists</message>";
            echo "</response>";
        } else {
            http_response_code(500);
            echo '<?xml version="1.0" encoding="UTF-8"?>';
            echo "<response>";
            echo "<status>failed</status>";
            echo "<message>Database error occurred: " . $e->getMessage() . "</message>";
            echo "</response>";
        }
    }
    
    // Close the statement and connection
    $stmt->close();
    $conn->close();
}
?>
