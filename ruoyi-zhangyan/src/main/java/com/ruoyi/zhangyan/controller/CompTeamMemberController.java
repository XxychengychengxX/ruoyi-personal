package com.ruoyi.zhangyan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zhangyan.domain.CompTeamMember;
import com.ruoyi.zhangyan.service.ICompTeamMemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 团队成员Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/system/member")
public class CompTeamMemberController extends BaseController {
    private String prefix = "system/member";

    @Autowired
    private ICompTeamMemberService compTeamMemberService;

    @RequiresPermissions("system:member:view")
    @GetMapping()
    public String member() {
        return prefix + "/member";
    }

    /**
     * 查询团队成员列表
     */
    @RequiresPermissions("system:member:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompTeamMember compTeamMember) {
        startPage();
        List<CompTeamMember> list = compTeamMemberService.selectCompTeamMemberList(compTeamMember);
        return getDataTable(list);
    }

    /**
     * 导出团队成员列表
     */
    @RequiresPermissions("system:member:export")
    @Log(title = "团队成员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompTeamMember compTeamMember) {
        List<CompTeamMember> list = compTeamMemberService.selectCompTeamMemberList(compTeamMember);
        ExcelUtil<CompTeamMember> util = new ExcelUtil<CompTeamMember>(CompTeamMember.class);
        return util.exportExcel(list, "团队成员数据");
    }

    /**
     * 新增团队成员
     */
    @RequiresPermissions("system:member:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存团队成员
     */
    @RequiresPermissions("system:member:add")
    @Log(title = "团队成员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompTeamMember compTeamMember) {
        return toAjax(compTeamMemberService.insertCompTeamMember(compTeamMember));
    }

    /**
     * 修改团队成员
     */
    @RequiresPermissions("system:member:edit")
    @GetMapping("/edit/{memberId}")
    public String edit(@PathVariable("memberId") Long memberId, ModelMap mmap) {
        CompTeamMember compTeamMember = compTeamMemberService.selectCompTeamMemberByMemberId(memberId);
        mmap.put("compTeamMember", compTeamMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存团队成员
     */
    @RequiresPermissions("system:member:edit")
    @Log(title = "团队成员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompTeamMember compTeamMember) {
        return toAjax(compTeamMemberService.updateCompTeamMember(compTeamMember));
    }

    /**
     * 删除团队成员
     */
    @RequiresPermissions("system:member:remove")
    @Log(title = "团队成员", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(compTeamMemberService.deleteCompTeamMemberByMemberIds(ids));
    }
}
