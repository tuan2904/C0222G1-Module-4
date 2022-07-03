package com.example.furama.repository;

import com.example.furama.model.Employee;
import com.example.furama.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where name_employee like :name_employee", nativeQuery = true)
    Page<Employee> search(@Param("name_employee") String name, Pageable pageable);

    @Modifying
    @Query(value = "delete from employee where id_employee=:id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from employee where id_employee=:id", nativeQuery = true)
    Employee findId(@Param("id") int id);

    @Modifying
    @Query(value = "update employee set address=:address,birth_day_employee=:birthday,email=:email,id_car_employee=:car," +
            "name_employee=:name,phone=:phone,salary=:salary,id_division=:division,id_education_degree=:education," +
            "id_position=:position,username=:user where id_employee=:id", nativeQuery = true)
    void update(@Param("address") String address, @Param("birthday") String birthday, @Param("email") String email, @Param("car")
            String car, @Param("name") String name, @Param("phone") String phone, @Param("salary") String salary,
                @Param("division") int division, @Param("education") int education, @Param("position") int position
            , @Param("user") String user, @Param("id") int id);
}
