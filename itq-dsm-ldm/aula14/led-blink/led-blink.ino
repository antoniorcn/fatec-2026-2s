#define PINO 21

void setup() {
  pinMode(PINO, OUTPUT);
}

void loop() {
  digitalWrite(PINO, HIGH);
  delay(100);
  digitalWrite(PINO, LOW);
  delay(100);

}
