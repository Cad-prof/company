<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Company - Login</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            background: #1a1a2e;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: 'Segoe UI', sans-serif;
        }
        .login-box {
            background: #16213e;
            padding: 40px;
            border-radius: 10px;
            width: 380px;
            box-shadow: 0 8px 32px rgba(0,0,0,0.4);
        }
        h2 { color: #e94560; text-align: center; margin-bottom: 30px; font-size: 28px; }
        label { color: #a8b2d8; font-size: 13px; display: block; margin-bottom: 5px; }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #0f3460;
            border-radius: 6px;
            background: #0f3460;
            color: #ccd6f6;
            font-size: 14px;
            margin-bottom: 20px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background: #e94560;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }
        input[type="submit"]:hover { background: #c73652; }
        .error { color: #e94560; text-align: center; margin-bottom: 15px; font-size: 13px; }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Company Login</h2>
    <% if (request.getAttribute("error") != null) { %>
    <p class="error">${error}</p>
    <% } %>
    <form action="login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter username" required />
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter password" required />
        <input type="submit" value="Login" />
    </form>
</div>
</body>
</html>