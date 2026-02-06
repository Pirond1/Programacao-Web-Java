package Personagem;

public class Humano extends Personagem  {

	public Humano(String nome, String cor, int forca) {
		super(nome, cor, forca);
	}

	@Override
	public void golpear() {
		System.out.println("Humano Golpeando");
	}

	@Override
	public void defender() {
		System.out.println("Humano Defendendo");
		
	}

}
