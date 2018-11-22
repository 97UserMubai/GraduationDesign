package systemOa.bean;

public class ConcreteCost {

    /**
     * @Param concreteDecCost:具体装饰费用
     * concreteStaffCost：具体员工费用
     * concreteGoodsCost：具体货物费用
     * concreteOtherCost：具体其他费用
     * OtherCostDetail：其他费用详情
     * concreteAllCost：具体所有费用
     * 在action中统一使用元为单位
     * 其他费用的格式，以xx:xx元，xx:xx元为格式，必须写明备注
     * 备注包括该费用的持续时间，具体数字，受益人等信息，用列表形式标明
     */

    private String businessId;
    private String businessName;
    private String concreteDecCost;
    private String concreteStaffCost;
    private String concreteGoodsCost;
    private String concreteOtherCost;
    private String OtherCostDetail;
    private String concreteAllCost;

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

    public String getConcreteDecCost() {
        return concreteDecCost;
    }

    public void setConcreteDecCost(String concreteDecCost) {
        this.concreteDecCost = concreteDecCost;
    }

    public String getConcreteStaffCost() {
        return concreteStaffCost;
    }

    public void setConcreteStaffCost(String concreteStaffCost) {
        this.concreteStaffCost = concreteStaffCost;
    }

    public String getConcreteGoodsCost() {
        return concreteGoodsCost;
    }

    public void setConcreteGoodsCost(String concreteGoodsCost) {
        this.concreteGoodsCost = concreteGoodsCost;
    }

    public String getConcreteOtherCost() {
        return concreteOtherCost;
    }

    public void setConcreteOtherCost(String concreteOtherCost) {
        this.concreteOtherCost = concreteOtherCost;
    }

    public String getOtherCostDetail() {
        return OtherCostDetail;
    }

    public void setOtherCostDetail(String otherCostDetail) {
        OtherCostDetail = otherCostDetail;
    }

    public String getConcreteAllCost() {
        return concreteAllCost;
    }

    public void setConcreteAllCost(String concreteAllCost) {
        this.concreteAllCost = concreteAllCost;
    }

    public ConcreteCost(String businessId, String businessName, String concreteDecCost,
                        String concreteStaffCost, String concreteGoodsCost,
                        String concreteOtherCost, String otherCostDetail, String concreteAllCost) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.concreteDecCost = concreteDecCost;
        this.concreteStaffCost = concreteStaffCost;
        this.concreteGoodsCost = concreteGoodsCost;
        this.concreteOtherCost = concreteOtherCost;
        OtherCostDetail = otherCostDetail;
        this.concreteAllCost = concreteAllCost;
    }
}
