package ejercicio6_11;

public class Coche {
    
     Motor motor ;
     Rueda rd1,rd2,rd3,rd4 ;
     Puerta p1,p2 ;
    
    
    public Coche(Motor m, Rueda r1, Rueda r2, Rueda r3, Rueda r4, Puerta _p1, Puerta _p2){
    motor = m;
    rd1 = r1;
    rd2 = r2;
    rd3 = r3;
    rd4 = r4;
    p1 = _p1;
    p2 = _p2;
    
    }
    
    
    
    public String show(){
    
        String resultado =("Motor = "+motor.estado()+"\n Ruedas= "+rd1.estado()+rd2.estado()+rd3.estado()+rd4.estado()+"\n Puertas = "+p1.estado()+p2.estado());
    
    return resultado;
    
    }
    
    
    
    
}
