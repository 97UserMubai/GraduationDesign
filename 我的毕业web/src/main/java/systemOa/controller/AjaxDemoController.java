package systemOa.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import systemOa.bean.LeaveRequest;
import systemOa.service.ILeaveRequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("message")
public class AjaxDemoController{

    @Autowired
    @Qualifier("leaveRequestService")
    private ILeaveRequestService iLeaveRequestService;

    public ILeaveRequestService getiLeaveRequestService() {
        return iLeaveRequestService;
    }

    public void setiLeaveRequestService(ILeaveRequestService iLeaveRequestService) {
        this.iLeaveRequestService = iLeaveRequestService;
    }



//    @ResponseBody
    //使用ResponseBody注解配合在mvc配置中搭配的注解驱动来指定HttpMessageConverter的map方法
    //使用RequestBody来接受Request传来的内容，如果是对象可以使用Bean对象来接受
//    public void doPost(HttpServletRequest request, HttpServletResponse response, String messageId) throws IOException {
//       doGet(request,response,messageId);
//    }

//    public void test(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        PrintWriter out = response.getWriter();
//        out.print("1111");
//        out.close();
//    }
    @RequestMapping(value = "/getMessage.do",produces={"text/html;charset=UTF-8;","application/json;"})
    @ResponseBody
    public String doPost(HttpServletRequest request, HttpServletResponse response,@RequestParam("messageId") String messageId) throws IOException, ServletException {
//        response.setContentType("text/html;charset=utf-8");
//        response.setHeader("Charset","utf-8");
        //获取前端发送的请求字段
        String messageId1 = messageId;
        System.out.println(messageId1);
//       String messageId =  request.getParameter("messageId");
        //设置responce的内容，创建一个输入输出流来将返回的数据传给responce
        LeaveRequest leaveRequest = iLeaveRequestService.selectMessageByMessageId(messageId);
        //获取请求传输过来的数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("messageId",leaveRequest.getMessageId());
        map.put("personName",leaveRequest.getPersonName());
        Gson gson = new Gson();
//        System.out.println(leaveRequest.getStyle());
//        System.out.println(leaveRequest.getApplyTime());
        String message = gson.toJson(map);
//        request.setAttribute("ceshi",message);
        System.out.println(message);
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("XQ",message);
//        request.getRequestDispatcher("messageManager.jsp").forward(request,response);
//        PrintWriter out = response.getWriter();
//        out.print(message);
//        out.close();
        return message;
    }

    @RequestMapping("/test.do")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response){
        return "123456";
    }

}
