package gt.com.proyectoanalisis2.model;




import java.util.ArrayList;
import java.util.List;
import gt.com.proyectoanalisis2.model.InterfazMenuDao;

public class MenuDao implements InterfazMenuDao {


    public List<String> menus(String nameMenu) {
        List<String>lista = new ArrayList<>();

        switch (nameMenu) {
            case "Combo 1":

                lista.add("Medallones");
                lista.add("Frijoles");
                lista.add("Queso");
                lista.add("Tortillas");
                 lista.add("Bebida");
                return lista;
           
            default:
                lista.add("error");
                lista.add("EL menu selecionado no esta disponible o no existe ");
                return lista;
        }

    }

    @Override
    public int getPrecioMenu(String whatMenu) {
        switch (whatMenu) {
            case "Combo 1":
                return 35;
           
            default:
                return 0;
        }
    }
}
