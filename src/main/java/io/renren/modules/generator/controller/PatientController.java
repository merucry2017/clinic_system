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

import io.renren.modules.generator.entity.PatientEntity;
import io.renren.modules.generator.service.PatientService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 我的患者
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-12-05 23:57:17
 */
@RestController
@RequestMapping("generator/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:patient:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = patientService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:patient:info")
    public R info(@PathVariable("id") Integer id){
		PatientEntity patient = patientService.getById(id);

        return R.ok().put("patient", patient);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:patient:save")
    public R save(@RequestBody PatientEntity patient){
		patientService.save(patient);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:patient:update")
    public R update(@RequestBody PatientEntity patient){
		patientService.updateById(patient);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:patient:delete")
    public R delete(@RequestBody Integer[] ids){
		patientService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
