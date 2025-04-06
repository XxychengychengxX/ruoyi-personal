package com.ruoyi.zhangyan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zhangyan.domain.CompScore;
import com.ruoyi.zhangyan.service.ICompScoreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 成绩Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/zhangyan/score")
public class CompScoreController extends BaseController {
    private String prefix = "zhangyan/score";

    @Autowired
    private ICompScoreService compScoreService;

    @RequiresPermissions("zhangyan:score:view")
    @GetMapping()
    public String score() {
        return prefix + "/score";
    }

    /**
     * 查询成绩列表
     */
    @RequiresPermissions("zhangyan:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompScore compScore) {
        startPage();
        List<CompScore> list = compScoreService.selectCompScoreList(compScore);
        return getDataTable(list);
    }

    /**
     * 导出成绩列表
     */
    @RequiresPermissions("zhangyan:score:export")
    @Log(title = "成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompScore compScore) {
        List<CompScore> list = compScoreService.selectCompScoreList(compScore);
        ExcelUtil<CompScore> util = new ExcelUtil<CompScore>(CompScore.class);
        return util.exportExcel(list, "成绩数据");
    }

    /**
     * 新增成绩
     */
    @RequiresPermissions("zhangyan:score:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存成绩
     */
    @RequiresPermissions("zhangyan:score:add")
    @Log(title = "成绩", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompScore compScore) {
        return toAjax(compScoreService.insertCompScore(compScore));
    }

    /**
     * 修改成绩
     */
    @RequiresPermissions("zhangyan:score:edit")
    @GetMapping("/edit/{scoreId}")
    public String edit(@PathVariable("scoreId") Long scoreId, ModelMap mmap) {
        CompScore compScore = compScoreService.selectCompScoreByScoreId(scoreId);
        mmap.put("compScore", compScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存成绩
     */
    @RequiresPermissions("zhangyan:score:edit")
    @Log(title = "成绩", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompScore compScore) {
        return toAjax(compScoreService.updateCompScore(compScore));
    }

    /**
     * 删除成绩
     */
    @RequiresPermissions("zhangyan:score:remove")
    @Log(title = "成绩", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(compScoreService.deleteCompScoreByScoreIds(ids));
    }
}
