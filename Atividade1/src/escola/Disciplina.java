package escola;

public class Disciplina {
	public String nome;
	public int carga_horaria;
	public Professor professor;
	
	public Disciplina(String nome, int carga_horaria, Professor professor) {
		this.nome = nome;
		this.carga_horaria = carga_horaria;
		this.professor = professor;
	}

}
