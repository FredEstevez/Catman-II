// 
//desarrollado por PACMAN company
//

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorIni {
public static String Jugador;
libreriaAudio reproduce1 = new libreriaAudio();
    
    @FXML
    private Label TextCatMan;
    
    @FXML
    private Label TextEquipo;

    @FXML
    private Label textSofia;

    @FXML
    private Label TextFred;

    @FXML
    private Label TextJose;

    @FXML
    private Label TextJohnny;
    
    @FXML
    private TextField TextJugador;
    
    @FXML
    public Button BotonJugar;
    
	@FXML
    public void EventoJugar(ActionEvent event) {
    	   ControladorIni.Jugador = TextJugador.getText();
    	reproduce1.SonidoJugar();
    	    	
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("pacman.fxml"));
    	        Parent root = loader.load();
    	        Stage stage = new Stage();
				stage.setTitle("CatMan");
    	        Controller controller = loader.getController();
    	        root.setOnKeyPressed(controller);
    	        double sceneWidth = controller.getBoardWidth() + 20.0;
    	        double sceneHeight = controller.getBoardHeight() + 100.0;
    	        stage.setScene(new Scene(root, sceneWidth, sceneHeight));
    	        stage.initModality( Modality.WINDOW_MODAL);
    	        stage.initOwner(((Node)(event.getSource())).getScene().getWindow());
    	        stage.show();
    	        root.requestFocus();
    	        
    	        
    			
    		} catch(Exception e) {
    			e.printStackTrace();
    		}

    }
	public static String getJugador() {
		return Jugador;
	}
	public void setJugador(String jugador) {
		ControladorIni.Jugador = jugador;
	}
       
	
 //   @FXML
 //   private Button BotonVerRanking;


 //   @FXML
 //   void EventoVerRankig(ActionEvent event) {
  //  	try {
	//		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/application/RankingScreen.fxml"));
	//		ControlRanking controlr = new ControlRanking();
	//		loader1.setController(controlr);
	//		Parent root = loader1.load();
	//        Stage stage1 = new Stage();
    //        stage1.setScene(new Scene(root));
	//	    stage1.show();
		    
	//	    controlr.startRank();
		    

	//	} catch(Exception e) {
	//		e.printStackTrace();
	//	}
   // }
  
	
  }
    


