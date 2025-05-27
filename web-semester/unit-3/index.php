<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHP Overview</title>
</head>
<body>

    <h1>PHP Overview</h1>
    <p>PHP (Hypertext Preprocessor) is a popular server-side scripting language especially suited for web development. PHP code is executed on the server, and the result is sent to the browser as plain HTML.</p>

    <h2>Basic Syntax</h2>
    <?php
        echo "Hello, World!<br/>";
    ?>

    <h2>Variables and Data Types</h2>
    <?php
        $name = "Alice";
        $age = 25;
        $is_student = true;
        echo "Name: $name <br/>";
        echo "Age: $age <br/>";
        echo "Is Student: " . ($is_student ? "Yes" : "No") . "<br/>";
    ?>

    <h2>Arrays and Loops</h2>
    <?php
        $fruits = ["Apple", "Banana", "Cherry"];
        echo "<ul>";
        foreach ($fruits as $fruit) {
            echo "<li>$fruit</li>";
        }
        echo "</ul>";
    ?>

    <h2>Conditional Statements</h2>
    <?php
        $score = 85;
        if ($score >= 90) {
            echo "Grade: A<br/>";
        } elseif ($score >= 75) {
            echo "Grade: B<br/>";
        } else {
            echo "Grade: C or below<br/>";
        }
    ?>

    <h2>Loops</h2>
    <p>While Loop Example:</p>
    <?php
        $i = 0;
        while ($i < 5) {
            echo "Counter: $i<br/>";
            $i++;
        }
    ?>

    <p>For Loop Example:</p>
    <?php
        for ($j = 0; $j < 5; $j++) {
            echo "Iteration: $j<br/>";
        }
    ?>

    <h2>Functions</h2>
    <?php
        function greet($person): string {
            return "Hello, $person!";
        }

        echo greet("John") . "<br/>";
        echo greet("Jane") . "<br/>";
    ?>

    <h2>Superglobals</h2>
    <p>PHP provides built-in superglobals like <code>\$_GET</code>, <code>\$_POST</code>, and <code>\$_SERVER</code> to access request and server data.</p>

    <h2>Example of Using \$_SERVER</h2>
    <?php
        echo "Server Name: " . $_SERVER['SERVER_NAME'] . "<br/>";
        echo "Request Method: " . $_SERVER['REQUEST_METHOD'] . "<br/>";
    ?>

    <hr/>
    <p>PHP is versatile and widely supported, making it an excellent choice for developing dynamic and interactive websites.</p>

</body>
</html>
