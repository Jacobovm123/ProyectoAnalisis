package gt.com.proyectoanalisis2.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface InterfazControlArchivo {
    public void createFile(OrderEntity order) throws IOException;
}
