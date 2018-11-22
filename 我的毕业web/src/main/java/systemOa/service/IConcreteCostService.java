package systemOa.service;


import systemOa.bean.ConcreteCost;

public interface IConcreteCostService {
    int insertNewCC(ConcreteCost concreteCost);

    //对具体费用统计表的更新需要经过经理审批，所以要先提交申请表
    int updateCC(ConcreteCost concreteCost,String businessId);
}
