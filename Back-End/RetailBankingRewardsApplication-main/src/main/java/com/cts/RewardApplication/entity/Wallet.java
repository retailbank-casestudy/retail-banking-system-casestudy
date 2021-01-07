package com.cts.RewardApplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter	
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
	@Id
	private int customerId;
	private int walletAmount;
}
