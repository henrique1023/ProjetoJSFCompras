package br.com.dio.bean;

import br.com.dio.model.Employee;
import br.com.dio.model.Produto;
import br.com.dio.util.EdicaoTextoDataTable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Produto produto = new Produto(1,"Caixa","Caixa de papelão",10.00,31.00);
    private List<Produto> produtos = new ArrayList<>();
    private EdicaoTextoDataTable edicao = new EdicaoTextoDataTable();
    private Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

    public void init() {
        produto = (Produto) flash.get("produto");
        if (produto == null) {
            produto = new Produto();
        }
        produtos.add(produto);
    }

    public String addProduto() {
        clean();
        return "/restricted/produtoList/form_produto.xhtml?faces-redirect=true";
    }

    public void searchAllProdutos() {
        produtos.add(produto);
    }

    public void clearListProdutos() {
        produtos = null;
    }

    private void clean() {
        this.produto = new Produto();
    }

    public String editar(Employee e) {
        flash.clear();
        flash.put("produto", e);
        return "/restricted/produtoList/register_produto?faces-redirect=true";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
