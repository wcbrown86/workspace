#include <FatReader.h>         // Adds the file that allow the project to read the FAT partition
#include <SdReader.h>          // Adds the file that allow the project to read the SD card
#include <avr/pgmspace.h>      // Allows the program file to be stored in the flash memory instead of SRAM
#include <WaveUtil.h>          // Adds the file that allows the project to use the Wave board.
#include <WaveHC.h>            // Adds the file needed to control the hardware on the Wave board.
#include <Adafruit_NeoPixel.h> // Adds the file needed to control the NeoPixels


SdReader card;             // holds the information for the card
FatVolume vol;             // holds the information for the partition on the card
FatReader root;            // holds the information for the filesystem on the card
FatReader f;               // holds the information for the file we're play
WaveHC wave;               // This is the only wave (audio) object, since we will only play one at a time
#define PIN 6              // This is the pin number that the LED's are attached to on the board.
int numbOfLED = 16;        // This is the number of LED's in your strip


// Parameter 1 is the number of pixels in your strand
// Parameter 2 is the pin number that the strand is attached to
// Parameter 3 is the pixel type, more than one type can be added together 
// Neo_KHZ800 - most NeoPixel products with the WS2812 LEDs
// Neo_KHZ400 - classic 'v1' FLORA pixels with WS2811 drivers
// NEO_GRB - most NeoPixel products, if your not sure which one you have try this on first
// Neo_RGB - v1 FLORA pixels, not v2

//                              Parameter  (    1 ,     2   ,   3     )
Adafruit_NeoPixel strip = Adafruit_NeoPixel(numbOfLED , PIN , NEO_GRB );

// This prints out error messages if the SD card is not set up correctly. 


void setup() 
{
  // set up serial port
  Serial.begin(9600); // This opens the serial port (allows the computer to communicate) and sets the speed
  strip.begin();      // Starts the LED stip
  strip.show();       // Starts the LED's in the Off state
 
  //pinMode( 7, INPUT); // This sets the input pin for the motion detector. 
  // Set the output pins for the DAC control. This pins are defined in the library. This is for the Wave Board
  // Recall that pins 11 - 13 are used to communicate with the SD card and cannot be used. Do not be too worried 
  // about what LCS and CLK stand for. Just be sure that they are connected in the right places. 
  pinMode(2, OUTPUT); // This sets up the output to the Wave boards LCS 
  pinMode(3, OUTPUT); // This sets up the output to the Wave boards CLK 
  pinMode(4, OUTPUT); // This sets up the output to the Wave boards DI
  pinMode(5, OUTPUT); // This sets up the output to the Wave boards LAT
  pinMode(13, OUTPUT); // This sets up the output to the Wave boards CCS
  randomSeed(analogRead(0)); // This sets up the random number generator
  checkCard(); // Checks to make sure the SD card is usable. 
   
  
}

// This is the first part you want to look at to see if you need or want to change it for your own project. This is the 
// main loop that will run until you power off the device.
void loop() 
{
 
  
  //Checks to see if the motion detector sees motion, HIGH = motion, LOW = no motion.
  if(digitalRead(8) == HIGH)
  {
    Serial.print("Movement seen");
     //The delay time is in nanoseconds so there are 10000 nanoseconds in a sec. 
    delay(1000); // The delay time is in milliseconds. This delay keeps the pun[kin from triggering right away.
    showSelect(random(3)); // Picks a random "show" to play. the random() call needs an input of one less then the number of files or shows that you have. 
                           // This call returns an integer from 0 to 2 if it makes it easier for you to understand place random(number of shows - one) + one so
                           // showSelect(random(4)+1) would return a number between 1 and 5.
 
     delay(15000); // Another delay of 15 seconds. So the person has time to walk away. 
  }
  
  
    
  
}

