package validacao;


import jogo.Jogabilidade;
import jogo.Jogo;
import usuario.Usuario;

public class Validacao {

	
	public void validaString(String nome) throws Exception{
		//Titulo não pode ser Vazio ou Nulo
		if(nome == null || nome.trim().equals(" ") || nome.trim().equals("")){
			throw new Exception("Esse titulo é Invalido!");
		}
	}
	
	public void validaNumero(double preco) throws Exception{
		//Preço não pode ser Negativo ou  ter valor igual 0
		if(preco <=0){
			throw new Exception("Esse Valor é Invalido!");
		}
	}

	public void objetoJogo(Jogo jogo) throws Exception {
		if(jogo == null){
			throw new Exception("Jogo não poder ser nula");
		
	}
	}
	
	public void objetoUsuario(Usuario usuario) throws Exception {
		if(usuario == null){
			throw new Exception("Usuário não poder ser nula");
		
	}
	}
		
	public void objetoJogabilidade(Jogabilidade jogabilidade) throws Exception{
		if(jogabilidade == null){
			throw new Exception("Jogabilidade Inválida");
		}
	}
	
	}

	
