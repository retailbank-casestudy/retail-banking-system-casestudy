package com.cts.RewardApplication.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cts.RewardApplication.entity.Rewards;
import com.cts.RewardApplication.entity.Wallet;

@Component
public interface RewardsService {
	public List<Rewards> getAllRewards(int id);

	public void addreward(Rewards r);

	public boolean ClaimReward(int rid,int cid);

	public Wallet getwallettopup(int id);


	
}
