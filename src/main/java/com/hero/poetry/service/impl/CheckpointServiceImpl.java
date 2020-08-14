package com.hero.poetry.service.impl;

import com.hero.poetry.common.exception.CustomException;
import com.hero.poetry.common.utils.WebCache;
import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import com.hero.poetry.entity.vo.ProblemAnswer;
import com.hero.poetry.mapper.CheckpointMapper;
import com.hero.poetry.mapper.CheckpointUserMapper;
import com.hero.poetry.service.CheckpointService;
import com.hero.poetry.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointServiceImpl implements CheckpointService {
    private final UserService userService;

    private final CheckpointMapper checkpointMapper;
    private final CheckpointUserMapper checkpointUserMapper;

    public CheckpointServiceImpl(UserService userService, CheckpointMapper checkpointMapper, CheckpointUserMapper checkpointUserMapper) {
        this.userService = userService;
        this.checkpointMapper = checkpointMapper;
        this.checkpointUserMapper = checkpointUserMapper;
    }

    @Override
    public List<AllCheckpointWithUserPassDTO> getAllCheckpoint(String userId) {
        Integer gradeId = userService.getGradeIdById(userId);
        List<AllCheckpointWithUserPassDTO> allCheckpointByGradeId = checkpointMapper.getAllCheckpointByGradeId(gradeId, userId);
        return allCheckpointByGradeId;
    }

    @Override
    public ProblemDTO getCheckpointProblemByCheckpointIdAndProblemOrder(Integer checkpointId, Integer problemOrder) {
        ProblemDTO problemDTO = checkpointMapper.getCheckpointProblemByCheckpointIdAndProblemOrder(checkpointId,problemOrder);
        return problemDTO;
    }

    @Override
    public boolean checkProblemAnswer(ProblemAnswer problemOrder) {
        int n = checkpointMapper.checkProblemAnswer(problemOrder.getCheckpointId(),problemOrder.getProblemOrder(),problemOrder.getProblemAnswer());
        if (n != 1)
            return false;
        WebCache.putCache(problemOrder.getUserId() + problemOrder.getCheckpointId() + problemOrder.getProblemOrder(),new WebCache<>().timeLimit(60*30));
        //获取关卡总问题数
        String cacheId = problemOrder.getUserId() + problemOrder.getCheckpointId();
        WebCache<Integer> maxOrder = WebCache.getCache(cacheId);
        if (maxOrder == null){
            Integer problemNum = checkpointMapper.getProblemNum(problemOrder.getCheckpointId());
            maxOrder = new WebCache<Integer>().data(problemNum);
            WebCache.putCache(cacheId,maxOrder);
        }
        //最后一个问题
        if (problemOrder.getProblemOrder().equals(maxOrder.getData())){
            boolean flag = true;
            for (int i=1;i<=maxOrder.getData();i++){
                String id = problemOrder.getUserId() + problemOrder.getCheckpointId() + i;
                WebCache webCache = WebCache.getCache(id);
                if (webCache == null){
                    flag = false;
                }
            }
            //删除之前的缓存
            for (int i=1;i<=maxOrder.getData();i++){
                String id = problemOrder.getUserId() + problemOrder.getCheckpointId() + i;
                WebCache.remove(id);
            }
            if (!flag){

                throw new CustomException("答题超时,请重新作答");
            }
            //全部答对
            checkpointUserMapper.passCheckpoint(problemOrder.getCheckpointId(),problemOrder.getUserId());

        }
        return true;
    }
}
