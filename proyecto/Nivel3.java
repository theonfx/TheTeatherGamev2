import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends Niveles
{
    //GreenfootSound music = new GreenfootSound("level3.mp3");
    private Objeto plato, palo;
    private int x; //Variable para calcular balanceo del objeto
    private long tf, ti, tfg, tig; //tiempo final y tiempo inicial
    private int mov=10;
    private Jugador personaje;
    private SimpleTimer timer;
    private int score;
   
    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3(int puntaje)
    {
        score = puntaje;
        timer = new SimpleTimer();
        
        x=0; //Inicializar variable de balanceo en 0
        CargaObjetos();
        MuestraIndicaciones();
        tf=ti=tfg=tig=System.currentTimeMillis();
        timer.mark();
    }
    
    void muestraInterfaz()
    {
        showText("Nivel: 3" , 50, 40);
        showText("Tiempo: " + (10 - timer.millisElapsed()/1000), 60, 60); 
    }
    
    public void CargaObjetos()
    {
        plato = new Plato();
        palo = new Palo();
        
        plato.posX=380;
        plato.posY=130;
        
        palo.posX=380;
        palo.posY=300;
        
        addObject(palo, palo.posX, palo.posY);
        addObject(plato, plato.posX, plato.posY);
    }
    
    public void validaTecla()
    {
        //Actualizar tiempo transcurrido
        tf=tfg=System.currentTimeMillis();
        
        //Verificar teclas presionadas
        if(Greenfoot.isKeyDown("C"))
        {
            muevePlato(0);
        } else if(Greenfoot.isKeyDown("P")) {
            muevePlato(1);
        }
        
        //Verificar desbalanceo
        if(x<-5 || x>5) 
        {
           // music.stop();
            plato.setImage("images/perdio.png");
            plato.setLocation(plato.posX, plato.posY+300);
            //fail.play();
            Greenfoot.delay(100);
            Greenfoot.setWorld( new Escenario(2, score) );
        }
        
        if(tfg-tig>10000){
            //music.stop();
            plato.setImage("images/gano.png");
            //win.play();
            Greenfoot.delay(100);
            Greenfoot.setWorld( new Escenario(3, score + 100) );   
        }
        
        if(tf-ti>500){
            //Verificar balanceo
            if(x<0) {
                muevePlato(0);
            }
            else if (x>0) 
            {
                muevePlato(1);
            }
            
            //Generar desbalanceo automático
            if(x==0) {
                Random rand = new Random();
                if(rand.nextInt(2) == 0) 
                {
                    muevePlato(1);
                }
                else {
                    muevePlato(0);
                }
            }
            
            ti=tf=System.currentTimeMillis(); //reiniciar contado rde tiempo
        }
    }
    
    public void muevePlato(int dir)
    {
        if(dir==0){
            if(mov>0){
            x--;
            plato.posX -= 10;
            plato.setLocation(plato.posX, plato.posY);
            mov--;
            plato.setRotation(plato.getRotation()-3);
             }
        } else
        {
             if(mov>0){
            x++;
            plato.posX += 10;
            plato.setLocation(plato.posX, plato.posY);
            mov++;
            plato.setRotation(plato.getRotation()+3);
             }
        }
    }
    
    public void MuestraIndicaciones(){
        showText("Balancea el plato antes que caiga! << [C] [P] >>", 400, 50);
    }
    
    public void resetTimer()
    {
        timer.mark();
    }
    
    /**
     * Act - do whatever the Nivel2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //if(!music.isPlaying()) music.play();
       validaTecla();
       muestraInterfaz();
    }
}
