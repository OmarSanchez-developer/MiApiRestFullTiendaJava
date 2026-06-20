package com.methaporce.tienda.Repositories;

import com.methaporce.tienda.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Es una anotación
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>
{
    // CRUD = CREATE, READ, UPDATE, DELETE

}
