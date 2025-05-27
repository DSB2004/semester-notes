<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Signup</title>
  <link rel="stylesheet" href="/user/assets/login/style.css" />
</head>
<body>
  <form class="__form__container" id="__login__account__form">
    <div class="__form__title">Login</div>
    <div class="__form__group">
      <label class="__form__label" for="username">Username</label>
      <input
        class="__form__input"
        type="text"
        id="username"
        name="username"
        placeholder="Enter username"
      />
    </div>

    <div class="__form__group">
      <label class="__form__label" for="password">Password</label>
      <input
        autocomplete="current-password"
        class="__form__input"
        type="password"
        id="password"
        name="password"
        placeholder="Enter password"
      />
    </div>

    <p style=" height:15px; text-align: center;" id="__login__account__form__p"></p>
    
    <button type="submit" class="__form__button">Login</button>

    <div class="__form__footer">
      Don't have an account? <a href="/user/page/signup">Sign Up</a>
    </div>
  </form>

  <script src="/user/assets/login/script.js">
   
  </script>
</body>
</html>
