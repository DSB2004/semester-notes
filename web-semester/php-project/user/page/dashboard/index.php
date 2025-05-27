<?php
session_start();

if (!isset($_SESSION["username"]) || !isset($_SESSION["email"])) {
    header("Location: /user/page/login/?error=session-not-found");
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Dashboard</title>
  <link rel="stylesheet" href="./style.css" />
</head>
<body class="__body">
  <div class="__layout">
    
    <!-- Sidebar -->
    
    <?php
      include_once("../../components/sidebar/index.php");
      ?>

    <!-- Main Content -->
    <main class="__main">
      <header class="__main_header">
        <h1 class="__main_title">Customer Overview</h1>
      </header>

      <section class="__main_section">
        <table class="__table">
          <thead class="__table_head">
            <tr>
              <th>Name</th>
              <th>Email</th>
              <th>Status</th>
              <th>Joined</th>
            </tr>
          </thead>
          <tbody class="__table_body">
            <tr>
              <td>Jane Doe</td>
              <td>jane@example.com</td>
              <td>Active</td>
              <td>2024-03-01</td>
            </tr>
            <tr>
              <td>John Smith</td>
              <td>john@example.com</td>
              <td>Inactive</td>
              <td>2023-11-15</td>
            </tr>
          </tbody>
        </table>
      </section>
    </main>

  </div>
</body>
</html>
