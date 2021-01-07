package com.cts.RewardApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.RewardApplication.entity.Rewards;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Integer>{

	List<Rewards> findByCustomerId(int cid);
//	
//	@Query("select r from Rewards r where r.RewardStatus=:status")
//	public List<Rewards> getactiveorders(@Param("status") String status);

}
