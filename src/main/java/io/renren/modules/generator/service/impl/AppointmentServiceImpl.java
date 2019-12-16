package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.AppointmentDao;
import io.renren.modules.generator.entity.AppointmentEntity;
import io.renren.modules.generator.service.AppointmentService;


@Service("appointmentService")
public class AppointmentServiceImpl extends ServiceImpl<AppointmentDao, AppointmentEntity> implements AppointmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AppointmentEntity> page = this.page(
                new Query<AppointmentEntity>().getPage(params),
                new QueryWrapper<AppointmentEntity>()
        );

        return new PageUtils(page);
    }

}