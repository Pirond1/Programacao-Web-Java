import Personagem.Personagem;
import Personagem.Majin;
import Personagem.Humano;

public class PrimeiraClasse {

	public static void main(String[] args) {
		Personagem p1 = new Humano("Kuririn", "Branco", 10000);
		p1.golpear();
		
		p1 = new Majin("Boo", "Rosa", 10000);
		p1.golpear();
	}

}
