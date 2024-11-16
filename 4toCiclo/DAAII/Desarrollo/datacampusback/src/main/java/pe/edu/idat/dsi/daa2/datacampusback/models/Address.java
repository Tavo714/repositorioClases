package pe.edu.idat.dsi.daa2.datacampusback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //para que se marque como una entidad de base de datos -jakarta
@Table(name="address") //para crear la tabla en mysql -jakarta
@Data //Para que no requiera de getters and setters -lombok
@AllArgsConstructor //Constructor con parametros -lombok
@NoArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="avenue")
    private String avenue;
    @Column(name="number")
    private String number;
    @Column(name="location")
    private String location;

    //Relacion Muchos a 1
    
    @ManyToOne    
    @JoinColumn(name="person_id")
    @JsonBackReference
    private Person person;

}
