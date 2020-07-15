package com.hero.poetry.service.config;

import com.hero.poetry.entity.config.RankLevel;
import com.hero.poetry.mapper.config.RankConfigMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 配置段位所需要的分数
 * 从数据库中载入配置
 * 便于运行中修改
 */
@Component//默认单例
public class RankConfigService implements InitializingBean {
    public static final String RANK_ERROR = "无段位";

    private Map<Integer,String> level = new LinkedHashMap<>();

    /**
     * 根据分数来获取段位
     * @param score 分数
     * @return 所属段位
     */
    public String getRankByScore(int score){
        Set<Integer> integers = level.keySet();
        for (Integer i:integers){
            if (score >= i){
                return level.get(i);
            }
        }
        return RANK_ERROR;
    }

    @Autowired
    private RankConfigService(RankConfigMapper rankConfigMapper){
        this.rankConfigMapper = rankConfigMapper;
    };

    private final RankConfigMapper rankConfigMapper;

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
            level.put(rl.getScore(),rl.getLevel());
        }
    }
}
