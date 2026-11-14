#include "DHT.h"
#define PINO 21
#define PINO_DHT 33
DHT dht(PINO_DHT, DHT11);
void setup() {
  pinMode(PINO, OUTPUT);
  dht.begin();
  Serial.begin(9600);
}
void loop() {
  digitalWrite(PINO, HIGH);
  delay(100);
  digitalWrite(PINO, LOW);
  delay(100);
  float temp = dht.readTemperature();
  Serial.printf("Temperadura: %5.2f\n", temp);
}
