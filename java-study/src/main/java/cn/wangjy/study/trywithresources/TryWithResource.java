package cn.wangjy.study.trywithresources;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/24 11:30
 */
public class TryWithResource {

    public static void main(String[] args) {
        //传统的try cache finally
        try{
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //try-with-resources
        try(Connection conn =new Connection()) {
            conn.sendData();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        //try-with-resources 声明多个资源
        try (FileInputStream fin = new FileInputStream(new File("input.txt"));
             FileOutputStream fout = new FileOutputStream(new File("out.txt"));
             GZIPOutputStream out = new GZIPOutputStream(fout)) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = fin.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void test() throws Exception {
        Connection conn = null;
        try {
            conn = new Connection();
            conn.sendData();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
