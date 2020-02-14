package rapigrama;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Tablero {
	private int dimension;
	private char[][] casilleros;
	
	
	public Tablero(int dimension) {
		this.dimension = dimension;
		this.casilleros = new char [dimension][dimension];
		
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public char[][] getCasilleros() {
		return casilleros;
	}

	public void setCasilleros(char[][] casilleros) {
		this.casilleros = casilleros;
	}
	
	public void llenar(String palabra,int fila){
		for(int i=0;i<this.dimension;i++){
			this.casilleros[fila][i]=palabra.charAt(i);
			
		}
	}
	
	ArrayList<Palabra> palabras_list=new ArrayList<Palabra>();
	
	
	
	public boolean orientacionE(Palabra p){
		boolean coincidencia=false;
		int posicion_letra;
		int largo=p.getLetras().length;
		
		for(int i=0;i<this.dimension;i++){
			posicion_letra=0;
			for(int j=0;j<=this.dimension-largo;j++){
				
				//if(this.casilleros[i][j]==p.getPalabra().charAt(posicion_letra)){
				if(this.casilleros[i][j]==p.getLetras()[posicion_letra]){
					coincidencia=true;
					
					for(int n=j+1;n<largo;n++){
						posicion_letra++;
						//if(this.casilleros[i][n]!=p.getPalabra().charAt(posicion_letra)){
						if(this.casilleros[i][n]!=p.getLetras()[posicion_letra]){	
							coincidencia=false;
						}
					}
					
				}
			}
			if(coincidencia){
				
				p.setOrientacion('E');
				palabras_list.add(p);
				break;
			}
			else{
				posicion_letra=0;
			}
			if(coincidencia){
				break;
			}
		}
		return coincidencia;
	}
	
	public boolean orientacionO(Palabra p){
		boolean coincidencia=false;
		int posicion_letra;
		int largo=p.getLetras().length;
		int aux;
		
		for(int i=0;i<this.dimension;i++){
			posicion_letra=0;
			for(int j=this.dimension-1;j>=largo-1;j--){
				System.out.println("casillero "+this.casilleros[i][j]);
				if(this.casilleros[i][j]==p.getLetras()[posicion_letra]){
					coincidencia=true;
					System.out.println("letra: "+this.casilleros[i][j]+
							" es igual a esta letra: "+p.getLetras()[posicion_letra]);
					System.out.println("J es igual a: "+j);
					System.out.println("largo: "+largo);
					aux=j-(largo-1);
					System.out.println("°°°°°°°°°°°°°°°°°°° AUXILIAR LARGO: "+aux);
					for(int n=j-1;n>aux;n--){
						System.out.println("n= "+n);
						posicion_letra++;
						System.out.println("posicion_letra :"+posicion_letra);
						if(this.casilleros[i][n]!=p.getLetras()[posicion_letra]){
							System.out.println("FALSE!");
							coincidencia=false;
						}
						//borrar este else luego
						else{
							System.out.println("la letra "+this.casilleros[i][n]+" es igual a "+p.getLetras()[posicion_letra]);
						}
					}
					
				}
				if(coincidencia){
					System.out.println("HAY UNA COINCIDENCIA");
					p.setOrientacion('O');
					palabras_list.add(p);
					break;
				}
				else{
					posicion_letra=0;
				}
			}
			
			
			if(coincidencia){
				break;
			}
		}
		System.out.println("LISTA DE PALABRAS:");
		for(int i=0;i<palabras_list.size();i++){
			System.out.println(palabras_list.get(i));
		}
		System.out.println("ACAAAAAAAAAAAAAAAA "+coincidencia);

		
		return coincidencia;
		
		
	}
	
	public boolean orientacionS(Palabra p){
		boolean coincidencia=false;
		int largo=p.getLetras().length;
		int posicion_letra;
		
		for(int j=0;j<this.dimension-1;j++){
			posicion_letra=0;
			for(int i=0;i<=this.dimension-largo;i++){
				if(this.casilleros[i][j]==p.getLetras()[posicion_letra]){
					coincidencia=true;
					
					for(int n=i+1;n<i+largo;n++){
						posicion_letra++;
						if(this.casilleros[n][j]!=p.getLetras()[posicion_letra]){
							coincidencia=false;
						}
					}
				}
				if(coincidencia){
					p.setOrientacion('S');
					palabras_list.add(p);
					break;
				}
				else{
					posicion_letra=0;
				}
				
			}
			if(coincidencia){
				break;
			}
		}
		return coincidencia;
	}
	
	
	
	public boolean orientacionN(Palabra p){
		boolean coincidencia=false;
		
		int aux;
		int largo=p.getLetras().length;
		int posicion_letra;
		
		for(int j=0;j<this.dimension;j++){
			posicion_letra=0;
			for(int i=this.dimension-1;i>=largo-1;i--){
				if(this.casilleros[i][j]==p.getLetras()[posicion_letra]){
					coincidencia=true;
					
					aux=i-(largo-1);
					for(int n=i-1;n>aux;n--){
						posicion_letra++;
						
						if(this.casilleros[n][j]!=p.getLetras()[posicion_letra]){
							coincidencia=false;
							
						}
					}
				}
				if(coincidencia){
					p.setOrientacion('N');
					palabras_list.add(p);
					break;
				}
				else{
					posicion_letra=0;
				}
				
			}
			if(coincidencia){
				break;
			}
		}
		
		return coincidencia;
	}
	
	public void buscarPalabras(Palabra[] p){
		
		for(int y=0;y<p.length;y++){
			
			if(!this.orientacionE(p[y])){
				
				if(!this.orientacionS(p[y])){
					
					if(!this.orientacionN(p[y])){
						
						this.orientacionO(p[y]);
					}
				}
			}
			
			
		}
		
		
		PrintWriter x=null;
		try{
			x=new PrintWriter(new File("rapigrama.out"));
			
			for(int i=0;i<palabras_list.size();i++){
				x.println(palabras_list.get(i).getPosicion()+" "+palabras_list.get(i).getOrientacion());
			}
		
		}catch(FileNotFoundException f){
			
		}finally{
			if(x!=null){
				x.close();
			}
		}
	}
	
}