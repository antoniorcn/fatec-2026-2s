#define PINO 2

void setup() {
  pinMode(PINO, OUTPUT);
}

void loop() {
  digitalWrite(PINO, HIGH);
  delay(100);
  digitalWrite(PINO, LOW);
  delay(100);

}
