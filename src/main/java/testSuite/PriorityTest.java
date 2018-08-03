package testSuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 测试用例-顺序测试
 * 1.priority = 索引,索引必须是int类型
 */
public class PriorityTest {


    @BeforeClass
    public  void  before(){
        System.out.println("before test");
    }


    @Test(priority = 2) //顺序执行
    public void test_1(){
        System.out.println("test_1");
    }

    @Test(priority = 1)
    public void test_2(){
        System.out.println("test_2");
    }


    @AfterClass
    public  void  after(){
        System.out.println("after test");
    }
}
