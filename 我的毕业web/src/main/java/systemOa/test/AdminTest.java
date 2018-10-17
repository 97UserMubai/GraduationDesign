package systemOa.test;

import systemOa.util.ImageUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @ProjectName AirlineSell
 * @ClassName null.java
 * @Author cza
 * @Time 2018/8/3 0003 21:30
 * @Version 1.0
 * @mark null
 * @Description
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:springmvc.xml"})*/
public class AdminTest {
    /*// 传入Springmvc的ioc
    @Autowired
    WebApplicationContext context;
    // 虚拟mvc请求，获取到处理结果。
    MockMvc mockMvc;*/


    @Before
    public void initMokcMvc() {
        /*mockMvc = MockMvcBuilders.webAppContextSetup(context).build();*/
    }

    @Test
    public void image(){
        System.out.print(ImageUtil.getBingEveryDayPicAdress());
    }

}

