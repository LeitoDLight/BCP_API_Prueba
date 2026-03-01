package com.example.BCPAPI;

import com.example.BCPAPI.entity.Local;
import com.example.BCPAPI.entity.Manager;
import com.example.BCPAPI.repository.LocalRepository;
import com.example.BCPAPI.repository.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BcpapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcpapiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(LocalRepository localRepo, ManagerRepository managerRepo) {
        return args -> {
            // CAMBIO: Si no hay locales (la base está vacía), creamos todo
            if (localRepo.count() == 0) {
                System.out.println(">>> Base de datos vacía en Azure. Iniciando carga de datos...");

                String[] nombresLocales = {"Agencia Centro", "Agencia Norte", "Agencia Sur", "Agencia Este", "Agencia Oeste"};
                String[] nombresManagers = {"Juan", "Maria", "Pedro", "Ana", "Luis"};
                String[] apellidosManagers = {"Perez", "Gomez", "Soto", "Torres", "Ramos"};

                for (int i = 0; i < 5; i++) {


                    Local nuevoLocal = new Local();
                    nuevoLocal.setName(nombresLocales[i]);
                    nuevoLocal.setFloor("Piso " + (i + 1)); // Usa setFloor en lugar de setAddress
                    localRepo.save(nuevoLocal);


                    Manager m = new Manager();
                    m.setFirstName(nombresManagers[i]);
                    m.setLastName(apellidosManagers[i]);
                    m.setLocal(nuevoLocal); // Relación 1 a 1

                    managerRepo.save(m);
                }
                System.out.println(">>> Datos de Azure cargados con éxito: 5 Locales y 5 Managers.");
            } else {
                System.out.println(">>> La base de datos ya tiene datos, omitiendo carga inicial.");
            }
        };
    }
}
