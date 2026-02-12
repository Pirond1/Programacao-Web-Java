package escola;

import escola.Aluno;
import escola.Disciplina;
import escola.Matricula;
import escola.Professor;

public class start {
	
	public static void main(String[] args) {
		Aluno aluno = new Aluno("Gustavo", "123.456.789-10", "123.4.56.789");
		Professor professor = new Professor("Lenon", "098.765.432-10", "Mestre");
		Disciplina disciplina = new Disciplina("PROGRAMAÇÃO WEB JAVA", 40, professor);
		Matricula matricula = new Matricula(aluno, disciplina, 2, 9);
		
		System.out.println("Média: " + matricula.Media());
	}
}
