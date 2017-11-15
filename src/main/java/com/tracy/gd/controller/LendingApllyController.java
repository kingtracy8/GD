package com.tracy.gd.controller;

import com.tracy.gd.domain.Computer;
import com.tracy.gd.domain.LendingApply;
import com.tracy.gd.domain.LendingHistory;
import com.tracy.gd.service.IComputerService;
import com.tracy.gd.service.ILendingApplyService;
import com.tracy.gd.service.ILendingHistoryService;
import com.tracy.gd.service.impl.LendingApplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by linsong.wei on  2017-11-12 13:46:14
 * 用户申请Controller
 */
@Controller
@RequestMapping("/LendingApply")
public class LendingApllyController {
    @Autowired
    ILendingApplyService lendingApplyService;
    @Autowired
    ILendingHistoryService lendingHistoryService;
    @Autowired
    IComputerService computerService;


    /*
        purpose:获取一个参数，申请表id，更新传入申请表id的记录，审核不通过，设置为"N"，
                把是否已经审核标志设置成“Y”,同时更新his表，computer表
        Create by : linsong.wei  2017-11-15 20:08:03
     */
    @RequestMapping(value = "/AuditingReject", method = RequestMethod.GET)
    public @ResponseBody
    HashMap doAuditingReject(HttpServletRequest request, HttpServletResponse response) {

        HashMap map = new HashMap();

        int flag;

        try {

            int laId = Integer.parseInt(request.getParameter("laId"));
            int laCptId = Integer.parseInt(request.getParameter("laCptId"));

            //1.对该记录进行设置 审核  不通过  标志
            LendingApply lendingApply = lendingApplyService.selectByPrimaryKey(laId);

            lendingApply.setLaIsCheck("N");
            //设置为已审核状态
            lendingApply.setAttribute1("Y");

            lendingApplyService.updateByPrimaryKeySelective(lendingApply);
            //2.更新历史表里的这条记录 并设置事件，审批人，审核意见等
            //获得与apply表同步的历史表记录
            LendingHistory lendingHistory = lendingHistoryService.selectByLaId(laId);
            //设置为当前用户审核的
            lendingHistory.setLhWhoChecked((Integer) request.getSession().getAttribute("userId"));
            lendingHistory.setLhCheckTime(new Date());
            lendingHistory.setLhIsCheck("N");
            //设置为已审核状态
            lendingHistory.setAttribute1("Y");
            lendingHistory.setLaCommons("审核不通过");

            lendingHistoryService.updateByPrimaryKeySelective(lendingHistory);
            //3.更新电脑表中这个电脑的租用标志，设置为"Y"
            //获得这台电脑
            Computer computer = computerService.selectByPrimaryKey(laCptId);
            computer.setCptIslending("N");
            computerService.updateByPrimaryKeySelective(computer);

            flag = 1;
        } catch (Exception e) {
            flag = -1;
        }

        map.put("flag", "1");

        return map;
    }


    /*
      purpose: 用户在管理员未审核之前撤回自己的申请记录
      author:  linsong.wei
      when:   2017-11-15 19:07:38
   */
    @RequestMapping(value = "/recallApply", method = RequestMethod.GET)
    public @ResponseBody
    HashMap doRecallApply(HttpServletRequest request, HttpServletResponse response) {

        HashMap map = new HashMap();

        int laId = Integer.parseInt(request.getParameter("laId"));
        LendingApply lendingApply = lendingApplyService.selectByPrimaryKey(laId);
        int flag = -1;

        try {
            //删除申请表里的本记录 且 user_id = 当前用户
            lendingApplyService.deleteByPkAndUser(lendingApply);
            //同时删除历史表的lhlaid=laid and lh_user_id=当前用户的纪录
            LendingHistory lendingHistory = lendingHistoryService.selectByLaId(laId);//找到对应的历史纪录
            lendingHistoryService.deleteByPkAndUser(lendingHistory);
            flag = 1;
        } catch (Exception e) {
            flag = -1;
        }


        map.put("flag", flag);

        return map;
    }


