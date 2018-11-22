package systemOa.bean;

public class ProjectedCost {

    /**
     * @Param projectedDecCost:预计装饰费用
     * projectedStaffCost：预计员工费用
     * projectedGoodsCost：预计货物费用
     * projectedOtherCost：预计其他费用
     * otherCostDetail：预计费用详情
     * projectedAllCost：预计所有费用
     * 在action中统一使用元为单位
     * 其他费用的格式，以xx:xx元，xx:xx元为格式，必须写明备注
     * 备注包括该费用的持续时间，具体数字，受益人等信息，用列表形式标明
     */
    private String businessId;
    private String businessName;
    private String projectedDecCost;
    private String projectedStaffCost;
    private String projectedGoodsCost;
    private String projectedOtherCost;
    private String otherCostDetail;
    private String projectedAllCost;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getProjectedDecCost() {
        return projectedDecCost;
    }

    public void setProjectedDecCost(String projectedDecCost) {
        this.projectedDecCost = projectedDecCost;
    }

    public String getProjectedStaffCost() {
        return projectedStaffCost;
    }

    public void setProjectedStaffCost(String projectedStaffCost) {
        this.projectedStaffCost = projectedStaffCost;
    }

    public String getProjectedGoodsCost() {
        return projectedGoodsCost;
    }

    public void setProjectedGoodsCost(String projectedGoodsCost) {
        this.projectedGoodsCost = projectedGoodsCost;
    }

    public String getProjectedOtherCost() {
        return projectedOtherCost;
    }

    public void setProjectedOtherCost(String projectedOtherCost) {
        this.projectedOtherCost = projectedOtherCost;
    }

    public String getOtherCostDetail() {
        return otherCostDetail;
    }

    public void setOtherCostDetail(String otherCostDetail) {
        this.otherCostDetail = otherCostDetail;
    }

    public String getProjectedAllCost() {
        return projectedAllCost;
    }

    public void setProjectedAllCost(String projectedAllCost) {
        this.projectedAllCost = projectedAllCost;
    }

    public ProjectedCost(String businessId, String businessName, String projectedDecCost,
                         String projectedStaffCost, String projectedGoodsCost,
                         String projectedOtherCost, String otherCostDetail, String projectedAllCost) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.projectedDecCost = projectedDecCost;
        this.projectedStaffCost = projectedStaffCost;
        this.projectedGoodsCost = projectedGoodsCost;
        this.projectedOtherCost = projectedOtherCost;
        this.otherCostDetail = otherCostDetail;
        this.projectedAllCost = projectedAllCost;
    }
}
