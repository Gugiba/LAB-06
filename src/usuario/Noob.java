package usuario;

import jogo.Jogo;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
		this.x2p = 1000;
		
	}
	
	
	
	
	@Override
	public boolean compraJogo(Jogo jogaAcomprar) throws Exception{
		double precoJogo = jogaAcomprar.getPreco();
		precoJogo -=precoJogo * 0.1;
		return super.descontaFundo(precoJogo);
		
	}
	
	@Override
	public void atualizaX2pPeloPreco(double valor){
		this.x2p += 10 * valor;
	}

	@Override
	public int getX2p() {
		
		return this.x2p;
	}
	
	@Override
	public String toString() {
		double precoTotal =0;
		String saida= NL + super.getLogin() + NL + super.getNome() + " - Jogador Noob -" + NL + "Lista de Jogos:" + NL;
			for(Jogo jogo : super.getJogos()){
				saida += jogo + NL;
				precoTotal +=jogo.getPreco();
			}
			saida+="Total de Preço dos Jogos:" + precoTotal + NL + "------------------------------------";
			return saida;
	}

}
