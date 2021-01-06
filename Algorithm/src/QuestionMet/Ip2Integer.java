package QuestionMet;

import java.util.StringTokenizer;

public class Ip2Integer {

    /**
     * 返回Integer类型的ip地址
     * @return
     */
    private static Integer ipToInt(){
        String ip="192.168.1.201";
        StringTokenizer token=new StringTokenizer(ip, ".");
        Integer result=0;
        result +=Integer.parseInt(token.nextToken())<<24;
        result +=Integer.parseInt(token.nextToken())<<16;
        result += Integer.parseInt(token.nextToken())<<8;
        result +=Integer.parseInt(token.nextToken());
        return result;
    }

    /**
     * 将数值型的ip地址转换为字符串类型
     * @param ip 数值型的ip地址
     * @return
     */
    private static String intToIp(Integer ip){
        StringBuilder sb=new StringBuilder();
        sb.append(ip>>>24);
        sb.append(".");
        sb.append(String.valueOf((ip&0x00FFFFFF)>>>16));
        sb.append(".");
        sb.append(String.valueOf((ip&0x0000FFFF)>>>8));
        sb.append(".");
        sb.append(String.valueOf(ip&0x000000FF));
        return sb.toString();
    }
}
