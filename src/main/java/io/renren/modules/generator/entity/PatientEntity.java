package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 我的患者
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-12-05 23:57:17
 */
@Data
@TableName("patient")
public class PatientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 挂号编号
	 */
	@TableId
	private Integer id;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 真实姓名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 地址
	 */
	private String addr;

}
