package br.com.projetosaula.springprojetoturmas.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="professor")
public class Professor extends Pessoa {
	
	@OneToOne
	@JoinColumn(name="turma_id")
	private Turma turma;

	public Professor() {}

	public Professor(Turma turma) {
		super();
		this.turma = turma;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	
	
	

}
