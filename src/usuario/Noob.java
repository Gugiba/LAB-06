package usuario;

import jogo.Jogo;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
		this.x2p = 0;
	}
	
	public boolean compraJogo(Jogo jogaAcomprar) throws Exception{
		double precoJogo = jogaAcomprar.getPreco();
		precoJogo -=precoJogo * 0.1;
		return this.descontaFundo(precoJogo);
		
	}
	
	

}
