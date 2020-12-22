import jssc.*;

import java.util.EventListener;

public class test {

    public static SerialPort serialPortRead;

    public static void main(String[] args) {

        System.out.println("start main");

//        String[] portName = SerialPortList.getPortNames();

        serialPortRead = new SerialPort("COM1");
        try {
            serialPortRead.openPort();  //Открыли порт
            serialPortRead.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE); //Задали параметры для открытого порта, взяли из документации WAC720
            serialPortRead.setEventsMask(SerialPort.MASK_RXCHAR);
            serialPortRead.addEventListener(new EventListener()); //Будем слушать порт
        }

        catch (SerialPortException excp){
            System.out.println(excp);
        }

        System.out.println("end main");

    }
    //класс срабатывающий при появлении данных с порта
    private static class EventListener implements SerialPortEventListener{
        public void serialEvent (SerialPortEvent event){
//            System.out.println("serialEvent start");
            if (event.isRXCHAR() && event.getEventValue() > 0){
                try {
                    String dataFromPort = serialPortRead.readString(event.getEventValue()); //Тут будут храниться наши данные с порта
                    System.out.print(dataFromPort);

                    if (dataFromPort == "(none) login: "){
                        serialPortRead.writeBytes("admin".getBytes());
                    }

                }
                catch (SerialPortException excp){
                    System.out.println(excp);
                }
            }
//            System.out.println("serialEvent end");
        }
    }

}
