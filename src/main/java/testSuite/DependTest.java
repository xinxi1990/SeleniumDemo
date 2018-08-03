package testSuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Reporter;

/**
 * 测试用例-依赖测试
 * 1.dependsOnMethods = "依赖的case"
 * 2.依赖测试,如果依赖失败,后面则不会执行
 */
public class DependTest {

    @BeforeClass
    public  void  before(){

        System.out.println("before test");
    }


    @Test
    public void test_1(){
        System.out.println("test_1");
        Reporter.log("this is test_1 log");
//        Assert.assertFalse(true);

    }

    @Test(dependsOnMethods = "test_1")
    public void test_2(){
        Reporter.log("this is test_2 log");
        System.out.println("test_2");
    }


    @AfterClass
    public  void  after(){
        System.out.println("after test");
    }
}
