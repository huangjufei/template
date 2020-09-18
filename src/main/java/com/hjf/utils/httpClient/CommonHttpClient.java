package com.hjf.utils.httpClient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

import java.io.File;
import java.io.IOException;


/**
 * 多文件上传(使用的使用commons-httpclient包完成的功能)
 */
public class CommonHttpClient {

    public static void main(String[] args)  throws IOException {
        multipartFileUpload("");
    };

    /**
     * 多文件上传发送端(使用的使用commons-httpclient包完成的功能)
     * @param localFile
     */
    public static void multipartFileUpload(String localFile) {
        File file = new File("D:\\11.txt");
        File file2 = new File("D:\\2.txt");
        PostMethod filePost = new PostMethod("http://127.0.0.1:8080/user/post");
        HttpClient client = new HttpClient();
        try {
            // 通过以下方法可以模拟页面参数提交
            filePost.setParameter("userName", "name23");
            filePost.setParameter("passwd", "123");
            filePost.setRequestHeader("userName","head22");
            Part[] parts = {new FilePart(file.getName(), file), new FilePart(file2.getName(), file2)};
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            int status = client.executeMethod(filePost);
            if (status == HttpStatus.SC_OK) {
                System.out.println("上传成功");
            } else {
                System.out.println("上传失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            filePost.releaseConnection();
        }
    }

}
