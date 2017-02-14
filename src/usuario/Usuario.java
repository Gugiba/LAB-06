package usuario;


import java.util.HashSet;
import java.util.Iterator;

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
		
		validacao.validaString(nome);
		validacao.validaString(login);
		
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
		validacao.validaNumero(valor);
		this.carteira += valor;
		
	}
	
	public boolean descontaFundo(double valor) throws Exception{
		validacao.validaNumero(valor);
		if(valor > this.carteira){
			return false;
		}
		
		else{
			this.carteira -= valor;
			return true;
		}
		
	}
	
	public void adicionaJogo(Jogo jogo){
		 meusJogos.add(jogo);
	}
	
	public abstract void atualizaX2pPeloPreco(double valor);

	
	public boolean registraJogada(String nomeJogo,int score,boolean zerou) throws Exception{
		int x2pGerado = 0;
		
		//Validando os Parametros Recebidos
		validacao.validaString(nomeJogo);
		validacao.validaNumero(score);
		
		//Obtendo o Objeto do jogo
		Jogo  jogo = getJogo(nomeJogo);
		
		//Checando se o Objeto é nulo
		try {
			validacao.objetoJogo(jogo);
		} catch (Exception e) {
			return false;
		}
		
		
		//Calculando a X2P
		x2pGerado+=jogo.registraJogada(score, zerou);
		adicionaX2p(x2pGerado);
		return true;
		
	}
	
	private void adicionaX2p(int x2pGerado) {
		this.x2p+=x2pGerado;
		
	}

	public Jogo getJogo(String nomeJogo) throws Exception{
		Iterator<Jogo> it = meusJogos.iterator();
		
		//Checando se o Jogo Está presente na Biblioteca do Usuário
		while(it.hasNext()) {
			Jogo jogoAProcurar  = it.next();
			if(jogoAProcurar.getNome().equals(nomeJogo)) {
				return jogoAProcurar;
			}
		
		}
		//Jogo não encontrado
		throw new Exception("Este Jogo não Existe ");
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
