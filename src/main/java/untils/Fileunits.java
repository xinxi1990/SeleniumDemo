package untils;

/*

读写文件工具类
 */

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;


public class Fileunits {

    public static void main(String[] args) {
        Map map = (Map) new Fileunits().getYaml("Testdata_Lianjia.yaml").get("TestCase1");
        System.out.println(map.get("url"));

    }



    /**
     *
     * @param YamlName 读Yaml文件
     * @return 返回Map类型
     * @throws FileNotFoundException
     */
    public Map readYaml(String yamlpath) throws FileNotFoundException {


        String yamlname = System.getProperty("user.dir") + "/src/main/java/datas/" + yamlpath;
        Map<String, String> map = null;
        try{
            File dumpFile = new File(yamlname);
            Yaml yaml = new Yaml();
            map = (Map<String, String>) yaml.load((new FileInputStream(dumpFile)));
            //System.out.println(map);
        }catch (Exception e){
            System.out.println(String.format("读取%s异常! + \n + %s", yamlname,e));

        }

        return map;

    }


    /**
     * 解析yaml文件,返回map对象
     */
    public  Map getYaml(String yamlpath){
        Map<String, String> map = null;
        try {
            map = (Map<String, String>) this.readYaml(yamlpath);
        }catch (Exception e){
            System.out.println(String.format("获取%s的%s用例异常! + \n + %s",e));

        }
        return map;
    }




}
