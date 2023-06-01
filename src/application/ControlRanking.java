//desarrollado por PACMAN company

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class ControlRanking {
	//RankingDoc rankingdoc2 = new RankingDoc();
	RankingDB rankingsql = new RankingDB();
	
	@FXML
    private Label Titulo;

    @FXML
    private Label TextTituloTresPrimeros;

    @FXML
    private TextArea ListaRankig;
    
    public void startRank () {  
     	//ListaRankig.setText(rankingdoc2.leerRanking());
        //RankingDB.consulta_rank();
    	//ListaRankig.       (RankingDB.consulta_rank());
    	
    	
    }
    
    
    @FXML
    private Button BotonCerrar;
    
   
    @FXML
    void CerrarPartida(ActionEvent event) {
    	
    	System.exit(0);

    }
   
}