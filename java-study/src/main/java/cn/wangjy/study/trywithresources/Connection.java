package cn.wangjy.study.trywithresources;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/24 11:33
 */
public class Connection implements AutoCloseable {

    public void sendData() throws Exception {
//        System.out.println("正在发送数据...");
        throw new Exception("send data");
    }
    @Override
    public void close() throws Exception {
//        System.out.println("正在关闭连接...");
        throw new Exception("close");
    }
}
