package com.goodhealth.algorithm.Algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MessageDigestEncrypt
 * @Description 使用MessageDigest 计算MD5摘要   摘要算法是不可逆的
 * @Author WDH
 * @Date 2019/8/14 11:10
 * @Version 1.0
 **/
public class MessageDigestEncrypt {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 1.创建MessageDigest对象
        MessageDigest md = MessageDigest.getInstance("md5");
        // 2.向MessageDigest传递要计算摘要的数据
        byte[] res = md.digest("1346adk".getBytes());
        System.out.println(res.toString());
        String result = byteArrayToHexString(res);
        System.out.println(result);
        System.out.println(result.substring(8,24));

    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 将1个字节（1 byte = 8 bit）转为 2个十六进制位
     * 1个16进制位 = 4个二进制位 （即4 bit）
     * 转换思路：最简单的办法就是先将byte转为10进制的int类型，然后将十进制数转十六进制
     */
    private static String byteToHexString(byte b) {
        // byte类型赋值给int变量时，java会自动将byte类型转int类型，从低位类型到高位类型自动转换
        int n = b;
        // 将十进制数转十六进制
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        // d1和d2通过访问数组变量的方式转成16进制字符串；比如 d1 为12 ，那么就转为"c"; 因为int类型不会有a,b,c,d,e,f等表示16进制的字符
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 将字节数组里每个字节转成2个16进制位的字符串后拼接起来
     */
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

}
