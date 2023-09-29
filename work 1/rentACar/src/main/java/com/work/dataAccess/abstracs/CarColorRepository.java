package com.work.dataAccess.abstracs;



import com.work.entities.concrates.CarColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarColorRepository extends JpaRepository<CarColor,Integer> {

}
