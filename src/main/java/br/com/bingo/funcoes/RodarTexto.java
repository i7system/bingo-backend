package br.com.bingo.funcoes;

public class RodarTexto {

	
	private String texto;
	private String divisor;
	private int limite;
	
	public String getTexto() {
		return this.texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getDivisor() {
		return this.divisor;
	}
	
	public void setDivisor(String divisor) {
		this.divisor = divisor;
	}
	
	public int getLimite() {
		return this.limite;
	}
	
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	public static void CriarObjetos() {
		
		RodarTexto[] arrayobjeto = new RodarTexto[5];
		
		
		
		for(int i =0;i<arrayobjeto.length;i++) {
			
			arrayobjeto[i]  = new RodarTexto();
			
			System.out.println("objetos : " + arrayobjeto[i]);
			
		}
	}
	
}
