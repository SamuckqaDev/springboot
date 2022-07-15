package br.com.matsutech.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.matsutech.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    String FIND_ALL_MORE_THAN = "FROM User u WHERE u.id > :id";

    @Query(value = FIND_ALL_MORE_THAN)
    List<User> findAllMoreThan(@Param("id") Long id);

    List<User> findByIdGreaterThan(Long id);

    List<User> findByNameIgnoreCase(String name);

}
