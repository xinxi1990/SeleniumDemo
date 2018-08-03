package TestCase;


import Datas.SetDataProvider;
import org.testng.annotations.Test;

public class TestCase_GetData {


    /**
     * 获取二唯数组数据
     * @return
     */
    @Test(dataProvider = "getData",dataProviderClass = SetDataProvider.class)
    public void test_Data(String name,String age) {
        System.out.println("name is:" + name );
        System.out.println("age is:" + age );

    }

    /**
     * 获取csv中的数据
     * 循环读出每一行
     * @return
     */
    @Test(dataProvider = "getData_csv",dataProviderClass = SetDataProvider.class)
    public void test_DataCSV(String key,String value) {
        System.out.println( key + ":" + value);

    }

    /**
     * 获取xlsx中的数据
     * 循环读出每一行
     * @return
     */
    @Test(dataProvider = "getData_xlsx",dataProviderClass = SetDataProvider.class)
    public void test_Dataxlsx(String value1,String value2) {
        System.out.println( value1 + ":" + value2);


    }





}
