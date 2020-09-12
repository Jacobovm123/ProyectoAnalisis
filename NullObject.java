package gt.com.proyectoanalisis2.model;

import javax.servlet.http.HttpServletRequest;

public class NullObject implements InterfazOrderControl{
    @Override
    public Campos_pedido createOrder(HttpServletRequest request) {
        Campos_pedido order = new Campos_pedido();
        order.setCashier("El menu no se encuentra");
        order.setOrder("Upps parece que algo salio mal");
        order.setCustomer("Verifique su orden ");
        order.setTaxId("Error inesperado ");
        return order;
    }


}
