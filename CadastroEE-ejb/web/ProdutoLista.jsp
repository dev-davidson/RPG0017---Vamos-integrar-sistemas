
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listagem de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body class="container">
    <h1>Listagem de Produtos</h1>

    <a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary m-2">Novo Produto</a>
    
    <table class="table table-striped">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Preço de Venda</th>
                <th>Opções</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${listaProdutos}" var="produto">
                <tr>
                    <td>${produto.idProduto}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.quantidade}</td>
                    <td>${produto.precoVenda}</td>

                    <!-- Links para alteração e exclusão -->
                    <td>
                        <a class="btn btn-primary btn-sm" href="ServletProdutoFC?acao=formAlterar&idProduto=${produto.idProduto}">Alterar</a> | 
                        <a class="btn btn-danger btn-sm" href="ServletProdutoFC?acao=excluir&idProduto=${produto.idProduto}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty listaProdutos}">
                <tr>
                    <td colspan="5">Nenhum produto encontrado.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>

