package com.ruoyi.zhangyan.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zhangyan.domain.CompCompetition;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 赛事项目Controller
 * 
 * @author XxychengychengxX
 * @date 2025-04-06
 */
@Controller
@RequestMapping("/zhangyan/competition")
public class CompCompetitionController extends BaseController
{
    private String prefix = "zhangyan/competition";

    @Autowired
    private ICompCompetitionService compCompetitionService;

    @RequiresPermissions("zhangyan:competition:view")
    @GetMapping()
    public String competition()
    {
        return prefix + "/competition";
    }

    /**
     * 查询赛事项目列表
     */
    @RequiresPermissions("zhangyan:competition:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompCompetition compCompetition)
    {
        startPage();
        List<CompCompetition> list = compCompetitionService.selectCompCompetitionList(compCompetition);
        return getDataTable(list);
    }

    /**
     * 导出赛事项目列表
     */
    @RequiresPermissions("zhangyan:competition:export")
    @Log(title = "赛事项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompCompetition compCompetition)
    {
        List<CompCompetition> list = compCompetitionService.selectCompCompetitionList(compCompetition);
        ExcelUtil<CompCompetition> util = new ExcelUtil<CompCompetition>(CompCompetition.class);
        return util.exportExcel(list, "赛事项目数据");
    }

    /**
     * 新增赛事项目
     */
    @RequiresPermissions("zhangyan:competition:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存赛事项目
     */
    @RequiresPermissions("zhangyan:competition:add")
    @Log(title = "赛事项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompCompetition compCompetition)
    {
        return toAjax(compCompetitionService.insertCompCompetition(compCompetition));
    }

    /**
     * 修改赛事项目
     */
    @RequiresPermissions("zhangyan:competition:edit")
    @GetMapping("/edit/{competitionId}")
    public String edit(@PathVariable("competitionId") Long competitionId, ModelMap mmap)
    {
        CompCompetition compCompetition = compCompetitionService.selectCompCompetitionByCompetitionId(competitionId);
        mmap.put("compCompetition", compCompetition);
        return prefix + "/edit";
    }

    /**
     * 修改保存赛事项目
     */
    @RequiresPermissions("zhangyan:competition:edit")
    @Log(title = "赛事项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompCompetition compCompetition)
    {
        return toAjax(compCompetitionService.updateCompCompetition(compCompetition));
    }

    /**
     * 删除赛事项目
     */
    @RequiresPermissions("zhangyan:competition:remove")
    @Log(title = "赛事项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(compCompetitionService.deleteCompCompetitionByCompetitionIds(ids));
    }
}
