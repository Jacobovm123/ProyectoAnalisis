package gt.com.proyectoanalisis2.model;

import javax.servlet.http.HttpServletRequest;

public interface InterfazOrderControl {
    public Campos_pedido createOrder(HttpServletRequest request);
}
