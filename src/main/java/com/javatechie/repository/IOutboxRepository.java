package com.javatechie.repository;

import com.javatechie.entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOutboxRepository extends JpaRepository<Outbox, Long>{
}
