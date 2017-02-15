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
	
	@Override
	public String toString() {
		String saida =  NL + "+ " + super.getNome() + " - Plataforma:" + NL +
				"==> Jogou " + super.getJogadas() + " vez(es)" + NL + 
				"==> Zerou " + super.getZeradas() + " vez(es)" + NL +
				"==> Maior score: " + super.getMaiorScore() + NL;
		
		return saida;
}

}
