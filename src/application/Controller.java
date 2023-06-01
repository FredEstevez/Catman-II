package application;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements EventHandler<KeyEvent> {
    final private static double FRAMES_PER_SECOND = 5.0;

    @FXML private Label scoreLabel;
    @FXML private Label levelLabel;
    @FXML private Label gameOverLabel;
    @FXML private PacManView pacManView;
    private PacManModel pacManModel;

    private static final String[] levelFiles = {"src/levels/level1.txt", "src/levels/level2.txt", "src/levels/level3.txt", "src/levels/level4.txt", "src/levels/level5.txt"};

    private Timer timer;
    private static int ghostEatingModeCounter;
    private boolean paused;

    public Controller() {
        this.paused = false;
    }

   
     //Se Inicializa y actualiza el modelo y la vista desde el primer archivo txt y se inicia el temporizador.
   
    public void initialize() {
        @SuppressWarnings("unused")
		String file = Controller.getLevelFile(0);
        this.pacManModel = new PacManModel();
        this.update(PacManModel.Direction.NONE);
        ghostEatingModeCounter = 25;
        
        this.startTimer();
        
    }

    // se programa el modelo para que se actualice según el temporizador.

    private void startTimer() {
        this.timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        update(PacManModel.getCurrentDirection());
                    }
                });
            }
        };

        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }


     // Se carga el PacManModel, se actualiza la vista, actualiza la puntuación, las vidas y el nivel, muestra Game Over/You Won e instrucciones sobre cómo jugar
     // @param dirección la dirección ingresada más recientemente para que PacMan se mueva
 
    private void update(PacManModel.Direction direction) {
    	 libreriaAudio reproduce = new libreriaAudio(); //by Pacman Company
         RankingDoc rankingDoc = new RankingDoc();
    	 
        this.pacManModel.step(direction);
        this.pacManView.update(pacManModel);
       // this.scoreLabel.setText(String.format("Score: %d", this.pacManModel.getScore()));  
       // this.levelLabel.setText(String.format("Level: %d", this.pacManModel.getLevel()));
        this.scoreLabel.setText(String.format("Puntuación: %d", this.pacManModel.getScore()));  //by Pacman Company
        this.levelLabel.setText(String.format("Nivel: %d", this.pacManModel.getLevel()));  		//by Pacman Company
        this.gameOverLabel.setText(String.format("Vidas: %d", this.pacManModel.getLiveCount()));//by Pacman Company
        
        if (PacManModel.isGameOver()) {
        	reproduce.SonidoMuere(); //by Pacman Company
        	this.gameOverLabel.setText(String.format(" GAME OVER "));
        	//rankingDoc.EscribirRanking();//by Pacman Company - almacenamos el ranking consegido
            rankingDoc.finjuego();// by Pacman Company - presentamos pantalla de ranking al finalizar partida
        	pause();
		
        }
        if (PacManModel.isYouWon()) {
          //  this.gameOverLabel.setText(String.format("YOU WON!"));
        	this.gameOverLabel.setText(String.format(" Enhorabuena, has Ganado! "));			// by Pacman Company
        	//rankingDoc.EscribirRanking();														// by Pacman Company - almacenamos el ranking consegido
            rankingDoc.finjuego(); 																// by Pacman Company - presentamos pantalla de ranking al finalizar partida
        	
        }
        //when PacMan is in ghostEatingMode, count down the ghostEatingModeCounter to reset ghostEatingMode to false when the counter is 0
        if (PacManModel.isGhostEatingMode()) {
            ghostEatingModeCounter--;
        }
        if (ghostEatingModeCounter == 0 && PacManModel.isGhostEatingMode()) {
            PacManModel.setGhostEatingMode(false);
        }
    }

    /**
     * Takes in user keyboard input to control the movement of PacMan and start new games
     * @param keyEvent user's key click
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        boolean keyRecognized = true;
        KeyCode code = keyEvent.getCode();
        PacManModel.Direction direction = PacManModel.Direction.NONE;
        if (code == KeyCode.LEFT) {
            direction = PacManModel.Direction.LEFT;
        } else if (code == KeyCode.RIGHT) {
            direction = PacManModel.Direction.RIGHT;
        } else if (code == KeyCode.UP) {
            direction = PacManModel.Direction.UP;
        } else if (code == KeyCode.DOWN) {
            direction = PacManModel.Direction.DOWN;
        } else if (code == KeyCode.G) {
            pause();
            this.pacManModel.startNewGame();
            this.gameOverLabel.setText(String.format(""));
            paused = false;
            this.startTimer();
        } else {
            keyRecognized = false;
        }
        if (keyRecognized) {
            keyEvent.consume();
            pacManModel.setCurrentDirection(direction);
        }
    }

   // Pausa el tiempo
     
    public void pause() {
            this.timer.cancel();
            this.paused = true;
    }

    public double getBoardWidth() {
        return PacManView.CELL_WIDTH * this.pacManView.getColumnCount();
    }

    public double getBoardHeight() {
        return PacManView.CELL_WIDTH * this.pacManView.getRowCount();
    }

    public static void setGhostEatingModeCounter() {
        ghostEatingModeCounter = 25;
    }

    public static int getGhostEatingModeCounter() {
        return ghostEatingModeCounter;
    }

    public static String getLevelFile(int x)
    {
        return levelFiles[x];
    }
    
    public boolean getPaused() {
        return paused;
    }
}
