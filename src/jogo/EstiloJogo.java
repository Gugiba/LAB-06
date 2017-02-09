package jogo;
public class EstiloJogo{
	
	public enum EstiloDoJogo{
		ONLINE("Online"),
		OFFLINE("Offline"),
		MULTIPLAYER("Multiplayer"),
		COOPERATIVO("Cooperativo"),
		COMPETITIVO("Competitivo");
		
		private String estilo;
		
		EstiloDoJogo(String estilo){
			this.estilo = estilo;
		}
		
		public String getEstilo(){
			return this.estilo;
		}
		
		
		
	}
}