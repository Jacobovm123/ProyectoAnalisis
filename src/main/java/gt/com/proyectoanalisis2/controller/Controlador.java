 package gt.com.proyectoanalisis2.controller;

import gt.com.proyectoanalisis2.model.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
 /**
 *
 * @author jacob
 */

@Controller
public class Controlador {
    public static String name;
    public static OrderEntity order;
    public static InterfazMenuDao menu = new MenuDao();
    private static File fileCreate;


    //Ingresar usuario (Cajero)
    @GetMapping("/")
    public String startControllerr(Model model){
        model.addAttribute("nameCashier", new DatosCajero());
        return "index";
    }

    @PostMapping("/")
    public String startController(Model model){
        return "menus";
    }

    //menus
   @GetMapping("/menus")
    public String menuController(Model model) {
       return getString(model);
   }



    @PostMapping("/menus")
    public String menuController(HttpServletRequest request,Model model) {
        name = request.getParameter("txt_name");
        model.addAttribute("nameCashier",name);

        return getString(model);
    }

    //VIEW ORDER
    @GetMapping("/factura")
    public String exitoController(Model model, HttpServletRequest request){
        System.out.println(order.getTotal());
        model.addAttribute("total",order.getTotal());

        return "factura";
    }
    @PostMapping("/factura")
    public String exitoController(HttpServletRequest request,Model model){
        ControlDeCombos menu = new ControlDeCombos();
        InterfazOrderControl createOrder = menu.getMenu(request.getParameter("combo"));
        order = createOrder.createOrder(request);

        model.addAttribute("nameCashier",name);
        model.addAttribute("order",order.getOrder());
        model.addAttribute("date",order.getDate());
        model.addAttribute("nameCustomer",order.getCustomer());
        model.addAttribute("taxId",order.getTaxId());
        model.addAttribute("combo",request.getParameter("combo"));
        model.addAttribute("total",order.getTotal());
        model.addAttribute("menu",order.getMenu());
        model.addAttribute("extras",order.getExtras());
        model.addAttribute("total",order.getTotal());

     

        return "factura";
    }
 

    private ResponseEntity<Object> getObjectResponseEntity(File file) throws FileNotFoundException {
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

    private String getString(Model model) {
        model.addAttribute("combo1",menu.menus("Combo 1"));
     
        model.addAttribute("nameCashier",name);
        return "menus";
    }

}
