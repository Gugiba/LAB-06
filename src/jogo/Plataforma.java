package jogo;

public class Plataforma extends Jogo{

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		
	}
	
	
	public int registraJogada(int score,boolean zerou){
		adicionaJogada();
		adicionaZerada(zerou);
		atualizarScoreMax(score);
		
		if(zerou){
			return 20;
		}
		return 0;
	}

}
