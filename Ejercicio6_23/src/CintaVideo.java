public class CintaVideo extends Soporte {
   private int duracion;

    public CintaVideo(int duracion) {
        this.duracion = duracion;
    }

    public CintaVideo(String titulo, int numero, float precio,int duracion) {
        super(titulo, numero, precio);
        this.duracion = duracion;
    }
   
   
   
   @Override
   public String imprimeDatos(){
   
   return getClass().getName()+" "+getTitulo()+"; numero: "+getNumero()+"; precio: "+getPrecio()+" duracion: "+duracion;
   
   }
   
    
    
    
    
    
}
