package com.ruoyi.zhangyan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zhangyan.domain.CompIndividualRegistration;
import com.ruoyi.zhangyan.service.ICompIndividualRegistrationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 个人报名Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/system/registration")
public class CompIndividualRegistrationController extends BaseController {
    private String prefix = "system/registration";

    @Autowired
    private ICompIndividualRegistrationService compIndividualRegistrationService;

    @RequiresPermissions("system:registration:view")
    @GetMapping()
    public String registration() {
        return prefix + "/registration";
    }

    /**
     * 查询个人报名列表
     */
    @RequiresPermissions("system:registration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompIndividualRegistration compIndividualRegistration) {
        startPage();
        List<CompIndividualRegistration> list = compIndividualRegistrationService.selectCompIndividualRegistrationList(compIndividualRegistration);
        return getDataTable(list);
    }

    /**
     * 导出个人报名列表
     */
    @RequiresPermissions("system:registration:export")
    @Log(title = "个人报名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompIndividualRegistration compIndividualRegistration) {
        List<CompIndividualRegistration> list = compIndividualRegistrationService.selectCompIndividualRegistrationList(compIndividualRegistration);
        ExcelUtil<CompIndividualRegistration> util = new ExcelUtil<CompIndividualRegistration>(CompIndividualRegistration.class);
        return util.exportExcel(list, "个人报名数据");
    }

    /**
     * 新增个人报名
     */
    @RequiresPermissions("system:registration:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存个人报名
     */
    @RequiresPermissions("system:registration:add")
    @Log(title = "个人报名", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompIndividualRegistration compIndividualRegistration) {
        return toAjax(compIndividualRegistrationService.insertCompIndividualRegistration(compIndividualRegistration));
    }

    /**
     * 修改个人报名
     */
    @RequiresPermissions("system:registration:edit")
    @GetMapping("/edit/{registrationId}")
    public String edit(@PathVariable("registrationId") Long registrationId, ModelMap mmap) {
        CompIndividualRegistration compIndividualRegistration = compIndividualRegistrationService.selectCompIndividualRegistrationByRegistrationId(
                registrationId);
        mmap.put("compIndividualRegistration", compIndividualRegistration);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人报名
     */
    @RequiresPermissions("system:registration:edit")
    @Log(title = "个人报名", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompIndividualRegistration compIndividualRegistration) {
        return toAjax(compIndividualRegistrationService.updateCompIndividualRegistration(compIndividualRegistration));
    }

    /**
     * 删除个人报名
     */
    @RequiresPermissions("system:registration:remove")
    @Log(title = "个人报名", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(compIndividualRegistrationService.deleteCompIndividualRegistrationByRegistrationIds(ids));
    }
}
