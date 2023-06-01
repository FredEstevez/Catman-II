// By Pacman Company
package application;

import java.io.*;
import java.time.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class RankingDoc{

@SuppressWarnings("unused")
private PacManModel pacManModel;


// vamos a crear/actualizar y escribir el fichero plano TXT
public void EscribirRanking()  {
	String ValUsuario;
	
	ValUsuario= PacManModel.getScore + "   \t,\t"+ ControladorIni.getJugador() + "  \t,\t" + LocalDate.now();
	
	File archivo; 										// By Pacman Company para manipular el archivo
	FileWriter escribir;  								// By Pacman Company para escribir en el archivo
	PrintWriter linea; 									// By Pacman Company para escribir en el archivo la linea
	archivo = new File("src/application/Ranking.txt"); // By Pacman Company preparamos el archivo
	
	if (!archivo.exists()) {     //By Pacman Company  la clase verifica si existe el archivo, si no existe lo crea y si existe escribe en la siguiente linea libre, nunca sobre escribe.
	 	// By Pacman Company  - condicion si el archivo no existe
			try {  
				archivo.createNewFile();
				escribir = new FileWriter(archivo, true);
				linea = new PrintWriter(escribir);
				//linea.println(PacManModel.getScore + ", \t"+ ControladorIni.getJugador() + ", \t" + LocalDate.now()); // By Pacman Company escribimos en el archivo
				linea.println(ValUsuario);
				linea.close();
				escribir.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	}else { 
		// By Pacman Company - condicion si el archivo ya existe
		try {
			escribir = new FileWriter(archivo, true);
			linea = new PrintWriter(escribir);
			//linea.println(PacManModel.getScore + ", \t"+ ControladorIni.getJugador() + ", \t" + LocalDate.now()); // By Pacman Company escribimos en el archivo
			linea.println(ValUsuario);
			linea.close();
			escribir.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
}

// By Pacman Company  metodo para leer el ranking del archivo TXT
public String leerRanking()  {
	this.pacManModel = new PacManModel();
	File archivo; 														// By Pacman Company - para manipular el archivo
	FileReader leerArchivo;  											// By Pacman Company - para  en el archivo
	archivo = new File("src/application/Ranking.txt"); 	// By Pacman Company - preparamos el archivo
	int c;
			String contenido = "Score   \t|\tJugador \t|\tFecha\n";  //By Pacman Company - configuramos cabecera de la presentacion del txt - ranking
			try {
				leerArchivo = new FileReader(archivo);
				
				c= leerArchivo.read();
				
				while( c!=-1) {
					contenido +=(char)c;
					 c= leerArchivo.read();	 
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    
			return contenido;   // By Pacman Company  Devolvemos el valore leido para ser cargado en la pantalla
		
}


// By Pacman Company  Metodo - fin de juego, donde abro la pantalla de Ranking
public void finjuego() {
	        EscribirRanking(); //by Pacman Company - almacenamos el ranking consegido
	        
    	try {
    		
			FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/application/RankingScreen.fxml"));
			ControlRanking controlr = new ControlRanking();
			loader1.setController(controlr);
			Parent root = loader1.load();
	        Stage stage1 = new Stage();
            stage1.setScene(new Scene(root));
            stage1.initModality( Modality.WINDOW_MODAL);
       	    stage1.show();
		    
		    controlr.startRank(); // By Pacman Company - leo el txt y lo presento en el objeto lista.
		    

		} catch(Exception e) {
			e.printStackTrace();
		}
} 
}
