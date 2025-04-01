package com.ruoyi.zhangyan.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 证书模板对象 comp_certificate_template
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class CompCertificateTemplate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 模板ID
     */
    private Long templateId;

    /**
     * 赛事ID
     */
    @Excel(name = "赛事ID")
    private Long competitionId;

    /**
     * 模板名称
     */
    @Excel(name = "模板名称")
    private String templateName;

    /**
     * 模板文件路径
     */
    @Excel(name = "模板文件路径")
    private String templateFile;

    /**
     * 背景图路径
     */
    @Excel(name = "背景图路径")
    private String backgroundImg;

    /**
     * 内容字段配置（JSON格式）
     */
    @Excel(name = "内容字段配置", readConverterExp = "J=SON格式")
    private String contentConfig;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public String getContentConfig() {
        return contentConfig;
    }

    public void setContentConfig(String contentConfig) {
        this.contentConfig = contentConfig;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("templateId", getTemplateId())
                .append("competitionId", getCompetitionId())
                .append("templateName", getTemplateName())
                .append("templateFile", getTemplateFile())
                .append("backgroundImg", getBackgroundImg())
                .append("contentConfig", getContentConfig())
                .append("createTime", getCreateTime())
                .toString();
    }
}
