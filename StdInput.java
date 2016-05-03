/* 
 *
 *Autoren: 

 *Muraca, Kevin
 *Alueste, Onur
 *Ringler, Sabine
 *
 */

import java.io.*;

public class StdInput
{
 public static double readDouble()
 {
  BufferedReader br;
  String inputString;
  double value = 0.0;

  br = new BufferedReader(new InputStreamReader(System.in));

  try
  {
   inputString = br.readLine();
   value = Double.parseDouble(inputString);
  }
  catch(IOException _uh)
  {
   System.out.println("Lesefehler !");
  }
  catch(NumberFormatException ex)
  {
    System.out.println("Sie haben keinen double-Wert eingegeben !");
  }
  return value;
 }

 public static double readDouble(String value)
 {
  System.out.println(value);
  return readDouble();
 }

 public static int readInt()
 {
  BufferedReader br;
  String inputString;
  int value = 0;

  br = new BufferedReader(new InputStreamReader(System.in));

  try
  {
   inputString = br.readLine();
   value = Integer.parseInt(inputString);
  }
  catch(IOException _uh)
  {
   System.out.println("Lesefehler !");
  }
  catch(NumberFormatException ex)
  {
    System.out.println("Sie haben keinen int-Wert eingegeben !");
  }
  return value;
 }

 public static int readInt(String value)
 {
  System.out.println(value);
  return readInt();
 }

 public static String readString()
 {
  BufferedReader br;
  String inputString = "";

  br = new BufferedReader(new InputStreamReader(System.in));

  try
  {
   inputString = br.readLine();
  }
  catch(IOException _uh)
  {
   System.out.println("Lesefehler !");
  }
  return inputString;
 }

 public static String readString(String value)
 {
  System.out.println(value);
  return readString();
 }
}
