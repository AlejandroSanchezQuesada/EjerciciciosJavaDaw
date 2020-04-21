package herenciafigura;

abstract public class  Figura {
    
    protected String color;

    public Figura(){
    color = "azul";
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public abstract int getArea();    
    
    
    
    
}
