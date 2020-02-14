package rapigrama;
import java.io.File;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("rapigrama.in"));
			
			//creo el objeto tablero, pasandole por parametro la dimension
			Tablero t1 = new Tablero (sc.nextInt());
			
			int cant_palabras = sc.nextInt();
			Palabra[] palabras= new Palabra[cant_palabras];
			
			//lleno el tablero
			for(int i=0;i<t1.getDimension();i++){
				String letras=sc.next();
				t1.llenar(letras,i);
			}
			
			//for para llenar el arreglo de tipo Palabras
			for(int i=0;i<cant_palabras;i++){
				palabras[i]= new Palabra(sc.next(),i+1);
			}
			
			
			t1.buscarPalabras(palabras);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
}