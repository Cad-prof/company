<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome - Company</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #f0f2f5; margin: 0; }
        nav { background: #1a1a2e; color: white; padding: 16px 30px; display: flex; justify-content: space-between; }
        nav a { color: #e94560; margin-left: 20px; text-decoration: none; font-weight: bold; }
        .container { max-width: 900px; margin: 50px auto; background: white; padding: 40px; border-radius: 10px; }
        h1 { color: #1a1a2e; }
    </style>
</head>
<body>
<nav>
    <span>Company App</span>
    <div>
        <a href="${pageContext.request.contextPath}/products">Products</a>
        <a href="${pageContext.request.contextPath}/purchases">Purchases</a>
        <a href="${pageContext.request.contextPath}/sales">Sales</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</nav>
<div class="container">
    <h1>Welcome, <c:out value="${sessionScope.user}" />!</h1>
    <p>Use the navigation above to manage your company's data.</p>
</div>
</body>
</html>