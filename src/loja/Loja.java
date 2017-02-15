package loja;


import java.util.HashSet;
import java.util.Iterator;

import jogo.Jogo;
import usuario.Usuario;
import usuario.Veterano;
import validacao.Validacao;

public class Loja {

	private HashSet<Usuario> listaUsuarios;
	private Validacao validacao;
	public static final String NL = System.lineSeparator();
	
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
	
	public boolean upgrade(String login) throws Exception{
		validacao.validaString(login);
		Veterano novoVeterano = new Veterano("Nome","Login");
		Usuario usuarioAserPromovido = getUsuario(login);
		if( usuarioAserPromovido.getClass() != novoVeterano.getClass()){
			if(usuarioAserPromovido.getX2p()>=1000){
				//Repassando todos os dados da instância Noob para a Veterana 
				novoVeterano.setNome(usuarioAserPromovido.getNome());
				novoVeterano.setLogin(usuarioAserPromovido.getLogin());
				novoVeterano.adicionaFundos(usuarioAserPromovido.getDinheiro());
				novoVeterano.setMeusJogos(usuarioAserPromovido.getJogos());
				novoVeterano.adicionaX2p(usuarioAserPromovido.getX2p() - 1000);
			
				listaUsuarios.remove(usuarioAserPromovido);
				return listaUsuarios.add(novoVeterano);
			
		  }
			//Não tem XP suficiente
			try {
				throw new Exception("X2p Insuficiente");
			} catch (Exception e) {
				return false;
			}
		}
		    //Já é Veterano
			try {
				throw new Exception("Este usuário já é Veterano");
			} catch (Exception e) {
				return false;
			}
	}
	
	@Override
	public String toString() {
		String saida = "=== Central P2-CG ===" + NL;
		for(Usuario usuarios: listaUsuarios) {
			saida += usuarios;
		}
					
		return saida;
	}
}

	
