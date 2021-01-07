package com.cts.RewardApplication.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cts.RewardApplication.entity.Rewards;

@Component
public class RewardHelper {
	
	public int getRewardAmount(int tAmount) {
		int amount=0;
		amount=(5*tAmount)/100;
		return amount;
	}
	public List<Rewards> getActiveOrders(List<Rewards> allRewards) {
		return allRewards.stream().filter((a) -> a.getRewardStatus().equalsIgnoreCase("active"))
		.collect(Collectors.toList());
	}


}
