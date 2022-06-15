package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.smartech.vendorportal.entities.RfqLine;

@Repository
public interface RfqLineRepository extends JpaRepository <RfqLine, Long> {
	@Query("SELECT r FROM RfqLine r WHERE r.rfq.id =?1 ")
	List<RfqLine> findAllRfqByUser(Long id);

}
