package com.zander404.mseventmanager.reposistory;

import com.zander404.mseventmanager.entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
