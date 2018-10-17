package systemOa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import systemOa.bean.OperationLog;
import systemOa.service.IOperationLogService;

import java.util.List;
@Controller
public class SystemManagerController {

    @Autowired
    @Qualifier("operationLogService")
    private IOperationLogService iOperationLogService;

    public IOperationLogService getiOperationLogService() {
        return iOperationLogService;
    }

    public void setiOperationLogService(IOperationLogService iOperationLogService) {
        this.iOperationLogService = iOperationLogService;
    }

    @RequestMapping("selectAllLogs.do")
    public String doSelectAllAirplanetype(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        int pageSize = 1000;
        //pageSize为总的记录长度
        PageHelper.startPage(pn, pageSize);
        List<OperationLog> operationLogs = iOperationLogService.selectAllLogs();
        System.out.println(operationLogs);
        PageInfo page = new PageInfo(operationLogs, pageSize);
        model.addAttribute("pageInfo", page);
        return "/WEB-INF/SystemManager/ActionLog.jsp";
    }
}
