
import java.util.ArrayList;

public class Terminos {

    ArrayList<String> Sinonimos = new ArrayList();
    private String termino;

    public void setSinonimos(String _Sinonimos) {
        this.Sinonimos.add(_Sinonimos);
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }



    public String getTermino() {
        return termino;
    }

}
