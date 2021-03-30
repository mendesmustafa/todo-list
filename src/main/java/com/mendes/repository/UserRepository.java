package com.mendes.repository;

import com.mendes.entity.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mendes
 */
@Repository
public interface UserRepository extends CouchbaseRepository<User, Long> {
}
