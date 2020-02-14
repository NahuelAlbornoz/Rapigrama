package rapigrama;

public class Palabra {

	//private String palabra;
	private char[] letras;
	private int posicion;
	private char orientacion;
	
	
	public Palabra(String palabra,int p){
		//this.palabra=palabra;
		this.letras=palabra.toCharArray();
		this.posicion=p;
	}

	/*
	public String getPalabra() {
		return palabra;
	}


	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	*/
	
	public char[] getLetras() {
		return letras;
	}


	public void setLetras(char[] letras) {
		this.letras = letras;
	}
	

	public int getPosicion() {
		return posicion;
	}


	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
	public char getOrientacion() {
		return orientacion;
	}


	public void setOrientacion(char orientacion) {
		this.orientacion = orientacion;
	}


	/*
	public String toString(){
		return palabra;
	}
	*/
}