/*
** Ok guys this is the big one. This is the function that can get very complicated, or its can be very strait forward
** it just depends on how much you what your pumpkin to do. I have included a few examples. From a sample one that justs 
** lights up the leds and plays the clip, to a sample that flashes the lights in many ways and plays the clip. When 
** selecting colors, you can use a RGB color chart. But note that as I was programming this sample I ran accross that
** the colors show on the cart where not always the color that the LEDs reproduced. 
*/
void showSelect( int show)
{
  // This switch case just takes the integer that is passed by the call to this function in the loop() function above.
  // The number is thin compared to the case number to select the set of statements to run. This is computer programming
  // it is a good habit to start counting with zero. It will come up offtain.  
  switch(show)
 {
  
   case 0: 
       playfile("WITCH.WAV"); // This function plays the wav file without stopping. 
        while (wave.isplaying) // This is where you would place any LED changes you would like to make while the file plays
        {
          // This set of code causes the eyes of the pumpkin to to flash between two colors.
          // It first sets the color of the all the LEDs then just changes the color of the eyes. This will loop until the 
          // Sound is finished.
           colorWipe(strip.Color(255,0,0), 0);
           delay(60);
           colorSelection(4,7,strip.Color(255,127,0),50);
           delay(60);
        }
        colorWipe(strip.Color(0,0,0),0); // This clears the color on the LED's. 
     
     break; // And we are done with this case so this will bypass all the rest of the cases.
   
   case 1:
       playfile("WOLFHOWL.WAV"); // This function plays the wav file without stopping. 
        while (wave.isplaying) // This is where you would place any LED changes you would like to make while the file plays
        {
          // Sets the color of the mouth or the inside of the pumpkin.
          colorSelection(0,3,strip.Color(192,0,0),0);
          // Sets teh color of the side LEDs
          colorSelection(8,15,strip.Color(192,0,0),0);
          // I've given a variable name for red, green, and blue. The set numbers are what ever the final value of that color
          // will be divided by the 20. I choose 20 because thats how many steps in color / brightness I want to make.
          uint8_t r = 4.3;
          uint8_t b = 1.3;
          uint8_t g = 6.95;
          
          // This for loop adds the multiple of the final number divided by 20. with the first multiple being the starting value set
          // above. Then adding this value 19 more times to reach the final desired color at full brightness. This could also be done
          // with the setBrightness() function. but with that function you would have to set a brightness for each LED. you could do that
          // with one for loop listing each one. or with a nested (a for loop inside a for loop) for loop with the second loop starting with
          // the first LED and looping until it hits the last LED. and just use setBrightness(i)
          for(uint16_t i = 0; i <= 19; i++)
          {
            // Sets the color to the current value.
            colorSelection(4,7,strip.Color(r,b,g),20);
            // Changes each value by the multiple.
            b += 4.3;
            r += 1.3;
            g += 6.95;
            delay(200);
          }
        }
       colorWipe(strip.Color(0,0,0),0); // clear the color on the strip.
     break; // And we are done with this case so this will bypass all the rest of the cases.
   
   case 2:
       playfile("LOOKATME.WAV"); // This function plays the wav file without stopping. 
       
       // When timed correctly this loop will only run one time.
        while (wave.isplaying) // This is where you would place any LED changes you would like to make while the file plays
        {
          // This for loop is for the first part of the song that repeats 4 times. so the loop runs 4 times. useing delay to 
          // time the flashes with the music. NOTE!!! The more complex you make this will increase the chance that your clip 
          // might destort because the LEDs are using to much power from the controler and power from the battery pack. 
          for(uint16_t i = 0; i <= 3; i++)
          {
             delay(750);
             colorSelection(8,11,strip.Color(25,25,112),20);
             delay(50);
             colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
             delay(400);
             colorSelection(12,15,strip.Color(25,25,112),20);
             delay(50);
             colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
             delay(1000);
             colorSelection(8,11,strip.Color(25,25,112),20);
             delay(50);
             colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
             delay(400);
             colorSelection(12,15,strip.Color(25,25,112),20);
             delay(50);
             colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
             delay(100);
             colorWipe(strip.Color(25,25,112),20);
             delay(400);
             colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
             delay(100);
             colorWipe(strip.Color(25,25,112),0);
             delay(200);
             colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
             delay(200);
             colorSelection(0,3,strip.Color(255,0,0),25);
             colorSelection(4,7,strip.Color(140,23,23),25);
             colorSelection(8,15,strip.Color(104,34,139),25);
             delay(1455); 
             colorWipe(strip.Color(0,0,0),0);  // clear the color on the strip.      
          }
          // This is for the second part of the song. and runs until the end of the song. 
          // This is just a random colection of color wipes.
          delay(200);
          colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
          delay(200);
          colorWipe(strip.Color(0,0,255),60);
          delay(200);
          colorWipe(strip.Color(0,255,0),60);
          delay(200);
          colorWipe(strip.Color(255,0,0),60);
          delay(200);
          colorWipe(strip.Color(25,25,112),60);
          delay(200);
          colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
          delay(200);
          colorWipe(strip.Color(0,0,255),60);
          delay(200);
          colorWipe(strip.Color(0,255,0),60);
          delay(200);
          colorWipe(strip.Color(255,0,0),60);
          delay(200);
          colorWipe(strip.Color(25,25,112),60);
        }
        colorWipe(strip.Color(0,0,0),0);// clear the color on the strip.
     
     break; // And we are done with this case so this will bypass all the rest of the cases.
     
     // If you want to use more clips add more cases here. Remember to adjust your random value in the loop() function. 
     // Other wise these cases will not run!!
 }
       
}

