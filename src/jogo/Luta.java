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

}