    /*
        purpose:防止重复提交，获取一个电脑id，再获取当前用户id，
        查出申请表中该用户申请了同一台电脑，且未审核的记录的数量，
        若大于0，则表示未审核之前重复申请同一台电脑，拒绝操作
        Create by : linsong.wei  2017-11-14 14:47:24
     */
    @RequestMapping(value = "/findDuplicate", method = RequestMethod.GET)
    public @ResponseBody
    HashMap doiFndDuplicate(HttpServletRequest request, HttpServletResponse response) {

        HashMap map = new HashMap();

        int curUserId = (Integer) request.getSession().getAttribute("userId");
        int cptId = Integer.parseInt(request.getParameter("cptId"));

        LendingApply lendingApply = new LendingApply();
        lendingApply.setLaCptId(cptId);
        lendingApply.setLaUserId(curUserId);
        int count = lendingApplyService.selectDuplicate(lendingApply);

        map.put("count", count);

        return map;
    }


    /*
        purpose:获取两个参数，一个电脑id，一个申请表id，更新传入申请表id的记录，设置为"Y"，
                并把这等于这个电脑id的其他申请记录给设置为"N",同时更新his表，computer表
        Create by : linsong.wei  2017-11-13 21:15:59
     */
    //忘记 update 了 2017-11-13 22:58:08。。。  继续加上  ok
    @RequestMapping(value = "/AuditingPassFilter", method = RequestMethod.GET)
    public @ResponseBody
    HashMap doAuditingPassFilter(HttpServletRequest request, HttpServletResponse response) {

        HashMap map = new HashMap();

        int flag;

        try {

            int laId = Integer.parseInt(request.getParameter("laId"));
            int laCptId = Integer.parseInt(request.getParameter("laCptId"));

            //1.审核通过这条记录
            LendingApply lendingApply = lendingApplyService.selectByPrimaryKey(laId);
            //设置审核通过标志
            lendingApply.setLaIsCheck("Y");
            //设置为已审核状态
            lendingApply.setAttribute1("Y");

            lendingApplyService.updateByPrimaryKeySelective(lendingApply);
            //2.更新历史表里的这条记录 并设置事件，审批人，审核意见等
            //获得与apply表同步的历史表记录
            LendingHistory lendingHistory = lendingHistoryService.selectByLaId(laId);
            //设置为当前用户审核的
            lendingHistory.setLhWhoChecked((Integer) request.getSession().getAttribute("userId"));
            lendingHistory.setLhCheckTime(new Date());
            lendingHistory.setLhIsCheck("Y");
            //设置为已审核状态
            lendingHistory.setAttribute1("Y");
            lendingHistory.setLaCommons("无审核意见");

            lendingHistoryService.updateByPrimaryKeySelective(lendingHistory);
            //3.更新电脑表中这个电脑的租用标志，设置为"Y"
            //获得这台电脑
            Computer computer = computerService.selectByPrimaryKey(laCptId);
            computer.setCptIslending("Y");
            //电脑表里的租用时间暂不考虑了。。 linsong.wei 2017-11-13 21:48:49

            //update 操作
            computerService.updateByPrimaryKeySelective(computer);

            //4.把apply表里申请了这台电脑的其他的记录，除了当前记录的其他记录给设置成“N”（sql语句条件给为不等于laId即可）
            LendingApply Apply = new LendingApply();
            Apply.setLaId(laId);
            Apply.setLaCptId(laCptId);

            //有可能有多个，是个集合，需要遍历
            //突然发现插入的时候本来就是N 。。。linsong.wei 2017-11-13 22:32:20 所以直接操作历史表，把历史表当成审核结果来存储,

            // 这样的话用户在申请记录上可以增加一个按钮，查看审核结果，然后通过apply表的id去查历史表，就有了结果
            List<LendingApply> lendingApplies = lendingApplyService.selectAuditingFilter(Apply);
            for (int i = 0; i < lendingApplies.size(); i++) {
                //因为历史表里没有电脑id 所以从不等于审核通过那条记录的记录里拿到apply集合，并同步到历史表
                //虽然本来是N，但是防止又审核了其他同一条记录的情况，还得设置一下 linsong.wei 2017-11-14 12:35:12
                lendingApplies.get(i).setLaIsCheck("N");
                //设置为已审核状态
                lendingApplies.get(i).setAttribute1("Y");
                lendingApplyService.updateByPrimaryKeySelective(lendingApplies.get(i));
                //5.把4同步到历史表，即把申请历史表中不等于laId的记录设置为“N”,并把理由设置为"借用冲突"
                LendingHistory his = lendingHistoryService.selectByLaId(lendingApplies.get(i).getLaId());
                //设置为当前用户审核的
                his.setLhWhoChecked((Integer) request.getSession().getAttribute("userId"));
                his.setLhCheckTime(new Date());
                his.setLhIsCheck("N");      //设置不通过
                //设置为已审核
                his.setAttribute1("Y");
                his.setLaCommons("申请冲突");
                lendingHistoryService.updateByPrimaryKeySelective(his);
            }

            flag = 1;
        } catch (Exception e) {
            flag = -1;
        }

        map.put("flag", "1");

        return map;
    }


