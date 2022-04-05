package br.com.projetosaula.primeiroprojetospring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


// isso vai criar a tabela de acordo com a classe (name="tbfilme")
@Entity(name="filme")
public class Filme { 

	// define como será o comportamento de criação da Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// @Column(name="titulo_filme" unique="true"), cria e mapeia automaticamente
	// não precisa colocar o Colum em cada, se não houver atributos
	
	@Column
	private String titulo;
	
	@ManyToOne
	private Genero genero;
	
	@ManyToOne
	private Restricao restricao;
	
	@Column
	private int favorito;

	public Filme() {}

	public Filme(Long id, String titulo, Genero genero, Restricao restricao, int favorito) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.restricao = restricao;
		this.favorito = favorito;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Restricao getRestricao() {
		return restricao;
	}

	public void setRestricao(Restricao restricao) {
		this.restricao = restricao;
	}

	public int getFavorito() {
		return favorito;
	}

	public void setFavorito(int favorito) {
		this.favorito = favorito;
	}
	
}
