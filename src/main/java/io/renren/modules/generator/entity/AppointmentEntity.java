package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 我的挂号
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-12-05 23:57:17
 */
@Data
@TableName("appointment")
public class AppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 挂号信息表
	 */
	@TableId
	private Integer id;
	/**
	 * 病人姓名
	 */
	private String patientName;
	/**
	 * 医生姓名
	 */
	private String doctorName;
	/**
	 * 挂号费
	 */
	private Integer cost;
	/**
	 * 预约时间
	 */
	private String appointmentTime;

}
