<?php
// Set the content type to JSON
header('Content-Type: application/json');

// Get the request method (GET, POST, etc.)
$request_method = $_SERVER['REQUEST_METHOD'];

// Get the URL of the request
$request_url = $_SERVER['REQUEST_URI'];

// Initialize the response array
$response = [
    'request_method' => $request_method,
    'request_url' => $request_url,
];

// Check if the request is POST and if it has a JSON body
if ($request_method == 'POST' && !empty(file_get_contents('php://input'))) {
    $json_data = json_decode(file_get_contents('php://input'), true); // Decode JSON data into an array
    if ($json_data) {
        // Add the received JSON body to the response
        $response['json_body'] = $json_data;
    } else {
        $response['error'] = 'Invalid JSON format';
    }
}

echo json_encode($response);
?>
