package usuario;

import java.util.HashMap;
import java.util.HashSet;

import jogo.Jogo;
import validacao.Validacao;

public abstract class Usuario {

	
	private String nome;
	private String login;
	protected int x2p;
	private double carteira;
	private HashMap<String,Jogo> meusJogos;
	Validacao validacao = new Validacao();
	
	
	public Usuario(String nome,String login) throws Exception{
		
		validacao.validaNome(nome);
		validacao.validaNome(login);
		
		this.login = login;
		this.nome = nome;
		this.carteira = 0;
		this.meusJogos = new HashMap<>();
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
	
	public void adicionaJogo(Jogo jogo){
		 meusJogos.put(jogo.getNome(),jogo);
	}
	
	public abstract void atualizaX2pPeloPreco(double valor);

	
	public void registraJogada(String nomeJogo,int score,boolean zerou) throws Exception{
		int x2pGerado = 0;
		validacao.validaNome(nomeJogo);
		validacao.validaPreco(score);
		Jogo  jogo = getJogo(nomeJogo);
		x2pGerado+=jogo.registraJogada(score, zerou);
		adicionaX2p(x2pGerado);
		
	}
	
	private void adicionaX2p(int x2pGerado) {
		this.x2p+=x2pGerado;
		
	}

	public Jogo getJogo(String nomeJogo){
		if(meusJogos.containsKey(nome)){
			return meusJogos.get(nome);
		}
		return null;
	}
	

	
}
