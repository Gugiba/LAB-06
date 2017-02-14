package loja;


import java.util.HashSet;
import java.util.Iterator;

import jogo.Jogo;
import usuario.Usuario;
import validacao.Validacao;

public class Loja {

	private HashSet<Usuario> listaUsuarios;
	private Validacao validacao;
	
	public Loja(){
		listaUsuarios = new HashSet<>();
		validacao = new Validacao();
	}
	
	public Usuario getUsuario(String login) throws Exception{
		Iterator<Usuario> it = listaUsuarios.iterator();
		
		while(it.hasNext()) {
			Usuario usuarioAProcurar  = it.next();
			if(usuarioAProcurar.getNome().equals(login)) {
				return usuarioAProcurar;
			}
		}
		
		throw new Exception("Este Usuário não Existe ");
		
		
		
	}
	
	public boolean procuraUsuario(String nome) throws Exception{
		validacao.validaString(nome);
		Iterator<Usuario> it = listaUsuarios.iterator();
		
		while(it.hasNext()) {
			Usuario usuarioAProcurar  = it.next();
			if(usuarioAProcurar.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean adicionaUsuario(Usuario usuario) throws Exception{
		//Validando Objeto Usuário
		  validacao.objetoUsuario(usuario);
		
		//Checando se o Usuário já Existe
		if(!procuraUsuario(usuario.getNome())){
			//Adicionando Usuário
			listaUsuarios.add(usuario);
			return true;
		}
		//Usuário já Existe
		return false;
	}
	
	public boolean adicionaDinheiro(String login,int valor) throws Exception{
		//Validando o Nome e o Valor
			validacao.validaNumero(valor);
			validacao.validaString(login);
		
		//Checando se o Usuario Existe
			if(procuraUsuario(login)){
				Usuario usuario = getUsuario(login);
				usuario.adicionaFundos(valor);
				return true;
			}
		//Usuário não Existe
			return false;
	}
	
	public boolean vendeJogo(String login,Jogo jogo) throws Exception{
		Usuario usuario = getUsuario(login);
		return usuario.descontaFundo(jogo.getPreco());
		
	}
}

	
