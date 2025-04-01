package com.ruoyi.zhangyan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zhangyan.domain.CompActivity;
import com.ruoyi.zhangyan.service.ICompActivityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文化活动Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/system/activity")
public class CompActivityController extends BaseController {
    private String prefix = "system/activity";

    @Autowired
    private ICompActivityService compActivityService;

    @RequiresPermissions("system:activity:view")
    @GetMapping()
    public String activity() {
        return prefix + "/activity";
    }

    /**
     * 查询文化活动列表
     */
    @RequiresPermissions("system:activity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompActivity compActivity) {
        startPage();
        List<CompActivity> list = compActivityService.selectCompActivityList(compActivity);
        return getDataTable(list);
    }

    /**
     * 导出文化活动列表
     */
    @RequiresPermissions("system:activity:export")
    @Log(title = "文化活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompActivity compActivity) {
        List<CompActivity> list = compActivityService.selectCompActivityList(compActivity);
        ExcelUtil<CompActivity> util = new ExcelUtil<CompActivity>(CompActivity.class);
        return util.exportExcel(list, "文化活动数据");
    }

    /**
     * 新增文化活动
     */
    @RequiresPermissions("system:activity:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文化活动
     */
    @RequiresPermissions("system:activity:add")
    @Log(title = "文化活动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompActivity compActivity) {
        return toAjax(compActivityService.insertCompActivity(compActivity));
    }

    /**
     * 修改文化活动
     */
    @RequiresPermissions("system:activity:edit")
    @GetMapping("/edit/{activityId}")
    public String edit(@PathVariable("activityId") Long activityId, ModelMap mmap) {
        CompActivity compActivity = compActivityService.selectCompActivityByActivityId(activityId);
        mmap.put("compActivity", compActivity);
        return prefix + "/edit";
    }

    /**
     * 修改保存文化活动
     */
    @RequiresPermissions("system:activity:edit")
    @Log(title = "文化活动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompActivity compActivity) {
        return toAjax(compActivityService.updateCompActivity(compActivity));
    }

    /**
     * 删除文化活动
     */
    @RequiresPermissions("system:activity:remove")
    @Log(title = "文化活动", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(compActivityService.deleteCompActivityByActivityIds(ids));
    }
}
