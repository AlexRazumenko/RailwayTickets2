package org.alex.railway.tickets.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table( name="trains",
        uniqueConstraints={@UniqueConstraint(columnNames={"number"})})
public class Train {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "departstation", nullable = false)
    private Station departStation;

    @Column(name = "arrivestation", nullable = false)
    private Station arriveStation;

    @Column(name = "departtime", nullable = false)
    private LocalTime departTime;

    @Column(name = "arrivetime", nullable = false)
    private LocalTime arriveTime;




//    private Predicate<Train> periodicity;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "train", targetEntity = Ticket.class)
    private List<Ticket> tickets;



}
