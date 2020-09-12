package gt.com.proyectoanalisis2.model;

import javax.servlet.http.HttpServletRequest;

public interface InterfazOrderControl {
    public OrderEntity createOrder(HttpServletRequest request);
}
