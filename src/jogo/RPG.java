package jogo;

public class RPG extends Jogo{

	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
		
	}
	

	public int registraJogada(int score,boolean zerou){
		adicionaJogada();
		adicionaZerada(zerou);
		atualizarScoreMax(score);
		return 10;
	}
	
    
}
