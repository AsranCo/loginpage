package ir.asran.loginpage.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String first_name;

    @Column(nullable=false, unique=true)
    private String last_name;


    @Column(nullable=false, unique=true)
    private String phone;
}
