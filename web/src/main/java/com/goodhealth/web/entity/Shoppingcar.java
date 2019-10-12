package com.goodhealth.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the shoppingcar database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="shoppingcar")
public class Shoppingcar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="record_id")
	private int recordId;

	@Column(name="record__date")
	private String recordDate;

	@Column(name="record_number")
	private int recordNumber;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="drug_id")
	private Drug drug;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;

}