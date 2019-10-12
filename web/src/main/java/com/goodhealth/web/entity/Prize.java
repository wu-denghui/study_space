package com.goodhealth.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * The persistent class for the prize database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="prize")
public class Prize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prize_id")
	private int prizeId;

	@Column(name="prize_name")
	@NotBlank(message="积分奖品名不得为空")
	private String prizeName;

	@Column(name="prize_pic")
	@NotBlank(message="积分奖品图片不得为空")
	private String prizePic;

	@Column(name="prize_value")
	@NotNull(message="积分奖品兑换积分不得为空")
	private int prizeValue;

}