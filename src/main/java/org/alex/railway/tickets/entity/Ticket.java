package org.alex.railway.tickets.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table (name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;


private String departStation;

private String arriveStation;

    private LocalDate departLocalDate;




    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;


}
