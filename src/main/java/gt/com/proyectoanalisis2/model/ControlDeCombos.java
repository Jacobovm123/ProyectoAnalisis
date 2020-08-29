package gt.com.proyectoanalisis2.model;

public class ControlDeCombos {

    public InterfazOrderControl getMenu(String whatMenu){
        switch (whatMenu){
            case "Combo 1":
                return new ComboUnoDesayuno();
       
            default:
                return new NullObject();
        }
    }
}
