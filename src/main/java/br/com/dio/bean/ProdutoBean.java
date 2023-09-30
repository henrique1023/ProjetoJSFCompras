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
    }

    public String addEmployee() {
        clean();
        return "/restricted/produtoList/form_produto.xhtml?faces-redirect=true";
    }

    private void clean() {
        this.produto = new Produto();
    }
}
