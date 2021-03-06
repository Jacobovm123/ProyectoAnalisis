package gt.com.proyectoanalisis2.model;

import gt.com.proyectoanalisis2.controller.Controlador;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboDosAlmuerzo implements InterfazOrderControl{
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

        alternativa.add(request.getParameter("alt_ensalada"));
        alternativa.add(request.getParameter("alt_pollo"));
        alternativa.add(request.getParameter("alt_sopa"));
        alternativa.add(request.getParameter("alt_bebida"));


        nuevoMenu.add(menu.menus(request.getParameter("combo")).get(0)+" ["+alternativa.get(0)+"]");
        nuevoMenu.add(menu.menus(request.getParameter("combo")).get(1)+" ["+alternativa.get(1)+"]");
        nuevoMenu.add(menu.menus(request.getParameter("combo")).get(2)+" ["+alternativa.get(2)+"]");
        nuevoMenu.add(menu.menus(request.getParameter("combo")).get(3)+" ["+alternativa.get(3)+"]");

        order.setMenu(nuevoMenu);

        Map<String,String> extras = new HashMap<>();
        extras.put("Torta de carne",request.getParameter("extra_carne"));
        extras.put("Queso amarillo",request.getParameter("extra_quesoA"));
        extras.put("Helado",request.getParameter("extra_helado"));
        extras.put("Pastel",request.getParameter("extra_pastel"));
        extras.put("Flan",request.getParameter("extra_flan"));
        extras.put("Gelatina",request.getParameter("extra_gelatina"));

        List<String>listaFood = new ArrayList<>();


        listaFood.add("Torta de carne");
        listaFood.add("Queso amarillo");
        listaFood.add("Helado");
        listaFood.add("Pastel");
        listaFood.add("Flan");
        listaFood.add("Gelatina");

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
