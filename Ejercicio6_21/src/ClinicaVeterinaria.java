
import java.util.ArrayList;
import java.util.Scanner;

public class ClinicaVeterinaria extends Animal {

    Scanner sc = new Scanner(System.in);
    ArrayList<Animal> ListaAnimales;

    //Constructores
    public ClinicaVeterinaria() {
        ListaAnimales = new ArrayList();

    }

    //Metodos
    public void InsertaAnimal() {

        System.out.println("¿Que tipo de animal es? (Perro,Gato,Pajaro,Reptil)");
        String _tipo = sc.nextLine();
        _tipo = _tipo.toLowerCase();
        if (_tipo.equals("perro")) {
            System.out.println("Nombre perro");
            String _nombre = sc.nextLine();

            System.out.println("Tipo de Raza");
            String _raza = sc.nextLine();
            _raza.toLowerCase();
            Perro.tipo_raza r = Perro.tipo_raza.PastorAleman;
            if (_raza.equals("pastoraleman")) {
                Perro.tipo_raza raza = Perro.tipo_raza.PastorAleman;
                r = raza;
            } else if (_raza.equals("husky")) {
                Perro.tipo_raza raza = Perro.tipo_raza.Husky;
                r = raza;
            } else if (_raza.equals("foxterrier")) {
                Perro.tipo_raza raza = Perro.tipo_raza.FoxTerrier;
                r = raza;
            } else if (_raza.equals("dalamata")) {
                Perro.tipo_raza raza = Perro.tipo_raza.Dalmata;
                r = raza;
            } else if (_raza.equals("sanbernardo")) {
                Perro.tipo_raza raza = Perro.tipo_raza.SanBernardo;
                r = raza;
            }

            System.out.println("Fecha Nacimiento");
            String _fecha = sc.nextLine();

            System.out.println("Peso del perro");
            double _peso = sc.nextDouble();

            System.out.println("Microchip del perro");
            sc.next();
            String _microchip = sc.nextLine();

            Perro nuevoanimal = new Perro(_nombre, r, _fecha, _peso, _microchip);
            ListaAnimales.add(nuevoanimal);

        } else if (_tipo.equals("gato")) {

            System.out.println("Nombre gato");
            String _nombre = sc.nextLine();

            System.out.println("Tipo de Raza");
            String _raza = sc.nextLine();
            _raza.toLowerCase();
            Gato.tipo_raza r = Gato.tipo_raza.Comun;
            if (_raza.equals("comun")) {
                Gato.tipo_raza raza = Gato.tipo_raza.Comun;
                r = raza;
            } else if (_raza.equals("siames")) {
                Gato.tipo_raza raza = Gato.tipo_raza.Siames;
                r = raza;
            } else if (_raza.equals("persa")) {
                Gato.tipo_raza raza = Gato.tipo_raza.Persa;
                r = raza;
            } else if (_raza.equals("angora")) {
                Gato.tipo_raza raza = Gato.tipo_raza.Angora;
                r = raza;
            } else if (_raza.equals("scottishfold")) {
                Gato.tipo_raza raza = Gato.tipo_raza.ScottishFold;
                r = raza;
            }

            System.out.println("Fecha Nacimiento");
            String _fecha = sc.nextLine();

            System.out.println("Peso del gato");
            double _peso = sc.nextDouble();

            System.out.println("Microchip del gato");
            sc.next();
            String _microchip = sc.nextLine();

            Gato nuevoanimal = new Gato(_nombre, r, _fecha, _peso, _microchip);
            ListaAnimales.add(nuevoanimal);

        } else if (_tipo.equals("pajaro")) {

            System.out.println("Nombre pajaro");
            String _nombre = sc.nextLine();

            System.out.println("Tipo de Especie");
            String _especie = sc.nextLine();
            _especie.toLowerCase();
            Pajaro.tipo_especie r = Pajaro.tipo_especie.Agapornis;
            if (_especie.equals("agapornis")) {
                Pajaro.tipo_especie especie = Pajaro.tipo_especie.Agapornis;
                r = especie;
            } else if (_especie.equals("canario")) {
                Pajaro.tipo_especie especie = Pajaro.tipo_especie.Canario;
                r = especie;
            } else if (_especie.equals("periquito")) {
                Pajaro.tipo_especie especie = Pajaro.tipo_especie.Periquito;
                r = especie;
            }

            System.out.println("Fecha Nacimiento");
            String _fecha = sc.nextLine();

            System.out.println("Peso del gato");
            double _peso = sc.nextDouble();

            System.out.println("¿Da mucho el follon el pajarito? Si o No");
            boolean canta = false;
            sc.next();
            String _cantor = sc.nextLine();
            if (_cantor.equalsIgnoreCase("si")) {
                canta = true;
            }

            Pajaro nuevoanimal = new Pajaro(_nombre, r, _fecha, _peso, canta);
            ListaAnimales.add(nuevoanimal);

        } else if (_tipo.equals("reptil")) {

            System.out.println("Nombre reptil");
            String _nombre = sc.nextLine();

            System.out.println("Tipo de Especie");
            String _especie = sc.nextLine();
            _especie.toLowerCase();
            Reptil.tipo_especie r = Reptil.tipo_especie.DragonDeComodo;
            if (_especie.equals("dragondecomodo")) {
                Reptil.tipo_especie especie = Reptil.tipo_especie.DragonDeComodo;
                r = especie;
            } else if (_especie.equals("tortuga")) {
                Reptil.tipo_especie especie = Reptil.tipo_especie.Tortuga;
                r = especie;
            } else if (_especie.equals("iguana")) {
                Reptil.tipo_especie especie = Reptil.tipo_especie.Iguana;
                r = especie;
            }

            System.out.println("Fecha Nacimiento");
            String _fecha = sc.nextLine();

            System.out.println("Peso del gato");
            double _peso = sc.nextDouble();

            System.out.println("¿Venenoso? Si - No");
            boolean venenoso = false;
            sc.next();
            String _venom = sc.nextLine();
            if (_venom.equalsIgnoreCase("si")) {
                venenoso = true;
            }

            Reptil nuevoanimal = new Reptil(_nombre, r, _fecha, _peso, venenoso);
            ListaAnimales.add(nuevoanimal);

        } else {
            System.out.println("ERROR RAZA ERRONEA");
        }

    }

    public String BuscaAnimal() {

        System.out.println("\n Introduzca nombre del animal");
        String nom = sc.nextLine();

        String r = "";
        for (int i = 0; i < ListaAnimales.size(); i++) {
            if (nom.equals(ListaAnimales.get(i).getNombre())) {
                r = ListaAnimales.get(i).toString();
                i = ListaAnimales.size();
            }
        }
        return r;
    }

    public void ModificaComentarioAnimal() {
        System.out.println("\n Introduzca nombre del animal");
        String nom = sc.nextLine();
        System.out.println("\n Introduzca comentario");
        String _comen = sc.nextLine();

        for (int i = 0; i < ListaAnimales.size(); i++) {
            if (nom.equals(ListaAnimales.get(i).getNombre())) {
                ListaAnimales.get(i).setComentarios(_comen);
                i = ListaAnimales.size();
            }
        }
    }

    @Override
    public String toString() {
        return "ClinicaVeterinaria{" + "ListaAnimales=" + ListaAnimales + '}';
    }

}
