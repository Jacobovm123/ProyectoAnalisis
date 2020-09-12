package gt.com.proyectoanalisis2.model;

import gt.com.proyectoanalisis2.controller.Controlador;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboDosCena implements InterfazOrderControl {
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

        alternativa.add(request.getParameter("alt_fajitas"));
        alternativa.add(request.getParameter("alt_vegetales"));
        alternativa.add(request.getParameter("alt_bebida"));


        nuevoMenu.add(menu.menus(request.getParameter("combo")).get(0)+" ["+alternativa.get(0)+"]");
        nuevoMenu.add(menu.menus(request.getParameter("combo")).get(1)+" ["+alternativa.get(1)+"]");
        nuevoMenu.add(menu.menus(request.getParameter("combo")).get(3)+" ["+alternativa.get(2)+"]");

        order.setMenu(nuevoMenu);

        Map<String,String> extras = new HashMap<>();
     
        extras.put("Frijoles",request.getParameter("extra_frijoles"));
        extras.put("Platanos",request.getParameter("extra_platanos"));
        extras.put("Crema",request.getParameter("extra_crema"));
        extras.put("Pan",request.getParameter("extra_pan"));
        extras.put("Jugo de naranja",request.getParameter("extra_jugon"));

        List<String>listaFood = new ArrayList<>();


   
        listaFood.add("Frijoles");
        listaFood.add("Platanos");
        listaFood.add("Crema");
        listaFood.add("Pan");
        listaFood.add("Jugo de naranja");

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
