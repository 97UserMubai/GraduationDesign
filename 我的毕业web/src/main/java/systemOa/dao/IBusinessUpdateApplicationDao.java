package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.BusinessUpdateApplication;

import java.util.Date;

public interface IBusinessUpdateApplicationDao {

    int insertNewApplication(BusinessUpdateApplication businessUpdateApplication);

    int updateApplication(@Param("messageId") String messageId,
                          @Param("status")int status, @Param("provePerson")String provePerson,
                          @Param("proveReason")String proveReason,@Param("proveTime")Date proveTime);


    BusinessUpdateApplication selectApplicationById(String messageId);
}
