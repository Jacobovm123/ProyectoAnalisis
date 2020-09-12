package gt.com.proyectoanalisis2.model;

public class ControlDeCombos {

    public InterfazOrderControl getMenu(String whatMenu){
        switch (whatMenu){
            case "Combo 1":
                return new ComboUnoDesayuno();
         case "Desayuno 2":
                return new ComboDosDesayuno();
                  case "Desayuno 3":
                return new ComboTresDesayuno();
                    case "Almuerzo 1":
                return new ComboUnoAlmuerzo();
                        case "Almuerzo 2":
                return new ComboDosAlmuerzo();
                     case "Almuerzo 3":
                return new ComboTresAlmuerzo();
             case "Cena 1":
                return new ComboUnoCena();
                       case "Cena 2":
                return new ComboDosCena();
                                       case "Cena 3":
                return new ComboTresCena();
            default:
                return new NullObject();
        }
    }
}
