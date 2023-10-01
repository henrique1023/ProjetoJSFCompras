package br.com.dio.bean;

import br.com.dio.model.*;
import br.com.dio.util.EdicaoTextoDataTable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class FormularioBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Formulario formulario = new Formulario();
    private Produto produto = new Produto(1,"Caixa","Caixa de papelão",10.00,31.00);
    private Empresa empresa = new Empresa();
    private ConsultaSerasa serasa = new ConsultaSerasa();
    private Employee funcionario = new Employee();
    private Pedido pedido = new Pedido();
    private ProdutoPK produtoPK = new ProdutoPK();
    private List<ProdutoPK> produtos = new ArrayList<>();
    private List<Formulario> formularios = new ArrayList<>();
    private EdicaoTextoDataTable edicao = new EdicaoTextoDataTable();
    private Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
    public void init() {
        formulario = (Formulario) flash.get("formulario");
        if (formulario == null) {
            formulario = new Formulario();
        }
        empresa.setIdEmpresa(1);
        empresa.setBalanco(500.000);
        empresa.setCnpj(123123123123123l);
        empresa.setCapitalSocial(1000000.00);
        empresa.setFaturamentoMensal(250000.00);
        empresa.setDeletado(false);
        empresa.getLucro(100000.00);

        serasa.setEmpresa(empresa);
        serasa.setLimiteSerasa(100000.00);
        serasa.setRiscoSerasa("Baixo");
        serasa.setCodConsulta(1l);
        serasa.setNumConsultaSerasa(2);

        funcionario.setId(1);
        funcionario.setBirthday(new Date());
        funcionario.setCpf("12345678912");
        funcionario.setName("Jose");
        funcionario.setLastname("da silva");
        funcionario.setRegisterEmployee(12);
        funcionario.setFuncao("Vendedor");
        funcionario.setSalary(2500.00f);

        produtoPK.setCodProdutoPK(1);
        produtoPK.setProduto(produto);
        produtoPK.setQuantidade(100);
        produtoPK.setTotal(12000.00);

        produtos.add(produtoPK);
        pedido.setCodPedido(1);
        pedido.setEmpresa(empresa);
        pedido.setTotalPedido(12000.00);
        pedido.setProdutos(produtos);
        pedido.setFormaPagamento(FormaDePagamento.BOLETO);

        formulario.setCodFormulario(1l);
        formulario.setEmpresa(empresa);
        formulario.setPedido(pedido);
        formulario.setSerasa(serasa);
        formulario.setFuncionario(funcionario);
        formulario.setValorAprovado(100000.00);
        formulario.setValorAvista(50000.00);
        formulario.setPontosMaximos(90);
        formulario.setPontosObtidos(70);
        formulario.setPontosNecessarios(60);

    }

    public String addFormulario() {
        clean();
        return "/restricted/produtoList/form_produto.xhtml?faces-redirect=true";
    }

    public void searchAllFormularios() {
        formularios.add(formulario);
    }

    private void clean() {
        this.formulario = new Formulario();
    }
    public String editar(Formulario e) {
        flash.clear();
        flash.put("formulario", e);
        return "/restricted/produtoList/register_produto?faces-redirect=true";
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }

    public EdicaoTextoDataTable getEdicao() {
        return edicao;
    }

    public void setEdicao(EdicaoTextoDataTable edicao) {
        this.edicao = edicao;
    }

    public Flash getFlash() {
        return flash;
    }

    public void setFlash(Flash flash) {
        this.flash = flash;
    }
}
