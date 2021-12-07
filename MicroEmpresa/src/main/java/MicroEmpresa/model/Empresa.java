package MicroEmpresa.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Empresa{
	@Id
	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDate dataDeCadastro;
	
	public Empresa(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome tem que ser inserido")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@NotEmpty(message = "Cnpj tem que ser inserido")
	@CNPJ(message = "Cnpj tem que ser inserido")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@NotEmpty(message = "Email tem que ser inserido")
	@Email(message = "Email tem que ser inserido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
}