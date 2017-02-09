package jogo;

import java.util.HashSet;

import validacao.Validacao;

public abstract class Jogo {

	
	private String nome;
	private double preco;
	private int maiorScore;
	private int qtnVezesJogadas;
	private int qtnZerado;
	private HashSet<EstiloJogo> estiloJogo;
	
	public Jogo(String nome,double preco ) throws Exception{
		Validacao validacao = new Validacao();
		validacao.validaNome(nome);
		validacao.validaPreco(preco);
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtnVezesJogadas = 0;
		this.qtnZerado = 0;
		this.estiloJogo = new HashSet<>();
	}
	
	public abstract int registraJogada(int score,boolean progresso);
	
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
	
	public void adicionaZerada(){
		this.qtnZerado +=1;
	}
	
	public int getJogadas(){
		return this.qtnVezesJogadas;
	}
	
	public int getZeradas(){
		return this.qtnZerado;
	}
	
	

	
}
