package br.com.projetosaula.springprojetoturmas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="aluno")
public class Aluno extends Pessoa{

	private int ano;
	@OneToMany
	private Turma turma;
	@ManyToMany
	private List<Disciplina> disciplinas;
	
	public Aluno() {}

	public Aluno(Turma turma, int ano, List<Disciplina> disciplinas) {
		super();
		this.turma = turma;
		this.ano = ano;
		this.disciplinas = disciplinas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
