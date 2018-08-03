package Datas;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SetDataProvider {

    private static String logindatacsv_path = System.getProperty("user.dir") + "/src/main/java/datas/login_back.csv";
    private static String datacsv_path = System.getProperty("user.dir") + "/src/main/java/datas/data.csv";
    private static String dataxlsx_path = System.getProperty("user.dir") + "/src/main/java/datas/data.xlsx";

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        readDataFromCSV("Datas/data.csv");
    }

    /**
     * 数据驱动-硬编码,二维数组数据驱动
     * carol对应的name字段
     * 12345对应的age字段
     */
    @DataProvider(name = "getData")
    public static Object[][] getData(){
        Object[][] o = {
                {"carol","25"},
                {"jack","30"},
        };
        return o;
    }

    /**
     * 数据驱动-读取login测试数据
     * csv返回的可迭代对象
     * 逐行读取
     */
    @DataProvider(name = "getLoginData_csv")
    public static Iterator<Object[]> getLoginData_csv(){
        Iterator<Object[]> o = readDataFromCSV(logindatacsv_path);
        return o;
    }


    /**
     * 数据驱动-读取csv数据
     * csv返回的可迭代对象
     * 逐行读取
     */
    @DataProvider(name = "getData_csv")
    public static Iterator<Object[]> getData_csv(){
        Iterator<Object[]> o = readDataFromCSV(datacsv_path);
        return o;
    }

    /**
     * 数据驱动-读取xlsx数据
     *
     */
    @DataProvider(name = "getData_xlsx")
    public static Object[][] getData_xlsx(){
        return getDataFromExcel(dataxlsx_path);
    }


    /**
     * 读取csv方法
     *
     */
    private static Iterator<Object[]> readDataFromCSV(String path){
        List<Object[]> list = new ArrayList<Object[]>();
        try {
            FileReader is = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(is);
            while(br.ready()){
                    list.add(br.readLine().split(","));
            }
            return list.iterator();
        }catch(Exception ex){
            throw new SkipException(ex.getMessage());
        }
    }

    /**
     * 读取Excel方法
     *
     */
    private static Object[][] getDataFromExcel(String excelPath) {
        Workbook workbook;
        try {
            FileInputStream excelInputStream = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(excelInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int rowInExcel = sheet.getPhysicalNumberOfRows();
            int columnInExcel = sheet.getRow(0).getPhysicalNumberOfCells();
            String[][] obj = new String[rowInExcel-1][columnInExcel];
            for(int row = 1; row < rowInExcel; row++){
                for(int col = 0; col < columnInExcel; col++){
                    sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
                    obj[row - 1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
                }
            }
            return obj;
        }catch(Exception e){
            System.out.println(e);
            throw new SkipException(e.getMessage());
        }
    }

}
