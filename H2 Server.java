import java.net.*;

public class H2 {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(9877); // H2 listens on port 9877

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            socket.receive(receivePacket);

            String dateTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received Date and Time from H1: " + dateTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
