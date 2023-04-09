package webserver;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Thread를 상속하고 있으며, 사용자의 요청에 대한 처리와 응답에 대한 처리를 담당하는 가증 중심 클래스
public class RequestHandler extends Thread {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    // 앞으로 진행할 모든 실습은 RequestHandler 클래스의 run() 메소드에서 구현
    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());

        // InputStream : 클라이언트(웹 브라우저)에서 서버로 요청을 보낼 때 전달되는 데이터
        // OutputStream : 서버에서 클라이언트에 응답을 보낼 때 전달되는 데이터
        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            // TODO 사용자 요청에 대한 처리는 이 곳에 구현하면 된다.

            // 3.4.3.1
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                String line = br.readLine();
                System.out.println("s = " + line);

                if ("".equals(line)) {
                    break;
                }

                if (line.contains("GET")) {
                    String[] arr = line.split(" ");
                    String url = arr[1];
//                    System.out.println("url = " + url);

                    DataOutputStream dos = new DataOutputStream(out);
                    byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
                    response200Header(dos, body.length);
                    responseBody(dos, body);
                    return;
                }

                if (line == null) return;
            }
            
            DataOutputStream dos = new DataOutputStream(out);
            byte[] body = "Hello Plitche".getBytes();
            response200Header(dos, body.length);
            responseBody(dos, body);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
