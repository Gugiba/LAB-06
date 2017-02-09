package usuario;

import jogo.Jogo;

public abstract class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
		this.x2p = 0;
	}
	
	@Override
	public boolean compraJogo(Jogo jogaAcomprar) throws Exception{
		double precoJogo = jogaAcomprar.getPreco();
		precoJogo -=precoJogo * 0.1;
		return this.descontaFundo(precoJogo);
		
	}
	
	@Override
	public void atualizaX2pPeloPreco(double valor){
		this.x2p += 10 * valor;
	}
	
	

}