    /*
      purpose:查询申请表中所有记录，看看同一台电脑同时有多少人申请
       Create by : linsong.wei  2017-11-13 20:16:35
    */
    @RequestMapping(value = "/findCptCount", method = RequestMethod.GET)
    public @ResponseBody
    HashMap doFindCptCound(HttpServletRequest request, HttpServletResponse response) {

        HashMap map = new HashMap();

        //通过电脑id去查询，有多少人在申请
        int count = lendingApplyService.selectCountCpt(Integer.parseInt(request.getParameter("laCptId")));


        map.put("count", count);

        return map;
    }


    /*
      purpose:查询申请表中所有记录，给管理员进行审核
       Create by : linsong.wei  2017-11-13 19:36:19
    */
    @RequestMapping("/AuditingList")
    public @ResponseBody
    HashMap doShowAuditingList(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();

        List<LendingApply> lendingApplies = lendingApplyService.selectAuditing();

        map.put("code", 0);
        map.put("msg", "");
        map.put("data", lendingApplies);
        return map;
    }


    /*
    purpose:为了防止并发操作，撤销申请的时候查看该条记录是否已经被审核
     Create by : linsong.wei  2017-11-13 11:31:17  //直接从apply表里查
  */
    @RequestMapping("/isCheck")
    public @ResponseBody
    LendingApply doIsCheck(HttpServletRequest request, HttpServletResponse response) {

        int la_id = Integer.parseInt(request.getParameter("la_id"));
        LendingApply lendingApply = lendingApplyService.selectByPrimaryKey(la_id);
        return lendingApply;
    }


    /*
       purpose: 查看当前用户申请记录 Create by : linsong.wei  2017-11-12 18:18:52  //直接从apply表里查
     */

    @RequestMapping("/showApply")
    public @ResponseBody
    HashMap doQueryApply(HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();

        int curUserId = (Integer) request.getSession().getAttribute("userId");

        List<LendingApply> lendingApplies = lendingApplyService.selectByUser(curUserId);

        map.put("code", 0);
        map.put("msg", "");
        map.put("data", lendingApplies);
        return map;
    }


    //purpose: 提交申请
    @RequestMapping("/commitApply")
    public @ResponseBody
    HashMap doCommitApply(HttpServletRequest request, HttpServletResponse response, @RequestBody LendingApply lendingApply) {

        HashMap map = new HashMap();

        int curUserId = (Integer) request.getSession().getAttribute("userId");
        LendingApply InlendingApply = lendingApply; //将从页面传过来的数据塞到实体中
        InlendingApply.setLaUserId(curUserId);      //设置申请人 ：当前用户
        InlendingApply.setLaIsCheck("N");           //设置为未审核状态
        InlendingApply.setAttribute1("N");
        //插入记录 申请表
        int flagApply = lendingApplyService.insertSelective(InlendingApply);


        //并插入到申请历史表
        LendingHistory lendingHistory = new LendingHistory();

        //申请表id 由于mybatis使用了 useGeneratedKeys="true" keyProperty="laId" 属性，可返回插入当前记录的主键，
        //从而可以将申请表id插入到历史表中  linsong.wei 2017-11-12 17:16:34
        //注：若不加这个属性，默认返回插入的记录数
        lendingHistory.setLhLaId(InlendingApply.getLaId());
        lendingHistory.setLhUserId(curUserId);      //仅需插入这两个字段，其余字段待管理员审核后更新,相当于在这记录一下，让管理员去审核（更新）
        //设置成管理员未审核状态 linsong.wei 2017-11-14 14:21:18
        lendingHistory.setAttribute1("N");
        int flagHis = lendingHistoryService.insertSelective(lendingHistory);


        map.put("flag", flagApply);
        map.put("flagHis", flagHis);
        return map;
    }

}
