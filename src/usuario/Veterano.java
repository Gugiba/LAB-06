package usuario;

import jogo.Jogo;

public class Veterano extends Usuario{

	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		this.x2p = 1000;
		
	}
	
	@Override
	public boolean compraJogo(Jogo jogaAcomprar) throws Exception{
		double precoJogo = jogaAcomprar.getPreco();
		precoJogo -= precoJogo * 0.2;
		return this.descontaFundo(precoJogo);
		
	}
	
	
	
	

}
