/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropath;
import com.fazecast.jSerialComm.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author ArinjayaKhare1
 */
public class Send_signal implements Runnable{
    SerialPort chosenPort;
    String signal;
    
    public Send_signal(String trainNo)
    {
        SerialPort [] portlist = SerialPort.getCommPorts();
        chosenPort = portlist[0];
        signal = trainNo;
        Thread t = new Thread(this);
        t.start();
    }
    public void run()
    {
        chosenPort. openPort();
        try {Thread.sleep(2000);} catch (Exception e){System.out.println("Port not opened properly.");}
        PrintWriter output = new PrintWriter(chosenPort.getOutputStream());
        output.write(signal);
        output.flush();
        chosenPort.closePort();
    }
    
}
