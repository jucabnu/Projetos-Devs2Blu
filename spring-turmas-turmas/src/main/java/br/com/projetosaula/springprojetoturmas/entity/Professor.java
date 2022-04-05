package br.com.projetosaula.springprojetoturmas.entity;

import java.util.List;
import javax.persistence.Entity;

@Entity(name="professor")
public class Professor extends Pessoa {
	
	private List<Turma> turmas;

	public Professor() {}

	public Professor(List<Turma> turmas) {
		super();
		this.turmas = turmas;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	

}
