import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class TwoComPortReadWrite {
    public static void main(String[] args) throws SerialPortException {

        System.out.println("write2ComPort start");

        WorkWCom1 testWrite1 = new WorkWCom1();
        WorkWCom2 testRead1 = new WorkWCom2();

        String varOnly4Com1PortName = "com1";
        String varOnly4Com2PortName = "com2"; //потом будем брать переменную извне

        testWrite1.setcom1WorkerPortName(varOnly4Com1PortName);
        testRead1.setcom2WorkerPortName(varOnly4Com2PortName);

        testWrite1.getCom1Worker(); //вызываем наш экзэмпляр
        testRead1.getCom2Worker();
        for(int a = 0; a < 10; a++){
            testWrite1.sendString2Comm("Hello my friend"); // вызываем метод передачи данный по ком порту
        }
        System.out.println("Recieved data is: " + testRead1.com2WorkerPrinter() + "; ");
        System.out.println("Port name is - " );
//        testWrite1.sendString2Comm("Hello my friend"); // вызываем метод передачи данный по ком порту
        System.out.println("write2ComPort end");
    }
}

