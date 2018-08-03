package untils;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;



public class Netuntils {



    public static void main(String[] args) throws IOException {
        String token =  getAuth();
        System.out.println(token);

        String imagepath = "/Users/xinxi/Documents/SeleniumDemo/static/验证码1.png";
        Path path = Paths.get(imagepath);
        byte[] data = Files.readAllBytes(path);

        byte[] bytes = Base64.encodeBase64(data);

        String newstr = new String(bytes);
        newstr = newstr.replaceAll("\r\n","");
        newstr = newstr.replaceAll("\\+","%2B");
        String httpUrl = "https://aip.baidubce.com/rest/2.0/ocr/v1/webimage";
        String httpArg = "access_token=" + token +"&" + "image=" + newstr;
        String res = request(httpUrl,httpArg);
        System.out.println(res);

    }




    /**
     *
     * @return 通用文件识别
     * @throws JSONException
     */

    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            // 填入apikey到HTTP header
            //connection.setRequestProperty("apikey", "您自己的apikey");
            connection.setDoOutput(true);
            connection.getOutputStream().write(httpArg.getBytes("UTF-8"));
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

        public static String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "jAKuB3mKMoz9yvnE5UcLnRz7";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "i87PjVFa07t2zdfj0MV5poOViNlhSyd4";
        return getAuth(clientId, clientSecret);
    }




    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }





}
