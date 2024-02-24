package cadastroee.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cadastroee.model.Produto;
import cadastroee.controller.ProdutoFacadeLocal;

public class ServletProdutoFC extends HttpServlet {
    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "listar";
        }
        
        Integer idProduto;
        Produto produto;
        String destino = "ProdutoLista.jsp";
        
        switch (acao) {
            case "listar":
                List<Produto> listaProdutos = facade.findAll();  
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "excluir":
                idProduto = Integer.parseInt(request.getParameter("idProduto"));
                produto = facade.find(idProduto);
                facade.remove(produto);
                listaProdutos = facade.findAll();
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "alterar":
                idProduto = Integer.parseInt(request.getParameter("idProduto"));
                produto = facade.find(idProduto);
                produto.setNome(request.getParameter("nome"));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                produto.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));
                facade.edit(produto);
                listaProdutos = facade.findAll();
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "incluir":
                produto = new Produto();
                produto.setNome(request.getParameter("nome"));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                produto.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));
                facade.create(produto);
                listaProdutos = facade.findAll();
                request.setAttribute("listaProdutos", listaProdutos);
                break;
            case "formIncluir":
                destino = "ProdutoDados.jsp";
                break;
            case "formAlterar":
                idProduto = Integer.parseInt(request.getParameter("idProduto"));
                produto = facade.find(idProduto);
                request.setAttribute("produto", produto);
                destino = "ProdutoDados.jsp";
                break;
                
        }
        request.getRequestDispatcher(destino).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

