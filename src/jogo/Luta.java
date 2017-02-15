package jogo;

public class Luta extends Jogo {

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
		
	}
	
	

	public int registraJogada(int score,boolean zerou){
		int x2pGerado = 0;
		adicionaJogada();
		adicionaZerada(zerou);
		if(atualizarScoreMax(score)){
			x2pGerado+=score/1000;
		}
		
		return x2pGerado;
	}

	@Override
	public String toString() {
		String saida =  NL + "+ " + super.getNome() + " - Luta:" + NL +
				"==> Jogou " + super.getJogadas() + " vez(es)" + NL + 
				"==> Zerou " + super.getZeradas() + " vez(es)" + NL +
				"==> Maior score: " + super.getMaiorScore() + NL;
		
		return saida;
	}
}
