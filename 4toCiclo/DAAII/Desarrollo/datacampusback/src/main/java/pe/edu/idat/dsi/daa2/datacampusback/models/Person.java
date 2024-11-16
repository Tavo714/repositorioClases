package pe.edu.idat.dsi.daa2.datacampusback.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //para que se marque como una entidad de base de datos -jakarta
@Table(name="person") //para crear la tabla en mysql -jakarta
@Data //Para que no requiera de getters and setters -lombok
@AllArgsConstructor //Constructor con parametros -lombok
@NoArgsConstructor

public class Person {

    @Id //Se esta creando la PK con característica UNIQUE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="nid")
    private String nid;
    @Column(name="birthdate")
    private Date birthDate;

    
    //Relacion 1 a 1 Padre
    @OneToOne(mappedBy = "person")
    //Administrado por usuario. Los dos evitan el bucle infinito.
    @JsonBackReference
    private User user;

    //Relacion 1 a muchos
    
    @OneToMany(mappedBy = "person")
    @JsonManagedReference
    private List<Address> addresses;
}
