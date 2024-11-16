package pe.edu.idat.dsi.daa2.datacampusback.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import pe.edu.idat.dsi.daa2.datacampusback.models.User;
import pe.edu.idat.dsi.daa2.datacampusback.repositories.UserRepository;

@Service
public class UserService {

    //@Autowired //Inyecta la dependencia en el repositor implicito
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    //CREAR
    public User insert(User entity){ //era createUser
        return userRepository.saveAndFlush(entity); //saveAndFlush confirma en cambio en algunas DB como ORACLE
    }

    //MODIFICAR
    public User update(User entity){
        Optional<User> response = userRepository.findById(entity.getId());
        if(!response.isPresent()){
            return null;
        }
        User toUpdate = response.get();
        toUpdate.setName(entity.getName());
        toUpdate.setLastname(entity.getLastname());
        toUpdate.setUsername(entity.getUsername());
        toUpdate.setPassword(entity.getPassword());
        toUpdate.setEmail(entity.getEmail());
        toUpdate.setPhoneNumber(entity.getPhoneNumber());

        return userRepository.saveAndFlush(entity);

        //me trabe 19:59
    }

    //ELIMINAR
    public boolean delete(Long id){

        userRepository.deleteById(id);
        return true;
    }

    //LISTAR
    public List<User> getAll(){//Si list da error, quickfix e importar de java.util
        return userRepository.findAll();
    }

    //BUSCAR
    public User getById(Long id){
        Optional<User> response = userRepository.findById(id); //El optional viene de java.util con quickfix
        if(!response.isPresent()){ //con el if, si no esta devuelve nulo
            return null;
        }
        return response.get();
    }

}
