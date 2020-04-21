
import java.util.ArrayList;
import java.util.LinkedList;

public class Pedido {

    private Cliente c1;
    private ArrayList<Pizza> pizzas;

    public Pedido() {
    }
    public Pedido(Cliente c1) {
        this.c1 = c1;
    }

    public Pedido(Cliente c1, ArrayList<Pizza> pizzas) {
        this.c1 = c1;
        this.pizzas = pizzas;
    }

    
    
    
    
    
    public Cliente getC1() {
        return c1;
    }

    public void setC1(Cliente c1) {
        this.c1 = c1;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    //Metodos
    public void anadirPizza(Pizza p) {
        pizzas.add(p);

    }

    public void eliminarPizza(int pos) {
        pizzas.remove(pos);

    }

    public void eliminarTodas() {
        pizzas.removeAll(pizzas);

    }

    public double getPrecio() {
        double precio = 0;
        for (int i = 0; i < pizzas.size(); i++) {
            precio = precio + pizzas.get(i).getPrecio();
        }
        return precio;

    }

    @Override
    public String toString() {
        return c1.getNombre() + " "+ c1.getDireccion() + "  "+ pizzas.toString() + "  "+ getPrecio() + " €";
    }

}
