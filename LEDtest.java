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
public class Main {
 public static void readTxt(String path, GPIOPinDigitalOutput pin1, GPIOPinDigitalOutput pin2, GPIOPinDigitalOutput pin3, GPIOPinDigitalOutput pin4, GPIOPinDigitalOutput pin5, GPIOPinDigitalOutput pin6, GPIOPinDigitalOutput pin7, GPIOPinDigitalOutput pin8, GPIOPinDigitalOutput pin9, GPIOPinDigitalOutput pin10) throws InterruptedException {
    int count = 0;
    File file = new File(path);
    Scanner input = new Scanner(file);
    boolean finish = false;
    while (finish == false) {
      String line = input.nextLine();
      if (line.compareTo("") == 0) {
        finish = true;
      } else if (count == 0) {
        Main.updatePins(line.parseInt());
        count = 1;
      } else if (count == 1) {
        Thread.sleep(line.parseInt());
        count = 0;
      }
    }
  }
 public static void updatePins(String input, GPIOPinDigitalOutput pin1, GPIOPinDigitalOutput pin2, GPIOPinDigitalOutput pin3, GPIOPinDigitalOutput pin4, GPIOPinDigitalOutput pin5, GPIOPinDigitalOutput pin6, GPIOPinDigitalOutput pin7, GPIOPinDigitalOutput pin8, GPIOPinDigitalOutput pin9, GPIOPinDigitalOutput pin10) throws InterruptedException {
  int in = input.parseInt();
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
 final GPIOPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
 final GPIOPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
 final GPIOPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
 final GPIOPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
 final GPIOPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
 final GPIOPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
 final GPIOPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21);
 final GPIOPinDigitalOutput pin8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22);
 final GPIOPinDigitalOutput pin9 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23);
 final GPIOPinDigitalOutput pin10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24);
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
   } catch(InteruptedException) {
     readTxt(com, pin1, pin2, pin3, pin4, pin5, pin6, pin7, pin8, pin9, pin10);
    }
   }
 }
}
}
