package com.example.BCPAPI.controller;

import com.example.BCPAPI.entity.Local;
import com.example.BCPAPI.repository.LocalRepository;
import com.example.BCPAPI.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/locales")
public class LocalController {

    @Autowired
    private LocalRepository localRepository;


    @GetMapping
    public String listar(Model model) {
        model.addAttribute("locales", localRepository.findAll());
        return "lista-locales"; // Busca un archivo llamado lista-locales.html
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Local local = localRepository.findById(id).orElse(null);
        model.addAttribute("local", local);
        return "formulario-local";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Local local, RedirectAttributes redirect) {
        try {
            localRepository.save(local);
            redirect.addFlashAttribute("success", "¡Local actualizado correctamente!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Error al actualizar el local.");
        }
        return "redirect:/locales";
    }


    @GetMapping("/ver-locales")
    public String mostrarLista(Model model) {

        model.addAttribute("listaDeLocales", localRepository.findAll());
        return "lista-locales"; // Debe coincidir con tu archivo lista-locales.html
    }

    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/ver-managers")
    public String listarManagers(Model model) {
        model.addAttribute("listaManagers", managerRepository.findAll());
        return "lista-managers";
    }

}