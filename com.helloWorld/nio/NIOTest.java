package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/21
 * Time: 16:10
 * Description:
 */
public class NIOTest {
    public static void main(String[] args){
        try {
            nioCopyFile("/Users/zhouxinjian/Desktop/my.html","/Users/zhouxinjian/Desktop/my2.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void nioCopyFile(String resource ,String destination)throws IOException{
        FileInputStream fileInputStream = new FileInputStream(resource);
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        FileChannel readChannel = fileInputStream.getChannel();
        FileChannel writeChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
        while (true){
            buffer.clear();
            int len = readChannel.read(buffer);
            if (len==-1){
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();


    }
}