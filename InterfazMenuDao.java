package gt.com.proyectoanalisis2.model;


import java.util.List;

public interface InterfazMenuDao {
    public List<String> menus(String nameMenu);
    public int getPrecioMenu(String whatMenu);
}
