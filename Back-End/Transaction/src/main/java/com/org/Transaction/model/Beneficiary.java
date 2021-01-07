package com.org.Transaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Beneficiary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long beneficiaryAccountNumber;
	
	private String beneficiaryAccountName;

	public Beneficiary() {
		super();
	}

	public Beneficiary(long beneficiaryAccountNumber, String beneficiaryAccountName) {
		super();
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryAccountName = beneficiaryAccountName;
	}

	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getBeneficiaryAccountName() {
		return beneficiaryAccountName;
	}

	public void setBeneficiaryAccountName(String beneficiaryAccountName) {
		this.beneficiaryAccountName = beneficiaryAccountName;
	}

	@Override
	public String toString() {
		return "Beneficiary [beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", beneficiaryAccountName="
				+ beneficiaryAccountName + "]";
	}
	
	
	
}
