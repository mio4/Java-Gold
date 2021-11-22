package _00_Java_language._nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class _channel {

    public static void main(String[] args) throws IOException {
        FileChannel channel = new RandomAccessFile("test.txt", "rw").getChannel();
        channel.position(channel.size());  // 移动文件指针到末尾（追加写入）

        ByteBuffer byteBuffer = ByteBuffer.allocate(20);

        // 数据写入Buffer
        byteBuffer.put("你好，世界！\n".getBytes(StandardCharsets.UTF_8));

        // Buffer -> Channel
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            channel.write(byteBuffer);
        }

        channel.position(0); // 移动文件指针到开头（从头读取）
        CharBuffer charBuffer = CharBuffer.allocate(10);
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

        // 读出所有数据
        byteBuffer.clear();
        while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
            byteBuffer.flip();

            // 使用UTF-8解码器解码
            charBuffer.clear();
            decoder.decode(byteBuffer, charBuffer, false);
            System.out.print(charBuffer.flip().toString());

            byteBuffer.compact(); // 数据可能有剩余
        }

        channel.close();
    }
}
