package testSuite;

import Datas.SetDataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 测试用例-数据驱动测试
 *
 */
public class DataProviderTest {

    @BeforeClass
    public  void  before(){
        System.out.println("before test");

    }


    @Test(dataProvider = "getData",dataProviderClass = SetDataProvider.class)
    public void test_dataProvider(String name,String age){
        System.out.println(name);
        System.out.println(age);

    }


    @Test(dataProvider = "getData_csv",dataProviderClass = SetDataProvider.class) //从数据类查询数据
    public void test_dataProvider_csv(String name,String age){
        System.out.println("name is:" + name);
        System.out.println("age is:" + age);

    }

    @Test(dataProvider = "getData_xlsx",dataProviderClass = SetDataProvider.class) //从数据类查询数据
    public void test_dataProvider_xlsx(String name,String age){
        System.out.println("name is:" + name);
        System.out.println("age is:" + age);

    }


    @AfterClass
    public  void  after(){
        System.out.println("after test");
    }
}
