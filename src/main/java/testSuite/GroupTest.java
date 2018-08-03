package testSuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 测试用例-分组测试
 * 1.groups = "组的名字"
 * 2.配置testng.xml使用
 * 3.BeforeClass和AfterClass如果不设置groups,则不执行
 */
public class GroupTest {


    @BeforeClass
    public  void  before(){
        System.out.println("before test");
    }


    @Test(groups = "BVT")
    public void test_1(){
        System.out.println("test_1");
    }

    @Test(groups = "UVT")
    public void test_2(){
        System.out.println("test_2");
    }


    @AfterClass
    public  void  after(){
        System.out.println("after test");
    }
}
