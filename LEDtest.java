import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinDirection;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.PinEventType;
import java.util.Scanner;
import java.io.*;
public class LEDtest {
 public static void readTxt(String path, GpioPinDigitalOutput pin1, GpioPinDigitalOutput pin2, GpioPinDigitalOutput pin3, GpioPinDigitalOutput pin4, GpioPinDigitalOutput pin5, GpioPinDigitalOutput pin6, GpioPinDigitalOutput pin7, GpioPinDigitalOutput pin8, GpioPinDigitalOutput pin9, GpioPinDigitalOutput pin10) throws InterruptedException {
    int count = 0;
    File file = new File(path);
    Scanner input;
    try {
       input = new Scanner(file);
    } catch(FileNotFoundException e) {
     System.out.println(e.getMessage());
     return;
    }
    boolean finish = false;
    while (finish == false) {
      String line = input.nextLine();
      if (line.compareTo("") == 0) {
        finish = true;
      } else if (count == 0) {
        updatePins(line, pin1, pin2, pin3, pin4, pin5, pin6, pin7 ,pin8 ,pin9, pin10);
        count = 1;
      } else if (count == 1) {
        Thread.sleep(Integer.parseInt(line));
        count = 0;
      }
    }
  }
 public static void updatePins(String input, GpioPinDigitalOutput pin1, GpioPinDigitalOutput pin2, GpioPinDigitalOutput pin3, GpioPinDigitalOutput pin4, GpioPinDigitalOutput pin5, GpioPinDigitalOutput pin6, GpioPinDigitalOutput pin7, GpioPinDigitalOutput pin8, GpioPinDigitalOutput pin9, GpioPinDigitalOutput pin10) throws InterruptedException {
  int in = Integer.parseInt(input);
  if (in / 1000000000 == 1) {
   pin1.high();
  } else if (in / 1000000000 == 0) {
   pin1.low();
  }
  in %= 1000000000;
  if (in / 100000000 == 1) {
   pin2.high();
  } else if (in / 100000000 == 0) {
   pin2.low();
  }
  in %= 100000000;
  if (in / 10000000 == 1) {
   pin3.high();
  } else if (in / 10000000 == 0) {
   pin3.low();
  }
  in %= 10000000;
  if (in / 1000000 == 1) {
   pin4.high();
  } else if (in / 1000000 == 0) {
   pin4.low();
  }
  in %= 1000000;
  if (in / 100000 == 1) {
   pin5.high();
  } else if (in / 100000 == 0) {
   pin5.low();
  }
  in %= 100000;
  if (in / 10000 == 1) {
   pin6.high();
  } else if (in / 10000 == 0) {
   pin6.low();
  }
  in %= 10000;
  if (in / 1000 == 1) {
   pin7.high();
  } else if (in / 1000 == 0) {
   pin7.low();
  }
  in %= 1000;
  if (in / 100 == 1) {
   pin8.high();
  } else if (in / 100 == 0) {
   pin8.low();
  }
  in %= 100;
  if (in / 10 == 1) {
   pin9.high();
  } else if (in / 10 == 0) {
   pin9.low();
  }
  in %= 10;
  if (in / 1 == 1) {
   pin10.high();
  } else if (in / 1 == 0) {
   pin10.low();
  }
 }
  
  
 public static void main(String[] args) throws InterruptedException {
  final GpioController gpio = GpioFactory.getInstance();
 final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
 final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
 final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
 final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
 final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
 final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
 final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21);
 final GpioPinDigitalOutput pin8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22);
 final GpioPinDigitalOutput pin9 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23);
 final GpioPinDigitalOutput pin10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24);
  boolean exit = false;
  Scanner scan = new Scanner(System.in);
  while (exit == false) {
   System.out.println("Command: ");
   String com = scan.nextLine();
   if (com.compareToIgnoreCase("exit") == 0) {
    exit = true;
   } else {
    try {
     updatePins(com, pin1, pin2, pin3, pin4, pin5, pin6, pin7, pin8, pin9, pin10);
   } catch(InterruptedException e) {
     readTxt(com, pin1, pin2, pin3, pin4, pin5, pin6, pin7, pin8, pin9, pin10);
    }
   }
 }
}
}
