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
               case "Desayuno 2":
                lista.add("Cereal");
                lista.add("Fruta");
                lista.add("Bebida");
                return lista;
                
                    case "Desayuno 3":
                lista.add("Avena");
                lista.add("Fruta");
                lista.add("Bebida");
                return lista;
                    case "Almuerzo 1":
                lista.add("Hamburguesa");
                lista.add("Papas");
                lista.add("Bebida");
                lista.add("Postre");
                return lista;
                
                        case "Almuerzo 2":
                lista.add("Ensalada");
                lista.add("Pollo");
                lista.add("Sopa");
                lista.add("Bebida");
                return lista;
                   case "Almuerzo 3":
                lista.add("Lomito");
                lista.add("Chorizo");
                lista.add("Platanos");
                lista.add("Frijoles");
                lista.add("Bebida");
                return lista;
                 
                 case "Cena 1":
                lista.add("Huevos");
                lista.add("Frijoles");
                lista.add("Tortillas");
                lista.add("Bebida");
                return lista;
            
                
                 case "Cena 2":
                lista.add("Fajitas");
                lista.add("Vegetales");
                lista.add("Tortillas");
                lista.add("Bebida");
                return lista;
                
                
                 case "Cena 3":
                lista.add("Pan");
                lista.add("Huevo");
                lista.add("Beicon");
                lista.add("Queso");
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
           
     case "Desayuno 2":
                return 18;
      case "Desayuno 3":
                return 20;
                
                 case "Almuerzo 1":
                return 25;
                
                 case "Almuerzo 2":
                return 40;
                   case "Almuerzo 3":
                return 70;
              
                  case "Cena 1":
                return 28;
                    case "Cena 2":
                return 38;
                   case "Cena 3":
                return 45;
                
            default:
                return 0;
        }
    }
}
