package formasexamen;
public abstract class Punto {
    
    protected long fechaCreacion = System.currentTimeMillis();

    public Punto() {
    }

    public long getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(long fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return fechaCreacion+" ";
    }
    
    
    
    
}
