package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.AppointmentEntity;

import java.util.Map;

/**
 * 我的挂号
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-12-05 23:57:17
 */
public interface AppointmentService extends IService<AppointmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

