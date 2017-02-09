package jogo;

public class Plataforma extends Jogo{

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		
	}
	
	@Override
	public int registraJogada(int pontuacao,boolean progresso){
		return 0;
	}

}
