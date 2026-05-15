<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #f0f2f5; margin: 0; }
        nav { background: #1a1a2e; color: white; padding: 16px 30px; display: flex; justify-content: space-between; }
        nav a { color: #e94560; margin-left: 20px; text-decoration: none; font-weight: bold; }
        .container { max-width: 900px; margin: 30px auto; background: white; padding: 30px; border-radius: 10px; }
        h2 { color: #1a1a2e; }
        input, button { padding: 8px 12px; margin: 5px; border-radius: 5px; border: 1px solid #ccc; }
        button { background: #e94560; color: white; border: none; cursor: pointer; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th { background: #1a1a2e; color: white; padding: 10px; }
        td { padding: 10px; border-bottom: 1px solid #eee; }
        tr:hover td { background: #f9f9f9; }
    </style>
</head>
<body>
<nav>
    <span>Company App</span>
    <div>
        <a href="${pageContext.request.contextPath}/welcome">Home</a>
        <a href="${pageContext.request.contextPath}/products">Products</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</nav>
<div class="container">
    <h2>Products</h2>
    <form action="${pageContext.request.contextPath}/products" method="post">
        <input type="text" name="ref" placeholder="Reference" required />
        <input type="text" name="name" placeholder="Product Name" required />
        <input type="number" name="stock" placeholder="Stock" step="0.01" required />
        <button type="submit">Add Product</button>
    </form>

    <table>
        <tr><th>Ref</th><th>Name</th><th>Stock</th></tr>
        <c:forEach var="p" items="${products}">
            <tr>
                <td><c:out value="${p.ref}"/></td>
                <td><c:out value="${p.name}"/></td>
                <td><c:out value="${p.stock}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>