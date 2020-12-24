import jssc.SerialPort;
import jssc.SerialPortException;

public class WorkWCom1{

    SerialPort com1Worker = null; //port writer

    public String setcom1WorkerPortName(String minePortName){   //Специально написал чтобы можно было получать имя порта извне
        com1Worker = new SerialPort(minePortName);
        return minePortName;
    }

    public SerialPort getCom1Worker() throws SerialPortException {

        System.out.println("getCom1Worker start");

        com1Worker.openPort();
        com1Worker.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        com1Worker.setEventsMask(SerialPort.MASK_TXEMPTY);
//        com1Worker.closePort();
        System.out.println("getCom1Worker end");
        return com1Worker;
    }

    public void sendString2Comm(String data) throws SerialPortException {
        this.com1Worker.writeString(data);
    }

}
