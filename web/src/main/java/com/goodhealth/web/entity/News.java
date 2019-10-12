package com.goodhealth.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the new database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="news")
public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="new_id")
	private int newId;

	@Column(name="new_author")
	@NotBlank(message="发布者不得为空")
	private String newAuthor;

	@Column(name="new_date")
	private String newDate;

	@Column(name="new_detail")
	@NotBlank(message="详情不得为空")
	private String newDetail;

	@Column(name="new_url")
	@NotBlank(message="链接不得为空")
	private String newUrl;

	@Column(name="new_title")
	@NotBlank(message="标题不得为空")
	private String newTitle;
}