package usuario;

import jogo.Jogo;

public class Veterano extends Usuario{

	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		
		
	}
	
	@Override
	public boolean compraJogo(Jogo jogaAcomprar) throws Exception{
		double precoJogo = jogaAcomprar.getPreco();
		precoJogo -= precoJogo * 0.2;
		return super.descontaFundo(precoJogo);
		
	}
	
	@Override
	public void atualizaX2pPeloPreco(double preco){
		this.x2p += 15 * preco;
	}

	@Override
	public int getX2p() {
	
		return this.x2p;
	}
	
	
	@Override
	public String toString() {
		double precoTotal =0;
		String saida= NL + super.getLogin() + NL + super.getNome() + " - Jogador Veterano -" + NL + "Lista de Jogos:" + NL;
			for(Jogo jogo : super.getJogos()){
				saida += jogo + NL;
				precoTotal +=jogo.getPreco();
			}
			saida+="Total de Preço dos Jogos:" + precoTotal + NL + "------------------------------------";
			return saida;
	}
	
	
	

}
