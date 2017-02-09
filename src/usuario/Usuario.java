package usuario;

import java.util.HashSet;

import jogo.Jogo;
import validacao.Validacao;

public abstract class Usuario {

	
	private String nome;
	private String login;
	protected int x2p;
	private double carteira;
	private HashSet<Jogo> meusJogos;
	Validacao validacao = new Validacao();
	
	
	public Usuario(String nome,String login) throws Exception{
		
		validacao.validaNome(nome);
		validacao.validaNome(login);
		
		this.login = login;
		this.nome = nome;
		this.carteira = 0;
		this.meusJogos = new HashSet<>();
	}
	
	public abstract boolean compraJogo(Jogo jogoAcomprar) throws Exception;
	
	
	public double getDinheiro(){
		return this.carteira;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public void adicionaFundos(double valor) throws Exception{
		validacao.validaPreco(valor);
		this.carteira += valor;
		
	}
	
	public boolean descontaFundo(double valor) throws Exception{
		validacao.validaPreco(valor);
		if(valor > this.carteira){
			return false;
		}
		
		else{
			this.carteira -= valor;
			return true;
		}
		
	}
	
	public boolean adicionaJogo(Jogo jogo){
		return meusJogos.add(jogo);
	}
	

	
}
