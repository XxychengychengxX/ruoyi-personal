package com.ruoyi.zhangyan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.zhangyan.domain.CompTeam;
import com.ruoyi.zhangyan.domain.CompTeamUser;
import com.ruoyi.zhangyan.dto.req.CompTeamApplyRequest;
import com.ruoyi.zhangyan.mapper.CompTeamMapper;
import com.ruoyi.zhangyan.mapper.CompTeamUserMapper;
import com.ruoyi.zhangyan.service.ICompTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 团队管理Service业务层处理
 *
 * @author XxychengychengxX
 * @date 2025-04-11
 */
@Service
@Slf4j
public class CompTeamServiceImpl implements ICompTeamService {
    @Autowired
    private CompTeamMapper compTeamMapper;
    @Autowired
    private CompTeamUserMapper compTeamUserMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询团队管理
     *
     * @param teamId 团队管理主键
     * @return 团队管理
     */
    @Override
    public CompTeam selectCompTeamByTeamId(Long teamId) {
        return compTeamMapper.selectCompTeamByTeamId(teamId);
    }

    /**
     * 查询团队管理列表
     *
     * @param compTeam 团队管理
     * @return 团队管理
     */
    @Override
    public List<CompTeam> selectCompTeamList(CompTeam compTeam) {
        List<CompTeam> compTeams = compTeamMapper.selectCompTeamList(compTeam);
        for (CompTeam team : compTeams) {
            getTeamCaptainUsername(team);
        }
        return compTeams;
    }

    private void getTeamCaptainUsername(CompTeam team) {
        Long captainUserId = team.getCaptainUserId();
        if (captainUserId != null) {
            SysUser captainUser = sysUserMapper.selectUserById(captainUserId);
            if (captainUser != null) {
                team.setCaptainUsername(captainUser.getUserName());
            }
        }
    }

    /**
     * 新增团队管理
     *
     * @param compTeam 团队管理
     * @return 结果
     */
    @Override
    public int insertCompTeam(CompTeam compTeam) {
        // 获取当前的用户信息
        SysUser currentUser = ShiroUtils.getSysUser();
        // 获取当前的用户名称
        String userName = currentUser.getUserName();
        compTeam.setCreateTime(DateUtils.getNowDate());
        compTeam.setCreateBy(userName);
        int i = compTeamMapper.insertCompTeam(compTeam);

        CompTeamUser compTeamUser = new CompTeamUser();
        compTeamUser.setUserId(currentUser.getUserId());
        compTeamUser.setTeamId(compTeam.getTeamId());
        int i1 = compTeamUserMapper.insertCompTeamUser(compTeamUser);
        return i + i1;
    }

    /**
     * 修改团队管理
     *
     * @param compTeam 团队管理
     * @return 结果
     */
    @Override
    public int updateCompTeam(CompTeam compTeam) {
        return compTeamMapper.updateCompTeam(compTeam);
    }

    /**
     * 批量删除团队管理
     *
     * @param teamIds 需要删除的团队管理主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamByTeamIds(String teamIds) {
        return compTeamMapper.deleteCompTeamByTeamIds(Convert.toStrArray(teamIds));
    }

    /**
     * 删除团队管理信息
     *
     * @param teamId 团队管理主键
     * @return 结果
     */
    @Override
    public int deleteCompTeamByTeamId(Long teamId) {
        return compTeamMapper.deleteCompTeamByTeamId(teamId);
    }

    @Override
    public boolean applyTeam(CompTeamApplyRequest req) {
        // 这里可以添加具体的报名逻辑，例如检查团队是否已满，用户是否已经报名等
        log.info("请求体：{}", JSONObject.toJSONString(req));

        Long teamId = req.getTeamId();
        Long userId = req.getUserId();
        // 示例：打印日志表示收到报名请求
        // 可以调用 mapper 进行数据库操作，例如添加报名记录
        CompTeam compTeam = compTeamMapper.selectCompTeamByTeamId(teamId);
        if (compTeam == null) {
            throw new ServiceException("当前队伍不存在，刷新后重试");
        }
        List<CompTeamUser> compTeamUsers = compTeamUserMapper.selectCompTeamUserByTeamIdAndUserId(teamId, null);
        if (compTeamUsers.size() >= compTeam.getMaxMemberNum()) {
            throw new ServiceException("当前队伍已满，无法加入");
        }
        for (CompTeamUser compTeamUser : compTeamUsers) {
            if (compTeamUser.getUserId().equals(userId)) {
                throw new ServiceException("您已经加入该队伍，请勿重复加入");
            }
        }
        CompTeamUser compTeamUser = new CompTeamUser();
        compTeamUser.setTeamId(teamId);
        compTeamUser.setUserId(userId);
        compTeamUserMapper.insertCompTeamUser(compTeamUser);
        return true;
    }

    @Override
    public List<CompTeam> listMine(Long userId) {
        List<CompTeamUser> compTeamUsers = compTeamUserMapper.selectCompTeamUserByTeamIdAndUserId(null, userId);
        if (compTeamUsers.isEmpty()) {
            return new ArrayList<>();
        }
        Set<Long> teamId = compTeamUsers.stream().map(CompTeamUser::getTeamId).collect(Collectors.toSet());
        List<CompTeam> compTeams = compTeamMapper.selectCompTeamListByTeamId(teamId);
        compTeams.forEach(this::getTeamCaptainUsername);
        return compTeams;
    }
}
