package testSuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 测试用例-忽略测试
 * 1.enabled = false,不执行本条case
 */
public class EnableTest {

    @BeforeClass
    public  void  before(){
        System.out.println("before test");
    }


    public void test_1(){
        System.out.println("test_1");
//        Assert.assertFalse(true);

    }

    @Test(enabled = false) //enabled = false,忽略
    public void test_2(){
        System.out.println("test_2");
    }




    @AfterClass
    public  void  after(){
        System.out.println("after test");
    }
}
