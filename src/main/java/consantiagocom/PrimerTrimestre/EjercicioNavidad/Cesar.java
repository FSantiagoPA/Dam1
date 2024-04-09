package consantiagocom.PrimerTrimestre.EjercicioNavidad;

public class Cesar {

    private final String passworld;
    private final int num;
    private final String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public Cesar(String passworld, int num) {
        this.passworld = passworld;
        this.num = num;
    }
    public String cifrar(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passworld.length(); i++){
            char posicionPass = passworld.charAt(i);
            if (Character.isLowerCase(posicionPass)) {
                int indiceOriginal = abc.indexOf(posicionPass);
                int nuevoIndice = (indiceOriginal + num) % abc.length();
                char ecriptado = abc.charAt(nuevoIndice);
                sb.append(ecriptado);
            }
            else{
                int indiceOriginal = abc.indexOf(posicionPass);
                int nuevoIndice = (indiceOriginal + num) % abc.length();
                char ecriptado =  abc.charAt(nuevoIndice);
                sb.append(ecriptado);
            }
        }
        return sb.toString();
    }

}
