package com.cts.RewardApplication.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Rewards")
public class Rewards {
	
	@Id
	@SequenceGenerator(name="seq", initialValue=1000,allocationSize = 2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int rewardId;
	private int customerId;
	private String rewardName;
	private int rewardAmount;
	private String rewardStatus;
	private LocalDate rewardExpiryDate;
	public Rewards(int customerId, String rewardName, int rewardAmount, String rewardStatus,
			LocalDate rewardExpiryDate) {
		super();
		this.customerId = customerId;
		this.rewardName = rewardName;
		this.rewardAmount = rewardAmount;
		this.rewardStatus = rewardStatus;
		this.rewardExpiryDate = rewardExpiryDate;
	}
	
	
	
	

}
