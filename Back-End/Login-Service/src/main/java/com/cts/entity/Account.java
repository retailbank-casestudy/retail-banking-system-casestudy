package com.cts.entity;


import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	private Double userid;
	private BigInteger accountNo;
	private String accountType;
	private String accountNickName;
	private BigInteger accountBalance;
	
}
