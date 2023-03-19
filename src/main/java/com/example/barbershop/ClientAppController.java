package com.example.barbershop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientAppController {

    @Autowired
    private ClientService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Client> listClient = service.listAll(keyword);
        model.addAttribute("listDevice", listClient);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewDeviceForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDevice(@ModelAttribute("client") Client client) {
        service.save(client);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditDeviceForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_client");
        Client client = service.get(id);
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteDevice(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
