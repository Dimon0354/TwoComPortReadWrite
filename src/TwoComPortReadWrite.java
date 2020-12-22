import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class TwoComPortReadWrite {
    public static void main(String[] args) throws SerialPortException {

        System.out.println("write2ComPort start");

        WorkWCom1 testWrite1 = new WorkWCom1();
        WorkWCom2 testRead1 = new WorkWCom2();

        testWrite1.getCom1Worker(); //вызываем наш экзэмпляр
        testRead1.getCom2Worker();
        for(int a = 0; a < 10; a++){
            testWrite1.sendString2Comm("Hello my friend"); // вызываем метод передачи данный по ком порту
        }
        System.out.println("Recieved data is: " + testRead1.com2WorkerPrinter() + "; ");
//        testWrite1.sendString2Comm("Hello my friend"); // вызываем метод передачи данный по ком порту
        System.out.println("write2ComPort end");
    }
}