// Function that plays the clip. 
void playfile(char *name) 
{
  // see if the wave object is currently doing something
  if (wave.isplaying)
  {
    // already playing something, so stop it!
    wave.stop(); // stop it
  }
  // look in the root directory and open the file
  if (!f.open(root, name)) 
  {
    putstring("Couldn't open file "); Serial.print(name); return;
  }
  // OK read the file and turn it into a wave object
  if (!wave.create(f)) 
  {
    putstring_nl("Not a valid WAV"); return;
  }
  
  // ok time to play! start playback
  wave.play();
}

// Sets the color of one LED. 
void setColor(uint32_t num, uint32_t color, uint8_t wait)
{
   strip.setPixelColor(num, color);
   strip.show();
   delay(wait);
  
}

// Fill the dots one after the other with a color
void colorWipe(uint32_t color, uint8_t wait) 
{
  // For loop that goes thru each LED and sets the color to the one given.
  for(uint16_t i=0; i<strip.numPixels(); i++) 
  {
    // i is the LED number on the strip.
      strip.setPixelColor(i, color);
      // This makes the changes to the strip. Without this the changes will not show
      strip.show();
      // The time set between each LEDs color change. 
      delay(wait);
  }
}

// This function changes the color of LEDs in  set range. meaning you can change the color of LED starting first with all the LEDs until the last.
// where first and last are set by you. So for example you can change LEDs 2 - 10 to whatever color. 
void colorSelection(uint16_t first, uint16_t last, uint32_t color, uint8_t wait)
{
  for(uint16_t i = first; i <= last; i++)
  {
    strip.setPixelColor(i, color);
    strip.show();
    delay(wait);
  }
}

// Runs thru a multitude of colors. The wait time is the amount of time between each LED color change.
// if the wait time is short this can casue your clip (if one is playing) to slow down. And could not 
// sound as it should.
void rainbow(uint8_t wait) 
{
  uint16_t i, j;

  for(j=0; j<256; j++) 
  {
    for(i=0; i<strip.numPixels(); i++) 
    {
      strip.setPixelColor(i, Wheel((i+j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

// Slightly different, this makes the rainbow equally distributed throughout
void rainbowCycle(uint8_t wait) 
{
  uint16_t i, j;

  for(j=0; j<256*5; j++) 
  { // 5 cycles of all colors on wheel
    for(i=0; i< strip.numPixels(); i++) 
    {
      strip.setPixelColor(i, Wheel(((i * 256 / strip.numPixels()) + j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

// Input a value 0 to 255 to get a color value.
// The colours are a transition r - g - b - back to r.
uint32_t Wheel(byte WheelPos) 
{
  if(WheelPos < 85) 
  {
   return strip.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
  } 
  else if(WheelPos < 170)
  {
   WheelPos -= 85;
   return strip.Color(255 - WheelPos * 3, 0, WheelPos * 3);
  } 
  else 
  {
   WheelPos -= 170;
   return strip.Color(0, WheelPos * 3, 255 - WheelPos * 3);
  }
}

void checkCard()
{
 // This next part is for checking the SD card and its files. There should not be a reason to mess with this 
  //  if (!card.init(true)) { //play with 4 MHz spi if 8MHz isn't working for you
  if (!card.init()) 
  {         //play with 8 MHz spi (default faster!)  
    putstring_nl("Card init. failed!");  // Something went wrong, lets print out why
    sdErrorCheck();
    while(1);                            // then 'halt' - do nothing!
  }
  
  // enable optimize read - some cards may timeout. Disable if you're having problems
  card.partialBlockRead(true);
 
// look for a FAT partition!
  uint8_t part;
  for (part = 0; part < 5; part++) 
  {     // we have up to 5 slots to look in
    if (vol.init(card, part)) 
      break;                             // we found one, lets bail
  }
  if (part == 5) 
  {                       // if we ended up not finding one  :(
    putstring_nl("No valid FAT partition!");
    sdErrorCheck();      // Something went wrong, lets print out why
    while(1);                            // then 'halt' - do nothing!
  }
  
  // Lets tell the user about what we found
  putstring("Using partition ");
  Serial.print(part, DEC);
  putstring(", type is FAT");
  Serial.println(vol.fatType(),DEC);     // FAT16 or FAT32?
  
  // Try to open the root directory
  if (!root.openRoot(vol)) 
  {
    putstring_nl("Can't open root dir!"); // Something went wrong,
    while(1);                             // then 'halt' - do nothing!
  }
  
  // Whew! We got past the tough parts.
  putstring_nl("Ready!"); 
}

// This function just prints out any errors that happen during the SD card test
void sdErrorCheck(void)
{
  if (!card.errorCode()) return;
  putstring("\n\rSD I/O error: ");
  Serial.print(card.errorCode(), HEX);
  putstring(", ");
  Serial.println(card.errorData(), HEX);
  while(1);
}

