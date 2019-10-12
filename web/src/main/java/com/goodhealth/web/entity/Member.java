package com.goodhealth.web.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the member database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private Integer memberId;

	@Column(name="address")
	private String address;

	@Column(name="province")
	private String province;

	@Column(name="city")
	private String city;

	@Column(name="area")
	private String area;

	@Column(name="member_birthday")
	private String memberBirthday;

	@Column(name="member_email")
	@Email(message="请输入正确的邮箱地址")
	private String memberEmail;

	@Column(name="member_gender")
	@NotNull(message="性别不可以为空")
	private Integer memberGender;

	@Column(name="member_integral")
	private Integer memberIntegral;

	@Column(name="member_name")
	@NotBlank(message="用户名不能为空")
	@Pattern(regexp="^[\\u0391-\\uFFE50-Za-z0-9]{4,10}$",message="用户名为4~10位中文、英文、数字但不包括下划线等符号")
	private String memberName;

	@Column(name="member_password")
	@NotBlank(message="密码不能为空")
//	@Pattern(regexp="^[a-zA-Z]\\w{5,15}$",message="密码以字母开头，长度在5~15之间，只能包含字母、数字")
	private String memberPassword;

	private String password2;

	@Column(name="member_status")
	private Integer memberStatus;

	@Column(name="member_tell")
	@NotNull
	@Pattern(regexp="^1\\d{10}$",message="请输入正确11位手机号")
	private String memberTell;

	//bi-directional many-to-one association to Shoppingcar
	@OneToMany(mappedBy="member")
	private List<Shoppingcar> shoppingcars;

	public Shoppingcar addShoppingcar(Shoppingcar shoppingcar) {
		getShoppingcars().add(shoppingcar);
		shoppingcar.setMember(this);
		return shoppingcar;
	}

	public Shoppingcar removeShoppingcar(Shoppingcar shoppingcar) {
		getShoppingcars().remove(shoppingcar);
		shoppingcar.setMember(null);
		return shoppingcar;
	}

}