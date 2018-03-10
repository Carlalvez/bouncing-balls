import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

public class BallDemo   
{
    private Canvas myCanvas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    public void bounce(int numBolas) {
        int suelo = 400;
        int limiteD = 550; 
        
        myCanvas.setVisible(true);
        myCanvas.drawLine(50,suelo,limiteD,suelo);
        
        ArrayList<BouncingBall> bolas = new ArrayList<>();
        for(int r = 0; r < numBolas; r++){  
            bolas.add(bolaAleatoria(suelo));
            bolas.get(r).draw();
        }  
        botar(bolas,limiteD);
    }
    
    private BouncingBall bolaAleatoria(int suelo) {
        Random aleatorio = new Random();
        int xPosicion = aleatorio.nextInt(126) + 25;
        int yPosicion = aleatorio.nextInt(76);
        int d = aleatorio.nextInt(31) + 5;
        Color color = new Color(aleatorio.nextInt(256),aleatorio.nextInt(256),aleatorio.nextInt(256));
        return new BouncingBall(xPosicion, yPosicion, d, color, suelo, myCanvas);
    }
    
    /**
     * Bota hasta que sale suelo a la derecha
     */
    private void botar(ArrayList<BouncingBall> bolas, int limiteDerecho) {
        boolean finalizado =  false;
        while(!finalizado) {
            // Retraso.
            myCanvas.wait(50);
            for(BouncingBall bola : bolas) {
                bola.move();
            }
            int a = 0;
            // Detiene la bola tras moverse lo suficiente en el eje x.
            while(!finalizado && a < bolas.size()) {
                if(bolas.get(a).getXPosition() >= limiteDerecho) {
                    finalizado = true;
                }
                a++;
            }
        }
    }    
}