package org.champsoft.likeaholicbackend.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    User deleteByUserId(String userId);
}
