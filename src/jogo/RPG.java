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
	
    @Override
    public String toString() {
    	String saida =  NL + "+ " + super.getNome() + " - RPG:" + NL +
				"==> Jogou " + super.getJogadas() + " vez(es)" + NL + 
				"==> Zerou " + super.getZeradas() + " vez(es)" + NL +
				"==> Maior score: " + super.getMaiorScore() + NL;
		
		return saida;
    }
}
