package com.rabbitmqmessagingappB.repositories;

import com.rabbitmqmessagingappB.entites.ReceievedData;
import org.springframework.data.repository.CrudRepository;

public interface DbRepositories extends CrudRepository<ReceievedData, Integer > {
}
