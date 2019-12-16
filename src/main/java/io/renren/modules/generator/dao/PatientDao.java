package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.PatientEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 我的患者
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-12-05 23:57:17
 */
@Mapper
public interface PatientDao extends BaseMapper<PatientEntity> {
	
}
