package gt.com.proyectoanalisis2.model;

public class AdditionalControl {

    public int getValue(String nameExtras){

        switch (nameExtras) {
            case "Medallones":
                return 5;
            case "Frijoles":
                return 0;
         case "Queso":
                return 3;
         case "Pan":
                return 1;
            case "Tortillas":
                return 1;
                
            case "Bebida":
                return 6;
            case "Fruta":
                return 7;
            case "Jugo de naranja":
                return 10;
                
               case "Torta de carne":
                return 8;
            case "Queso amarillo":
                return 3;
            case "Helado":
                return 5;
            case "Pastel":
                return 15;
            case "Flan":
                return 10;
            case "Gelatina":
                return 5;
                  case "Huevos":
                return 7;
                            case "Platanos":
                return 5;
                            case "Crema":
                return 3;
                   
            default:
                return 0;
        }
    }
}
