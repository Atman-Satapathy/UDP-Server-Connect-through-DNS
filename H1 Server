import java.net.*;

public class H1 {
    public static void main(String[] args) {
        try {
            DatagramSocket h1Socket = new DatagramSocket();

            InetAddress dsAddress = InetAddress.getByName("127.0.0.1");  // Replace with actual DS address
            int dsPort = 9876;

            byte[] sendData = "RequestDateTime".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, dsAddress, dsPort);

            h1Socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            h1Socket.receive(receivePacket);
            String currentDateAndTime = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Print the received date and time from DS
            System.out.println("Received Date and Time from DS: " + currentDateAndTime);

            // Forward currentDateAndTime to H2
            InetAddress h2Address = InetAddress.getByName("192.168.148.186");  // Replace with actual H2 address
            int h2Port = 9877;

            byte[] forwardData = currentDateAndTime.getBytes();
            DatagramPacket forwardPacket = new DatagramPacket(forwardData, forwardData.length, h2Address, h2Port);

            DatagramSocket forwardSocket = new DatagramSocket();
            forwardSocket.send(forwardPacket);

            forwardSocket.close();  // Close the forwardSocket after sending the data

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
