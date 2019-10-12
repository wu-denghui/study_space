package com.goodhealth.framework.entity.user;


/**
 * 用户信息
 */
public class UserContextEntity {

	/**
	 * json中，user的key
	 */
	public static final String JSON_FIELD_USER = "com/goodhealth/framework/entity/user";

	/**
	 * 用户对象
	 */
	private IUser user;

	/**
	 * 用户id
	 */
	private String id;

	/**
	 * 客户端用户信息
	 */
	private UserClientInfoEntity userClientInfoEntity;



	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserClientInfoEntity getUserClientInfoEntity() {
		return userClientInfoEntity;
	}

	public void setUserClientInfoEntity(
			UserClientInfoEntity userClientInfoEntity) {
		this.userClientInfoEntity = userClientInfoEntity;
	}

}
