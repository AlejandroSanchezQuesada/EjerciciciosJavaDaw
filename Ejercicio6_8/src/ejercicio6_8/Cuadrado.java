package ejercicio6_8;

public class Cuadrado {

    private int lado;

    public Cuadrado(int _lado) {
        lado = _lado;
        
    }

    public void Dibuja(){
    
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print("*");
            }System.out.println("");
        }
    
    
    }
    
    public void getArea(){
        int area = lado*lado;
        System.out.println("El area de este cuadrado es = "+area);
    
    
    }
    
    
    
    
    
}
