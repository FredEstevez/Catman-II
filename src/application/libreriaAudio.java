package application;
// libreria Audio para la creacion de los efectos de sonido

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class libreriaAudio {
	// Reproducimos el sonido de la intro del juego
	File SonidoIni = new File("src/audio/intro.wav"); // creamos el object file
	String sSonidoIni = "file:///"+ SonidoIni.getAbsolutePath(); // capturamos la ruta del ejecutable
	
     MediaPlayer mediaplayer1;
     
     public void SonidoInici() {
    	 sSonidoIni = sSonidoIni.replace("\\","/");
    	 Media musicFile= new Media(sSonidoIni);
    	 mediaplayer1 = new MediaPlayer(musicFile); // la variable recoge el contenio de la url 
    	 mediaplayer1.play(); // reproduce el sonido 
    	 
     }
 
    // reproducimos el sonido del boron jugar, da comienzo a juego 
    //  y cuando el Ratón va comiendo los quesitos
 	File SonidoBott = new File("src/audio/atepellot.wav"); // creamos el object file
 	String sSonidoBott = "file:///"+ SonidoBott.getAbsolutePath(); // capturamos la ruta del ejecutable
 	
      MediaPlayer mediaplayer2;
      
      public void SonidoJugar() {
    	  sSonidoBott = sSonidoBott.replace("\\","/");
     	 Media musicFile= new Media(sSonidoBott);
     	 mediaplayer2 = new MediaPlayer(musicFile); // la variable recoge el contenio de la url 
     	 mediaplayer2.play(); // reproduce el sonido 
     	 
      } 
     
    // Reproducimos el sonido cuando muere el Ratón 
  	File SonidoDied = new File("src/audio/died.wav"); // creamos el object file
 	String sSonidoDied = "file:///"+ SonidoDied.getAbsolutePath(); // capturamos la ruta del ejecutable
 	
      MediaPlayer mediaplayer3;
      
      public void SonidoMuere() {
    	  sSonidoDied = sSonidoDied.replace("\\","/");
     	 Media musicFile= new Media(sSonidoDied);
     	 mediaplayer3 = new MediaPlayer(musicFile); // la variable recoge el contenio de la url 
     	 mediaplayer3.play(); // reproduce el sonido 
     	 
      } 
      
      // Reproducimos el sonido cuando el Raton se come el super queso
    	File SonidoSQ = new File("src/audio/ateghost.wav"); // creamos el object file
   	String sSonidoSQ = "file:///"+ SonidoSQ.getAbsolutePath(); // capturamos la ruta del ejecutable
   	
        MediaPlayer mediaplayer4;
        
        public void SonidoSuperQueso() {
      	  sSonidoSQ = sSonidoSQ.replace("\\","/");
       	 Media musicFile= new Media(sSonidoSQ);
       	 mediaplayer4 = new MediaPlayer(musicFile); // la variable recoge el contenio de la url 
       	 mediaplayer4.play(); // reproduce el sonido 
       	 
        } 
        
        // Reproducimos el sonido cuando los gatos se convierten en presas
    	File SonidoCatBlue = new File("src/audio/ateghost.wav"); // creamos el object file
   	String sSonidoCatBlue  = "file:///"+ SonidoCatBlue .getAbsolutePath(); // capturamos la ruta del ejecutable
   	
        MediaPlayer mediaplayer5;
        
        public void SonidoGatoAzul() {
      	  sSonidoCatBlue  = sSonidoCatBlue .replace("\\","/");
       	 Media musicFile= new Media(sSonidoCatBlue );
       	 mediaplayer5 = new MediaPlayer(musicFile); // la variable recoge el contenio de la url 
       	 mediaplayer5.play(); // reproduce el sonido 
       	 
        } 
     
      

}