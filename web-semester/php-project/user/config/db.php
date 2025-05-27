<?php
function getConnection()   {
    $conn=new mysqli("localhost","root","","mysql");
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    return $conn;
}
?>