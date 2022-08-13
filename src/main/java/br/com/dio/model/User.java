package br.com.dio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Transient
    public static final String FIND_BY_EMAIL_SENHA = "Usuario.findByEmailSenha";

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String nome;

    @Column(unique = true)
    private String email;

    @Column
    private String senha;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    public Integer getId() {
              return id;
    }

    public void setId(Integer id) {
              this.id = id;
    }

    public String getNome() {
              return nome;
    }

    public void setNome(String nome) {
              this.nome = nome.trim();
    }

    public String getEmail() {
              return email;
    }

    public void setEmail(String email) {
              this.email = email.trim().toLowerCase();
    }

    public String getSenha() {
              return senha;
    }

    public void setSenha(String senha) {
              this.senha = senha.trim();
    }

    public Date getDataCadastro() {
              return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
              this.dataCadastro = dataCadastro;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(senha, other.senha);
	}

    


}
