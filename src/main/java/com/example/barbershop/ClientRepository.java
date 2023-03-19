package com.example.barbershop;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface ClientRepository extends JpaRepository<Client, Long>{
    @Query("SELECT p FROM Client p WHERE CONCAT(p.FIO, ' ', p.date_z, ' ', p.usluga, ' ', p.barber) LIKE %?1%")
    List<Client> search(String keyword);
}

