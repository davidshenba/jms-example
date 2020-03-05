package com.shenba.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_TRANSACTIONS")
@Getter @Setter @ToString
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_ID")
	private Long transactionId;
	
	@Column(name = "T_DESC")
	private String description;
	
	@Column(name = "T_CRDTR")
	private String creditor;
	
	@Column(name = "T_DBTR")
	private String debitor;
	
	@Column(name = "T_TM_STMP")
	@CreationTimestamp
	private Date timeStamp; 
	
}
