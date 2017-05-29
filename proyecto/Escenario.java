import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Escenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escenario extends Niveles
{

    //public GreenfootSound escsound = new GreenfootSound("dogsong.mp3");
    //public GreenfootSound startsound = new GreenfootSound("startlevel.mp3");
    
    private static final String bgImageName = "escenario.jpg";
    private static final double scrollSpeed = 2.5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
 
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private int huevo;
    private Jugador personaje;
    int frame = 0; 
     private int score = 0;
    private SimpleTimer timer;
     
    public Escenario(int nivel, int score)
    {    
        this.score = score;
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        
        
        timer = new SimpleTimer();
        
        personaje = new JakeW();
        iniciaParamJugador();
        personaje.actualizaNivel(nivel);
        personaje.posX=10;
        personaje.posY=510;
        addObject(personaje, personaje.posX, personaje.posY);

    }
    
    public void resetTimer()
    {
        timer.mark();
    }
    
    void muestraInterfaz()
    {
        showText("Puntaje: " + personaje.getPuntaje(), 30, 10);
        showText("Tiempo: " + timer.millisElapsed()/1000, 30, 10); 
    }
    
    private void iniciaParamJugador()
    {
        personaje.actualizaNivel(0);
        personaje.actualizaPuntaje(0);
        personaje.actualizaNombre("J1");
        
    }
     public void act()
    {
        //if(!escsound.isPlaying()) escsound.play();
        validaTecla();
    }

    public void camina()
    {
        switch(frame)
        {
            case 0: personaje.setImage("jakew.png");
            break;
            case 1: personaje.setImage("jakew1.png");
            break;
            case 2: personaje.setImage("jakew2.png");
            break;
            case 3: personaje.setImage("jakew3.png");
            break;
        }
        
        if(frame<4) frame++;
        if(frame==4) frame = 0;
    }
    
    public void MuestraIndicaciones(){
        showText("Presiona Flecha Derecha para avanzar", 400, 50);
    }
    
    public void validaTecla()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            if(timer.millisElapsed()%600 <= 100) camina();
            
             if(personaje.posX > 400)
             {
                scrollPosition -= scrollSpeed;
                while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
                while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
                paint(scrollPosition);
                
                if(personaje.posX >400 && scrollPosition <-512) 
                {
                     //escsound.stop();
                    // startsound.play();
                     Greenfoot.delay(100);
                     if(personaje.getNivel() < 5) personaje.actualizaNivel(personaje.getNivel()+1);
                     siguienteNivel();
                    
                    
                }
                if(personaje.posX >400 && scrollPosition <-134 && scrollPosition > -212) personaje.posY -= 3;
                if(personaje.posX >400 && scrollPosition <-772 && scrollPosition > -850) personaje.posY += 3;
                
                
            }
            else {
                personaje.posX+=scrollSpeed;
            }
        } else {
            personaje.setImage("jakew.png");
        }
        
        //System.out.printf("Px:%d Sx:%d Sum:%d\n", personaje.posX , scrollPosition, personaje.posX + scrollPosition);
        
        personaje.setLocation(personaje.posX, personaje.posY);
    }
    private void siguienteNivel()
    {
                Random rand = new Random();
                huevo=rand.nextInt(2);
        switch(personaje.getNivel())
        {

            case 1:Greenfoot.setWorld(  new Nivel1(score) );
            break;
            case 2: Greenfoot.setWorld( new Nivel2(score)  );
            break;
            case 3: Greenfoot.setWorld( new Nivel3(score)  );
            break;
            case 4: Greenfoot.setWorld( new Nivel4(score) );
            break;
            case 5: Greenfoot.setWorld( new Nivel5(score)  );
            break;
        
        }
    
    }
    
     private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }
}
