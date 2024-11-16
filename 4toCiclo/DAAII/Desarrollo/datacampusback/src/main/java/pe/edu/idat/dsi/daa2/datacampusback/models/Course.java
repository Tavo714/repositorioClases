package pe.edu.idat.dsi.daa2.datacampusback.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //para que se marque como una entidad de base de datos -jakarta
@Table(name="course") //para crear la tabla en mysql -jakarta
@Data //Para que no requiera de getters and setters -lombok
@AllArgsConstructor //Constructor con parametros -lombok
@NoArgsConstructor

public class Course {

    @Id //Se esta creando la PK con característica UNIQUE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="credits")
    private int credits;
    @Column(name="code")
    private String code;
    @Column(name="weekly_hours")
    private double weeklyHours;


    //Relacion muchos a muchos (hijo)
    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name = "user_course", //(user es el padre, course el hijo)
               joinColumns = @JoinColumn(name="course_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id"))
    @JsonBackReference
    private List<User> users;

}
