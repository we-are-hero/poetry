package com.hero.poetry.service.config;

import com.hero.poetry.entity.RankLevel;
import com.hero.poetry.entity.dto.RankServiceDTO;
import com.hero.poetry.mapper.config.RankConfigMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 配置段位所需要的分数
 * 从数据库中载入配置
 * 便于运行中修改
 */
@Service//默认单例
public class RankConfigService implements InitializingBean {

    private final RankConfigMapper rankConfigMapper;

    private Map<Integer,RankServiceDTO> level = new LinkedHashMap<>();

    private RankConfigService(RankConfigMapper rankConfigMapper){
        this.rankConfigMapper = rankConfigMapper;
    };

    /**
     * 根据分数来获取段位
     * @param score 分数
     * @return 所属段位
     */
    public RankServiceDTO getRankByScore(int score){
        Set<Integer> integers = level.keySet();
        for (Integer i:integers){
            if (score >= i){
                return level.get(i);
            }
        }
        return null;
    }

    /**
     * 获取所有的段位
     * @return 所有段位
     */
    public List<RankServiceDTO> getAllRankLadder(){
        return new ArrayList<>(level.values());
    }

    public void addRankLevel(RankLevel rankLevel){
        rankConfigMapper.addRankLevel(rankLevel);
        init();
    }

    public List<RankLevel> getAllRankLevel(){
        return rankConfigMapper.getRankLevel();
    }

    public Integer getMaxScore(){
        int maxScore = 0;
        Set<Integer> set = level.keySet();
        for (Integer i : set) {
            if (i > maxScore){
                maxScore = i;
            }
        }
        return maxScore;
    }

    public void deleteRankLevel(Integer id){
        rankConfigMapper.deleteLevel(id);
        init();
    }

    public void updateRankLevel(RankLevel rankLevel){
        rankConfigMapper.updateLevel(rankLevel);
        init();
    }

    public RankLevel getRankLevelById(Integer id) {
        return rankConfigMapper.getRankLevelById(id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.init();
    }

    /**
     * 初始化配置
     */
    private void init(){
        level.clear();
        List<RankLevel> rankLevel = rankConfigMapper.getRankLevel();
        for (RankLevel rl:rankLevel){
            RankServiceDTO rankServiceDTO = new RankServiceDTO();
            BeanUtils.copyProperties(rl,rankServiceDTO);
            level.put(rl.getScore(),rankServiceDTO);
        }
    }
}
