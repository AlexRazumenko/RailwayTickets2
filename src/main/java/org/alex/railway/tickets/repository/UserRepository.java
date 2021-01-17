package org.alex.railway.tickets.repository;

import org.alex.railway.tickets.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail (String email);

    public default int getCount() {
        return findAll().size();
    }

}
