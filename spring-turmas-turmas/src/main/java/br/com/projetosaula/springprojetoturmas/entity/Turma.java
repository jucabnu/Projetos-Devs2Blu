package br.com.projetosaula.springprojetoturmas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="turma")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String periodo;
	private int maxAlunos;
	private int quantidadeAlnos;
	
	@OneToMany(mappedBy = "turma")	
	private List<Aluno> alunos;
	
	@OneToOne
	@JoinColumn(name="professor_id")
	private Professor professor;

	public Turma() {}

	public Turma(String nome, String periodo, int maxAlunos, int quantidadeAlnos, List<Aluno> aluno,
			Professor professor) {
		super();
		this.nome = nome;
		this.periodo = periodo;
		this.maxAlunos = maxAlunos;
		this.quantidadeAlnos = quantidadeAlnos;
		this.alunos = aluno;
		this.professor = professor;
	}
	
	public void addAluno(Aluno aluno) {
		if(getAluno().size() < getMaxAlunos()) {
			this.alunos.add(aluno);
		}
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getMaxAlunos() {
		return maxAlunos;
	}

	public void setMaxAlunos(int maxAlunos) {
		this.maxAlunos = maxAlunos;
	}

	public int getQuantidadeAlnos() {
		return quantidadeAlnos;
	}

	public void setQuantidadeAlnos(int quantidadeAlnos) {
		this.quantidadeAlnos = quantidadeAlnos;
	}

	public List<Aluno> getAluno() {
		return alunos;
	}

	public void setAluno(List<Aluno> alunos) {
		if(alunos.size() <= getMaxAlunos()) {
			this.alunos = alunos;
		}
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	

}
