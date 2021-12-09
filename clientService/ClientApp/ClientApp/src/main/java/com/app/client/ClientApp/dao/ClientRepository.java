package com.app.client.ClientApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.client.ClientApp.entity.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
