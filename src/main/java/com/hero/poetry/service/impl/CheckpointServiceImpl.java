package com.hero.poetry.service.impl;

import com.hero.poetry.common.exception.CustomException;
import com.hero.poetry.common.utils.ResultCode;
import com.hero.poetry.common.utils.WebCache;
import com.hero.poetry.entity.Checkpoint;
import com.hero.poetry.entity.CheckpointProblem;
import com.hero.poetry.entity.dto.AllCheckpointWithUserPassDTO;
import com.hero.poetry.entity.dto.ProblemDTO;
import com.hero.poetry.entity.vo.CheckpointVO;
import com.hero.poetry.entity.vo.ProblemAnswerVO;
import com.hero.poetry.mapper.CheckpointMapper;
import com.hero.poetry.mapper.CheckpointProblemMapper;
import com.hero.poetry.mapper.CheckpointUserMapper;
import com.hero.poetry.service.CheckpointService;
import com.hero.poetry.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointServiceImpl implements CheckpointService {
    private final UserService userService;

    private final CheckpointMapper checkpointMapper;
    private final CheckpointUserMapper checkpointUserMapper;
    private final CheckpointProblemMapper checkpointProblemMapper;

    public CheckpointServiceImpl(UserService userService, CheckpointMapper checkpointMapper, CheckpointUserMapper checkpointUserMapper, CheckpointProblemMapper checkpointProblemMapper) {
        this.userService = userService;
        this.checkpointMapper = checkpointMapper;
        this.checkpointUserMapper = checkpointUserMapper;
        this.checkpointProblemMapper = checkpointProblemMapper;
    }

    @Override
    public List<AllCheckpointWithUserPassDTO> getAllCheckpointByUserId(String userId) {
        Integer gradeId = userService.getGradeIdById(userId);
        List<AllCheckpointWithUserPassDTO> allCheckpointByGradeId = checkpointMapper.getAllCheckpointByGradeIdAndUserId(gradeId, userId);
        return allCheckpointByGradeId;
    }

    @Override
    public ProblemDTO getCheckpointProblemByCheckpointIdAndProblemOrder(Integer checkpointId, Integer problemOrder) {
        ProblemDTO problemDTO = checkpointProblemMapper.getCheckpointProblemByCheckpointIdAndProblemOrder(checkpointId,problemOrder);
        return problemDTO;
    }

    @Override
    public boolean checkProblemAnswer(ProblemAnswerVO problemOrder) {
        int num = checkpointUserMapper.checkPassCheckpointByUserIdAndCheckpointId(problemOrder.getUserId(),problemOrder.getCheckpointId());
        if (num > 0){
            throw new CustomException(ResultCode.ILLEGAL_ACCESS_ERROR,"已经通过该关卡");
        }
        int n = checkpointProblemMapper.checkProblemAnswer(problemOrder.getCheckpointId(),problemOrder.getProblemOrder(),problemOrder.getProblemAnswer());
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
                throw new CustomException(ResultCode.ANSWER_TIME_OUT_ERROR,"答题超时,请重新作答");
            }
            //全部答对
            checkpointUserMapper.passCheckpoint(problemOrder.getCheckpointId(),problemOrder.getUserId());

        }
        return true;
    }

    @Override
    public Integer getProblemNum(Integer checkpointId) {
        int n = checkpointMapper.getProblemNum(checkpointId);
        return n;
    }

    @Override
    public void deleteCheckpoint(Integer id) {
        checkpointMapper.deleteCheckpoint(id);
        checkpointProblemMapper.deleteCheckpointProblemByCheckpointId(id);
        checkpointUserMapper.deletePassByCheckpointId(id);
    }

    @Override
    public void updateCheckpoint(CheckpointVO checkpointVO) {
        checkpointMapper.updateCheckpoint(checkpointVO);
    }

    @Override
    public List<ProblemDTO> getCheckpointProblemByCheckpointId(Integer checkpointId) {
        return checkpointProblemMapper.getCheckpointProblemByCheckpointId(checkpointId);
    }

    @Override
    public List<Checkpoint> getAllCheckpointByGradeId(Integer gradeId) {
        return checkpointMapper.getAllCheckpointByGradeId(gradeId);
    }

    @Override
    public List<Checkpoint> getAllCheckpoint() {
        return checkpointMapper.getAllCheckpoint();
    }

    @Override
    public void addProblem(CheckpointProblem checkpointProblem) {
        checkpointProblemMapper.addCheckpointProblem(checkpointProblem);
    }

    @Override
    public void deleteProblem(Integer id) {
        checkpointProblemMapper.deleteCheckpointProblemById(id);
    }

    @Override
    public void updateProblem(CheckpointProblem checkpointProblem) {
        checkpointProblemMapper.updateCheckpointProblem(checkpointProblem);
    }

    @Override
    public void addCheckpoint(CheckpointVO checkpointVO) {
        Checkpoint checkpoint = new Checkpoint();
        BeanUtils.copyProperties(checkpointVO,checkpoint);
        checkpoint.setProblemNum(0);
        checkpointMapper.addCheckpoint(checkpoint);
    }
}
