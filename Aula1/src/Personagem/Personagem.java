package Personagem;

public abstract class Personagem {
	
	private String nome;
	private String cor;
	private int forca;
	
	public Personagem(String nome, String cor, int forca) {
		this.nome = nome;
		this.cor = cor;
		this.forca = forca;
	}
	
	public void correr() {
		System.out.println("Estou correndo!");
	}
	
	public abstract void golpear();
	
	public abstract void defender();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}
		
}
