// Desarrollado por PacMan Company

package application;	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	 libreriaAudio reproduce = new libreriaAudio();
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Inicio.fxml"));
			ControladorIni control = new ControladorIni();
			
			loader.setController(control);
			
			Parent root = loader.load();
			
			primaryStage.setScene(new Scene(root));
			
			primaryStage.show();
			
			reproduce.SonidoInici();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	 		
		
	}
}
