package gt.com.proyectoanalisis2.model;

import gt.com.proyectoanalisis2.controller.Controlador;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboTresCena implements InterfazOrderControl {
    @Override
    public Campos_pedido createOrder(HttpServletRequest request) {
        int numberOrder =(int) (5 + Math.random()*20);
        Campos_pedido order = new Campos_pedido();

        //HEAD_ORDER
        System.out.println(Controlador.name);
        order.setOrder(Integer.toString(numberOrder));
        order.setCashier(Controlador.name);
        long millis = System.currentTimeMillis();
        order.setDate(new Date(millis));
        order.setCustomer(request.getParameter("text_customer"));
        order.setTaxId(request.getParameter("text_taxId"));

        //BODY_ORDER
        InterfazMenuDao menu = new MenuDao();
        List<String> nuevoMenu = new ArrayList<>();
        List<String>alternativa = new ArrayList<>();

        alternativa.add(request.getParameter("alt_pan"));
        alternativa.add(request.getParameter("alt_huevo"));
        alternativa.add(request.getParameter("alt_beicon"));
        alternativa.add(request.getParameter("alt_queso"));
        alternativa.add(request.getParameter("alt_bebida"));

        for(int i=0;i<menu.menus(request.getParameter("combo")).size();i++){
            nuevoMenu.add(menu.menus(request.getParameter("combo")).get(i)+" ["+alternativa.get(i)+"]");
        }
        order.setMenu(nuevoMenu);

        Map<String,String> extras = new HashMap<>();
        extras.put("Huevos",request.getParameter("extra_huevos"));
        extras.put("Platanos",request.getParameter("extra_platanos"));
        extras.put("Crema",request.getParameter("extra_crema"));
        extras.put("Pan",request.getParameter("extra_pan"));
  
        List<String>listaFood = new ArrayList<>();

        listaFood.add("Huevos");
        listaFood.add("Platanos");
        listaFood.add("Crema");
        listaFood.add("Pan");
 

        List<String> listExtras = new ArrayList<>();

        int totalExtras = 0;
        AdditionalControl add = new AdditionalControl();

        for (int i=0;i<extras.size();i++){
            totalExtras +=  add.getValue(listaFood.get(i)) * Integer.parseInt(extras.get(listaFood.get(i)));
            if(Integer.parseInt(extras.get(listaFood.get(i)))!=0){

                listExtras.add(listaFood.get(i) + " ("+extras.get(listaFood.get(i))+")");
            }
        }

        order.setExtras(listExtras);

        System.out.println(menu.getPrecioMenu(request.getParameter("combo"))+totalExtras);

        order.setTotal(menu.getPrecioMenu(request.getParameter("combo"))+totalExtras);

        //ORDEREND



        return order;
    }


}
