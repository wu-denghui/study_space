package com.goodhealth.web.entity;

import com.goodhealth.web.controller.ValidGroup1;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name="orders")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private String orderId;

	@Column(name="member_id")
	private int memberId;

	@Column(name="order_address")
	@NotBlank(message="联系地址不能为空",groups={ValidGroup1.class})
	private String orderAddress;

	@Column(name="order_award")
	private int orderAward;
	
	@Column(name="order_contacts")
	@NotBlank(message="联系人不能为空",groups={ValidGroup1.class})
	private String orderContacts;

	@Column(name="order_count")
	private BigDecimal orderCount;

	@Column(name="order_date")
	private String orderDate;

	@Column(name="order_detail")
	private String orderDetail;
	
	
	@Column(name="order_additional")
	private String orderAdditional;


	@Column(name="order_status")
	private int orderStatus;

	@Column(name="order_tell")
	@NotBlank(message="联系电话不能为空" ,groups={ValidGroup1.class})
	@Pattern(regexp="^1\\d{10}$",message="请输入正确的电话号码",groups={ValidGroup1.class})
	private String orderTell;

}