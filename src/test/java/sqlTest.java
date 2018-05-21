import com.product.Application;
import com.product.judge.api.business.model.Sysuser;
import com.product.judge.api.business.service.ApiService;
import com.product.judge.common.base.dao.JBaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class sqlTest
{
    @Autowired
    JBaseDao jBaseDao;
    @Autowired
    ApiService apiService;

    @Test
    public void test() throws Exception
    {
        String sql = "select * from sysuser where usr_id = ?";
        Sysuser sysuser = jBaseDao.queryForModel(sql, new String[]{"11"}, Sysuser.class);
        System.out.println(sysuser.getUsr_id());

    }
}
