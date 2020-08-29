package gt.com.proyectoanalisis2.model;

import javax.servlet.http.HttpServletRequest;

public class NullObject implements InterfazOrderControl{
    @Override
    public OrderEntity createOrder(HttpServletRequest request) {
        OrderEntity order = new OrderEntity();
        order.setCashier("El menu no se encuentra");
        order.setOrder("Upps parece que algo salio mal");
        order.setCustomer("Verifique su orden ");
        order.setTaxId("Error inesperado ");
        return order;
    }


}
