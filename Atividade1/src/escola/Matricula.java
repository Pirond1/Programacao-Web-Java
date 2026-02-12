package escola;

public class Matricula {
	public Aluno aluno;
	public Disciplina disciplina;
	public int nota1;
	public int nota2;
	
	public Matricula(Aluno aluno, Disciplina disciplina, int nota1, int nota2) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	public String Media() {
		double media = (this.nota1 + this.nota2) / 2;
		
		if(media >= 7){			
			return "Aprovado!";
		}else{
			return "Reprovado!";
		}
	}
}
