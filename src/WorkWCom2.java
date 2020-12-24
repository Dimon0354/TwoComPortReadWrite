import jssc.SerialPort;
import jssc.SerialPortException;

public class WorkWCom2 {
    SerialPort com2Worker = null;

    public String setcom2WorkerPortName(String minePortName){   //Специально написал чтобы можно было получать имя порта извне
        com2Worker = new SerialPort(minePortName);
        return minePortName;
    }

    
    public SerialPort getCom2Worker() throws SerialPortException {
        System.out.println("getCom2Worker start");
        com2Worker.openPort();
        com2Worker.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        com2Worker.setEventsMask(SerialPort.MASK_RXFLAG);
        System.out.println("getCom2Worker end");
        return com2Worker;
    }

    public String com2WorkerPrinter () throws SerialPortException {
        System.out.println("com2WorkerPrinter start");
        String receivedData = com2Worker.readString();
        System.out.println("com2WorkerPrinter end");
        return receivedData;
    }
}
