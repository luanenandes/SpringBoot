package org.generation.minhaRedeSocial.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity /*Informando que a classe é uma entidade: possui atributo e relacionamento*/
@Table(name = "tema") /*Definindo nome da tabela*/
public class Tema {
	
	/*Criando nossa primeira classe do tema*/
	
	@Id  /*Informa que se trata do ID*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull /*Para não deixar nula a descrição*/
	@Size(min=5, max=400) /*Para configurar um tamanho padrão para a descrição*/
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) /*Aqui informa que haverá UM tema para MUITAS postagens, MAPEADO pela tabela de TEMA*/
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	
	/*puxar os getter and setter no Ctrl+3: ggas*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
		
}