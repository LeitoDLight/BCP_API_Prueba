package com.example.BCPAPI.controller;

import com.example.BCPAPI.entity.Local;
import com.example.BCPAPI.entity.Manager;
import com.example.BCPAPI.repository.LocalRepository;
import com.example.BCPAPI.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/bcp")
public class RegistroController {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @PostMapping("/registrar-lote")
    public String registrarCincoRegistros() {

        localRepository.registrarLocalNativo("Agencia Miraflores", "Piso 1");
        localRepository.registrarLocalNativo("Agencia San Isidro", "Piso 2");
        localRepository.registrarLocalNativo("Agencia Surco", "Piso 1");
        localRepository.registrarLocalNativo("Agencia La Molina", "Piso 3");
        localRepository.registrarLocalNativo("Agencia Los Olivos", "Piso 1");


        List<Local> localesRegistrados = localRepository.findAll();


        String[][] datosManagers = {
                {"Juan", "Perez"},
                {"Maria", "Gomez"},
                {"Carlos", "Ramirez"},
                {"Ana", "Torres"},
                {"Luis", "Fernandez"}
        };

        for (int i = 0; i < 5; i++) {
            Manager manager = new Manager();
            manager.setFirstName(datosManagers[i][0]);
            manager.setLastName(datosManagers[i][1]);
            manager.setLocal(localesRegistrados.get(i));

            managerRepository.save(manager);
        }

        return "Se registraron exitosamente 5 locales (Query Nativo) y 5 managers (OneToOne)";
    }
}