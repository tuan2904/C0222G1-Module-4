package com.example.formregister.repository;

import com.example.formregister.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface IRegisterRepository extends JpaRepository<Register, Integer> {
    @Query(value = "select * from register_table", nativeQuery = true)
    List<Register> listMusic();
}
