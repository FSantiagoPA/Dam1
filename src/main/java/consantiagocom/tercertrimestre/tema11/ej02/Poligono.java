package consantiagocom.tercertrimestre.tema11.ej02;

import java.util.ArrayList;

public class Poligono {
    protected final ArrayList<Punto> puntos;


    public Poligono(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public int numVertex(){
        return puntos.size();
    }

    /**
     * Metodo para hacer el array
     * recibe el arrray de puntos
     * y devuelve el perimietro
     * @param puntos
     * @return
     */
    public double perimtero(ArrayList<Punto>puntos){
        double perimetro = 0;
        for(int i = 0; i < puntos.size();i++){
            if(i < puntos.size() - 1)
                perimetro = perimetro + puntos.get(i).distance(puntos.get(i+1),puntos.get(i));
            if(i == puntos.size()-1)
                perimetro = perimetro + puntos.get(i).distance(puntos.get(i),puntos.get(0));
        }
        return perimetro;
    }
    @Override
    public String toString() {
        return "Poligono{" +
                "puntos=" + puntos +
                '}';
    }
}
