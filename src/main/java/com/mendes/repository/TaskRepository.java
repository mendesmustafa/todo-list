package com.mendes.repository;

import com.mendes.entity.Task;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mendes
 */

@Repository
public interface TaskRepository extends CouchbaseRepository<Task, Long> {
}
