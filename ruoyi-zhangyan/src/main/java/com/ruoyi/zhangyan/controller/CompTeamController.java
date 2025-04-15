package com.ruoyi.zhangyan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.zhangyan.domain.CompTeam;
import com.ruoyi.zhangyan.dto.req.CompTeamApplyRequest;
import com.ruoyi.zhangyan.service.ICompTeamService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 团队管理Controller
 *
 * @author XxychengychengxX
 * @date 2025-04-11
 */
@Controller
@RequestMapping("/zhangyan/team")
public class CompTeamController extends BaseController {
    private String prefix = "zhangyan/team";

    @Autowired
    private ICompTeamService compTeamService;
    @Autowired
    private SysUserMapper sysUserMapper;

    @RequiresPermissions("zhangyan:team:list")
    @PostMapping("/listMine")
    @ResponseBody
    public TableDataInfo listMine(@RequestBody CompTeamApplyRequest compTeam) {
        startPage();
        return getDataTable(compTeamService.listMine(compTeam.getUserId()));
    }

    @RequiresPermissions("zhangyan:team:view")
    @GetMapping()
    public String team() {
        return prefix + "/team";
    }

    /**
     * 查询团队管理列表
     */
    @RequiresPermissions("zhangyan:team:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompTeam compTeam) {
        startPage();
        List<CompTeam> list = compTeamService.selectCompTeamList(compTeam);

        return getDataTable(list);
    }

    @RequiresPermissions("zhangyan:team:apply")
    @PostMapping("/apply")
    @ResponseBody
    public AjaxResult list(@RequestBody CompTeamApplyRequest req) {
        compTeamService.applyTeam(req);
        return AjaxResult.success();
    }

    /**
     * 导出团队管理列表
     */
    @RequiresPermissions("zhangyan:team:export")
    @Log(title = "团队管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompTeam compTeam) {
        List<CompTeam> list = compTeamService.selectCompTeamList(compTeam);
        ExcelUtil<CompTeam> util = new ExcelUtil<CompTeam>(CompTeam.class);
        return util.exportExcel(list, "团队管理数据");
    }

    /**
     * 新增团队管理
     */
    @RequiresPermissions("zhangyan:team:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存团队管理
     */
    @RequiresPermissions("zhangyan:team:add")
    @Log(title = "团队管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompTeam compTeam) {
        return toAjax(compTeamService.insertCompTeam(compTeam));
    }

    /**
     * 修改团队管理
     */
    @RequiresPermissions("zhangyan:team:edit")
    @GetMapping("/edit/{teamId}")
    public String edit(@PathVariable("teamId") Long teamId, ModelMap mmap) {
        CompTeam compTeam = compTeamService.selectCompTeamByTeamId(teamId);
        mmap.put("compTeam", compTeam);
        return prefix + "/edit";
    }

    /**
     * 修改保存团队管理
     */
    @RequiresPermissions("zhangyan:team:edit")
    @Log(title = "团队管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompTeam compTeam) {
        return toAjax(compTeamService.updateCompTeam(compTeam));
    }

    /**
     * 删除团队管理
     */
    @RequiresPermissions("zhangyan:team:remove")
    @Log(title = "团队管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(compTeamService.deleteCompTeamByTeamIds(ids));
    }
}
