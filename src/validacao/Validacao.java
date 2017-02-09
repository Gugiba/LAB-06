package validacao;

public class Validacao {

	
	public void validaNome(String nome) throws Exception{
		//Titulo não pode ser Vazio ou Nulo
		if(nome == null || nome.trim().equals(" ") || nome.trim().equals("")){
			throw new Exception("Esse titulo é Invalido!");
		}
	}
	
	public void validaPreco(double preco) throws Exception{
		//Preço não pode ser Negativo ou  ter valor igual 0
		if(preco <=0){
			throw new Exception("Esse Valor é Invalido!");
		}
	}
	
	
}
