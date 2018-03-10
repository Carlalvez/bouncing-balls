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

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400; 

        myCanvas.setVisible(true);
        myCanvas.drawLine(50, ground, 550, ground);
        
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    public void bounce(int numBolas) {
        int suelo = 400;
        
        myCanvas.setVisible(true);
        myCanvas.drawLine(50,suelo,550,suelo);
        
        ArrayList<BouncingBall> bolas = new ArrayList<>();
        
        for(int r = 0; r < numBolas; r++){  
            bolas.add(bolaAleatoria(suelo));
        }
        
        boolean finalizado =  false;
        while(!finalizado) {
            
            myCanvas.wait(50);
            for(BouncingBall bola : bolas) {
                bola.move();
            }
            
            int a = 0;
            
            
            while(!finalizado && a < bolas.size()) {
                if(bolas.get(a).getXPosition() >= 550) {
                    finalizado = true;
                }
                a++;
            }
        }
    }
    
    /**
     * 
     * @return Devuelve bola aleatoria.
     */
    private BouncingBall bolaAleatoria(int suelo) {
        Random aleatorio = new Random();
        int diametro = aleatorio.nextInt(41) + 10;
        Color color = new Color(aleatorio.nextInt(256),aleatorio.nextInt(256),aleatorio.nextInt(256));
        return new BouncingBall(50, 50, diametro, color, suelo, myCanvas);
    }
}
