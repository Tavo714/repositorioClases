package pe.edu.idat.dsi.daa2.datacampusback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.idat.dsi.daa2.datacampusback.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{ 
    //User es la clase creada, (pe.edu.idat...) no la de springboot. El Long es por el tipo de dato de identidad (id)
       
}
