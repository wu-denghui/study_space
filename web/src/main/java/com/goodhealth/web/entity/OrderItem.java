package com.goodhealth.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the order_item database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="order_item")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="drug_id")
	private int drugId;

	@Column(name="num")
	private int num;

	@Column(name="order_id")
	private String orderId;
}