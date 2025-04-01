package com.ruoyi.zhangyan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zhangyan.domain.CompTeam;
import com.ruoyi.zhangyan.service.ICompTeamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 参赛团队Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/system/team")
public class CompTeamController extends BaseController {
    private String prefix = "system/team";

    @Autowired
    private ICompTeamService compTeamService;

    @RequiresPermissions("system:team:view")
    @GetMapping()
    public String team() {
        return prefix + "/team";
    }

    /**
     * 查询参赛团队列表
     */
    @RequiresPermissions("system:team:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompTeam compTeam) {
        startPage();
        List<CompTeam> list = compTeamService.selectCompTeamList(compTeam);
        return getDataTable(list);
    }

    /**
     * 导出参赛团队列表
     */
    @RequiresPermissions("system:team:export")
    @Log(title = "参赛团队", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompTeam compTeam) {
        List<CompTeam> list = compTeamService.selectCompTeamList(compTeam);
        ExcelUtil<CompTeam> util = new ExcelUtil<CompTeam>(CompTeam.class);
        return util.exportExcel(list, "参赛团队数据");
    }

    /**
     * 新增参赛团队
     */
    @RequiresPermissions("system:team:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存参赛团队
     */
    @RequiresPermissions("system:team:add")
    @Log(title = "参赛团队", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompTeam compTeam) {
        return toAjax(compTeamService.insertCompTeam(compTeam));
    }

    /**
     * 修改参赛团队
     */
    @RequiresPermissions("system:team:edit")
    @GetMapping("/edit/{teamId}")
    public String edit(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        CompTeam compTeam = compTeamService.selectCompTeamByTeamId(teamId);
        mmap.put("compTeam", compTeam);
        return prefix + "/edit";
    }

    /**
     * 修改保存参赛团队
     */
    @RequiresPermissions("system:team:edit")
    @Log(title = "参赛团队", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompTeam compTeam) {
        return toAjax(compTeamService.updateCompTeam(compTeam));
    }

    /**
     * 删除参赛团队
     */
    @RequiresPermissions("system:team:remove")
    @Log(title = "参赛团队", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(compTeamService.deleteCompTeamByTeamIds(ids));
    }
}
