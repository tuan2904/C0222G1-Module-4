package com.example.furama.repository;

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
public interface IServiceRepository extends JpaRepository<Service, Integer> {
    @Query(value = "select * from service where service_name like :service_name", nativeQuery = true)
    Page<Service> search(@Param("service_name") String name, Pageable pageable);

    @Modifying
    @Query(value = "delete from service where service_id=:id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from service where service_id=:id", nativeQuery = true)
    Service findId(@Param("id") int id);

    @Modifying
    @Query(value = "update service set service_name=:service_name,service_area=:service_area,service_cost=:service_cost,service_max_people=:service_max_people," +
            "id_rant_type=:id_rant_type,id_service_type=:id_service_type,service_room=:service_room,service_description=:service_description," +
            "service_pool_area=:service_pool_area,service_number_floors=:service_number_floors where service_id=:service_id", nativeQuery = true)
    void editService(@Param("service_name") String name, @Param("service_area") String area,
                     @Param("service_cost") String cost, @Param("service_max_people") String people,
                     @Param("id_rant_type") int rant, @Param("id_service_type") int serviceType, @Param("service_room") String room,
                     @Param("service_description") String description, @Param("service_pool_area") String pool, @Param("service_number_floors") String floors, @Param("service_id") int id);
}
