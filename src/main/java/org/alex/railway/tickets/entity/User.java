package org.alex.railway.tickets.entity;

import lombok.*;
import org.alex.railway.tickets.entity.enums.RoleType;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table( name="users",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {



    public User(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Ticket.class)
    private List<Ticket> tickets;

    private void m() {

    }
}
