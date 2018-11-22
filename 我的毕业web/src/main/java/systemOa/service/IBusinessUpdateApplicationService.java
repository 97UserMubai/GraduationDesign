package systemOa.service;


import systemOa.bean.BusinessUpdateApplication;

import java.util.Date;

public interface IBusinessUpdateApplicationService {

    public  int insertNewApplication(BusinessUpdateApplication businessUpdateApplication);

    public  int updateApplication(String messageId, int status, String provePerson,
                                  String proveReason,Date proveTime);

    public  BusinessUpdateApplication selectApplicationById(String messageId);
}
