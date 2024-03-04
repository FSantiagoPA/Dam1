/*package consantiagocom.SegundoTrimestre.Tema08.Ejercicios;
import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;
    public Display(){
            this("");
    }
    public Display(String title){
        this(0,0,title);

    }
    public Display(int x,int y,String title){
        this(0,0,title,false);

    }
    public Display(int x,int y,String title,boolean maximized){
        this(0,0,DEFAULT_WIDTH,DEFAULT_HEIGHT,title,null,true,false);

    }
    public Display(int x,int y,int width,int height,String title,String icon,boolean exit,boolean maximizer){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        //Establecemos las medidas
        if(x < 0 && y < 0){
            Dimension dimension = toolkit.getScreenSize();

            x = Math.round(dimension.width/2f - width/2f);
            y = Math.round(dimension.height/2f - height/2f);
        }

        //Creamos la pantalla
        new JFrame(title);
        setBounds(x,y,width,height);

        //Activa la visbilidad de nuestra ventana
        setVisible(true);
        if(maximizer = true){

        }
        //Establecemos los iconos
        if(icon != null){
            Image iconimage = toolkit.getImage(icon);
            setIconImage(iconimage);
        }
        //Instrucion para terminar el programa cuando se cierra la ventana
        if(exit){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }

}*/
