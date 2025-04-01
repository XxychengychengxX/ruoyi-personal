package com.ruoyi.zhangyan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zhangyan.domain.CompCertificateTemplate;
import com.ruoyi.zhangyan.service.ICompCertificateTemplateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 证书模板Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/system/template")
public class CompCertificateTemplateController extends BaseController {
    private String prefix = "system/template";

    @Autowired
    private ICompCertificateTemplateService compCertificateTemplateService;

    @RequiresPermissions("system:template:view")
    @GetMapping()
    public String template() {
        return prefix + "/template";
    }

    /**
     * 查询证书模板列表
     */
    @RequiresPermissions("system:template:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompCertificateTemplate compCertificateTemplate) {
        startPage();
        List<CompCertificateTemplate> list = compCertificateTemplateService.selectCompCertificateTemplateList(compCertificateTemplate);
        return getDataTable(list);
    }

    /**
     * 导出证书模板列表
     */
    @RequiresPermissions("system:template:export")
    @Log(title = "证书模板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompCertificateTemplate compCertificateTemplate) {
        List<CompCertificateTemplate> list = compCertificateTemplateService.selectCompCertificateTemplateList(compCertificateTemplate);
        ExcelUtil<CompCertificateTemplate> util = new ExcelUtil<CompCertificateTemplate>(CompCertificateTemplate.class);
        return util.exportExcel(list, "证书模板数据");
    }

    /**
     * 新增证书模板
     */
    @RequiresPermissions("system:template:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存证书模板
     */
    @RequiresPermissions("system:template:add")
    @Log(title = "证书模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompCertificateTemplate compCertificateTemplate) {
        return toAjax(compCertificateTemplateService.insertCompCertificateTemplate(compCertificateTemplate));
    }

    /**
     * 修改证书模板
     */
    @RequiresPermissions("system:template:edit")
    @GetMapping("/edit/{templateId}")
    public String edit(@PathVariable("templateId") Long templateId, ModelMap mmap) {
        CompCertificateTemplate compCertificateTemplate = compCertificateTemplateService.selectCompCertificateTemplateByTemplateId(templateId);
        mmap.put("compCertificateTemplate", compCertificateTemplate);
        return prefix + "/edit";
    }

    /**
     * 修改保存证书模板
     */
    @RequiresPermissions("system:template:edit")
    @Log(title = "证书模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompCertificateTemplate compCertificateTemplate) {
        return toAjax(compCertificateTemplateService.updateCompCertificateTemplate(compCertificateTemplate));
    }

    /**
     * 删除证书模板
     */
    @RequiresPermissions("system:template:remove")
    @Log(title = "证书模板", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(compCertificateTemplateService.deleteCompCertificateTemplateByTemplateIds(ids));
    }
}
