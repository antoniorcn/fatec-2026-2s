#include "DHT.h"

#define LED_BUILTIN 2
#define PINO_SAIDA 5
#define DHT_PIN 23

DHT dht(DHT_PIN, DHT11);

// the setup function runs once when you press reset or power the board
void setup() {
  Serial.begin(9600);
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(PINO_SAIDA, OUTPUT);
}

// the loop function runs over and over again forever
void loop() { 
  float temp = dht.readTemperature();
  float umd = dht.readHumidity();

  Serial.printf("Temp: %5.2f\tUmd: %52.f\n", temp, umd);

  Serial.println("Led Aceso");
  digitalWrite(LED_BUILTIN, HIGH);  // turn the LED on (HIGH is the voltage level)
  digitalWrite(PINO_SAIDA, HIGH);
  delay(1000);                      // wait for a second
  Serial.println("Led Apagado");
  digitalWrite(LED_BUILTIN, LOW);   // turn the LED off by making the voltage LOW
  digitalWrite(PINO_SAIDA, LOW);   // turn the LED off by making the voltage LOW
  delay(1000);                      // wait for a second
}
