package Personagem;

public class Majin extends Personagem{

	public Majin(String nome, String cor, int forca) {
		super(nome, cor, forca);
	}
	
	public void TransformarChocolate() {
		System.out.println("Transformado em Chocolate...");
	}

	@Override
	public void golpear() {
		System.out.println("Majin Golpeando");
	}

	@Override
	public void defender() {
		System.out.println("Majin Defendendo");
	}

}
