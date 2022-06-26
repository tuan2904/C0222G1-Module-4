package com.example.furama.repository;

import com.example.furama.model.Customer;
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
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name_customer like :name_customer", nativeQuery = true)
    Page<Customer> search(@Param("name_customer") String name, Pageable pageable);

    @Modifying
    @Query(value = "delete from customer where id_customer=:id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value="select * from customer where id_customer=:id",nativeQuery=true)
    Customer findId(@Param("id") int id);
    @Modifying
    @Query(value = "update customer set id_customer_type=:id_customer_type, name_customer=:name_customer,birth_day_customer=:birth_day_customer," +
            "gender=:gender,id_car_customer=:id_car_customer,phone=:phone,email=:email,address=:address where id_customer=:id_customer", nativeQuery = true)
    void editCustomer(@Param("id_customer_type") int idCustomerType ,@Param("name_customer") String name, @Param("birth_day_customer") String birthday,
                      @Param("gender") String gender, @Param("id_car_customer") String idCar,
                      @Param("phone") String phone, @Param("email") String email, @Param("address") String address, @Param("id_customer") int id);
}
