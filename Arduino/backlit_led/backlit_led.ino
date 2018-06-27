#include <Adafruit_NeoPixel.h>

#define PIN 7
#define NUM 5

Adafruit_NeoPixel strip = Adafruit_NeoPixel(NUM, PIN, NEO_GRB + NEO_KHZ800);

//This is by no means a great sketch. I will contiue to mess with this program to get it to work the
//way that I think it needs to run. but for now it works and still allows us to change to color of the LEDs.
void setup()
{
  //Starts up all of the LEDs in a set color. This color will default each time you open serial Monitor
  strip.begin();
  strip.setPixelColor(0, 0, 0, 255);
  strip.setPixelColor(1, 0, 0, 255);
  strip.setPixelColor(2, 0, 0, 255);
  strip.setPixelColor(3, 0, 0, 255);
  strip.setPixelColor(4, 0, 0, 255);
  strip.show();
  Serial.begin(9600);
  // Asks for your command
  Serial.println("Please enter a LED number or 100 for all.");
  Serial.setTimeout(100000);
  while(!Serial);
  
}

void loop()
{ 
  // Based off the comand that you give the statement will be exicuted. 
  if(Serial.available() > 0)
  {
    int selection = Serial.read();
    if(selection == 100)
    {
      //Changes the color of all the LEDs.
      Serial.println("Enter numbers in the form of red, green, blue");
      int r = Serial.parseInt();
      int g = Serial.parseInt();
      int b = Serial.parseInt();
      changeAllColors(r,g,b);
      delay(1000);
    }
    else
    {
      //Changes the color of just one LED at a time.
      Serial.println("Enter numbers in the format of  led number, red, green, blue");
      int n = Serial.parseInt();
      int r = Serial.parseInt();
      int g = Serial.parseInt();
      int b = Serial.parseInt();
      strip.setPixelColor(n,r,g,b);
      strip.show();
      delay(1000);
    }
  }
}

void changeAllColors(int red, int green, int blue)
{
  for(int i = 0; i < NUM; i++)
  {
    strip.setPixelColor(i, red, green, blue);
    strip.show();
    delay(50);
  }

}

