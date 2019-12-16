package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.PatientDao;
import io.renren.modules.generator.entity.PatientEntity;
import io.renren.modules.generator.service.PatientService;


@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientDao, PatientEntity> implements PatientService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PatientEntity> page = this.page(
                new Query<PatientEntity>().getPage(params),
                new QueryWrapper<PatientEntity>()
        );

        return new PageUtils(page);
    }

}