import com.course.MyApplication;
import com.course.config.TestConfig;
import com.course.dao.LoginCaseMapper;
import com.course.model.InterFaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SpringBootTest(classes = MyApplication.class)
public class LoginTest1 {

    @Autowired
    LoginCaseMapper loginCaseMapper;

    @Autowired
    ConfigFile configFile;

    @BeforeTest(groups = "loginTrue", description = "测试准备工作")
//    @BeforeEach
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterFaceName.LOGIN);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterFaceName.GETUSERINFO);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue", description = "用户登录成功接口测试")
//    @Test
    public void testTrue(){
        configFile.getUrl(InterFaceName.GETUSERINFO);
        LoginCase loginCase = loginCaseMapper.selectByPrimaryKey(1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }

}
