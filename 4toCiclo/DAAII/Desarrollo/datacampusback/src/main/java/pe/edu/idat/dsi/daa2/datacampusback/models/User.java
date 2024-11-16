package pe.edu.idat.dsi.daa2.datacampusback.models;

import java.util.List;


//import org.hibernate.mapping.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //para que se marque como una entidad de base de datos -jakarta
@Table(name="user") //para crear la tabla en mysql -jakarta
@Data //Para que no requiera de getters and setters -lombok
@AllArgsConstructor //Constructor con parametros -lombok
@NoArgsConstructor //Constructor vacio -lombok

public class User {

    @Id //Se esta creando la PK con característica UNIQUE
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para que incremente de 1 en 1 (autoincremental)

    //Los valores ahora son PRIVADOS, por eso se usa LOMBOK

    private Long id; //Long reemplaza al int. Es con mayuscula
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="phone_number") //Se cambia a guion bajo por nomenclatura de SQL
    private String phoneNumber;     

    //@JsonIgnore Otra opcion. Elimina el atributo

    
    //Relacion 1 a 1 Hijo
    @OneToOne    
    @JoinColumn(name="person_id")
    //Objeto padre para opcion recursiva
    @JsonManagedReference 
    private Person person;

    //Racion muchos a muchos
    @ManyToMany(mappedBy = "users")
    @JsonManagedReference
    private List<Course> courses;

}
