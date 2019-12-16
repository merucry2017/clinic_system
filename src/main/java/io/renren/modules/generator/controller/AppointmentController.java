package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.AppointmentEntity;
import io.renren.modules.generator.service.AppointmentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 我的挂号
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-12-05 23:57:17
 */
@RestController
@RequestMapping("generator/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:appointment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = appointmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:appointment:info")
    public R info(@PathVariable("id") Integer id){
		AppointmentEntity appointment = appointmentService.getById(id);

        return R.ok().put("appointment", appointment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:appointment:save")
    public R save(@RequestBody AppointmentEntity appointment){
		appointmentService.save(appointment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:appointment:update")
    public R update(@RequestBody AppointmentEntity appointment){
		appointmentService.updateById(appointment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:appointment:delete")
    public R delete(@RequestBody Integer[] ids){
		appointmentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
