package com.hjf.utils.md5;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * JAVA实现MD5加密的简单代码demo
 * 参考网站 :http://blog.csdn.net/ibey0nd/article/details/38500895
 */
public class Md5Test {

    public static void main(String[] args) throws IOException {
        //-------------对一个文件行进MD5效验-----------------------
        InputStream input = new FileInputStream("D:\\poi_test.xls");
        byte[] b = new byte[1024];
        int len;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len = input.read(b)) != -1) {

            baos.write(b, 0,len);
        }
        String s = md5Password(baos.toByteArray());
        System.out.println("s==" + s);
        baos.close();
        input.close();
        //---------------------byte[]写回到一个文件--------------------------
        ByteArrayInputStream bi = new ByteArrayInputStream(baos.toByteArray());
        byte[] bb = new byte[1024];
        FileOutputStream fos = new FileOutputStream("d:\\12.xls");
        while ((len = bi.read(bb)) != -1) {
            fos.write(bb, 0, len);
        }
        fos.close();
        bi.close();
        //-----------------------再使用这个文件进行MD5效验------------------------
        InputStream input2 = new FileInputStream("D:\\12.xls");
        byte[] b2 = new byte[1024];
        int len2;
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        while ((len2 = input2.read(b2)) != -1) {
            baos2.write(b2, 0, len2);
        }
        String s2 = md5Password(baos2.toByteArray());
        System.out.println("s2==" + s2);

    }


    public static String md5Password(byte[] password) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password);
            StringBuffer buffer = new StringBuffer();
            // 把没一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }

}
