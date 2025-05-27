<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Signup</title>
    <link rel="stylesheet" href="/user/assets/signup/style.css" />
  </head>
  <body>
    <form class="__form__container" id="__create__account__form">
      <div class="__form__title">Create Account</div>
      <div class="__form__group">
        <label class="__form__label" for="username">Username</label>
        <input
          class="__form__input"
          type="text"
          id="username"
          name="username"
          placeholder="Enter username"
          required
        />
      </div>
      
      <div class="__form__group">
        <label class="__form__label" for="email">Email</label>
        <input
        class="__form__input"
        type="email"
        id="email"
        name="email"
        placeholder="Enter email"
        required
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
        required
        />
      </div>
      
      <p  style="height:15px; text-align: center;" id="__create__account__form__p">
        
        </p>
        <button type="submit" class="__form__button">Sign Up</button>
        
        <div class="__form__footer">
          Already have an account? <a href="/user/page/login">Login</a>
        </div>
      </form>
    </body>
    <script src="/user/assets/signup/script.js"></script>
</html>
