package com.goodhealth.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the drug database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="drug")
public class Drug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="drug_id")
	private int drugId;

	@Column(name="drug_character")
	private String drugCharacter;

	@Column(name="drug_component")
	private String drugComponent;

	@Column(name="drug_function")
	private String drugFunction;

	@Column(name="drug_integral")
	private int drugIntegral;

	@Column(name="drug_status")
	private int drugStatus;

	@Column(name="drug_name")
	private String drugName;

	@Column(name="drug_pic")
	private String drugPic;

	@Column(name="drug_price")
	private BigDecimal drugPrice;

	@Column(name="drug_productor")
	private String drugProductor;

	@Column(name="drug_storage")
	private String drugStorage;

	@Column(name="drug_usage")
	private String drugUsage;

	//bi-directional many-to-one association to Shoppingcar
	@OneToMany(mappedBy="drug")
	private List<Shoppingcar> shoppingcars;

	public Shoppingcar addShoppingcar(Shoppingcar shoppingcar) {
		getShoppingcars().add(shoppingcar);
		shoppingcar.setDrug(this);
		return shoppingcar;
	}

	public Shoppingcar removeShoppingcar(Shoppingcar shoppingcar) {
		getShoppingcars().remove(shoppingcar);
		shoppingcar.setDrug(null);
		return shoppingcar;
	}

}