package jogo;

import java.util.HashSet;

import validacao.Validacao;

public abstract class Jogo {

	
	private String nome;
	private double preco;
	private int maiorScore;
	private int qtnVezesJogadas;
	private int qtnZerado;
	private HashSet<Jogabilidade> jogabilidade;
	private Validacao validacao = new Validacao();
	public static final String NL = System.lineSeparator();
	
	
	public Jogo(String nome,double preco ) throws Exception{
		
		validacao.validaString(nome);
		validacao.validaNumero(preco);
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtnVezesJogadas = 0;
		this.qtnZerado = 0;
		this.jogabilidade = new HashSet<>();
	}
	
	public abstract int registraJogada(int score,boolean zerou);
	
	public String getNome(){
		return this.nome;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public int getMaiorScore(){
		return this.maiorScore;
	}
	
	public void adicionaJogada(){
		this.qtnVezesJogadas +=1;
	}
	
	public void adicionaZerada(boolean zerou){
		if(zerou){
		this.qtnZerado +=1;
		}
	}
	
	public int getJogadas(){
		return this.qtnVezesJogadas;
	}
	
	public int getZeradas(){
		return this.qtnZerado;
	}
	
	public boolean atualizarScoreMax(int score){
		if(score > maiorScore){
			maiorScore = score;
			return true;
		}
		return false;
	}

	public void setQtnJogadas(int Novaquantidade){
		
	}
	
	public boolean adicionaJogabilidade(Jogabilidade jogabilidade) throws Exception {
		validacao.objetoJogabilidade(jogabilidade);
		return this.jogabilidade.add(jogabilidade);
	}
	
	public HashSet<Jogabilidade> getJogabilidade(){
		return this.jogabilidade;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
