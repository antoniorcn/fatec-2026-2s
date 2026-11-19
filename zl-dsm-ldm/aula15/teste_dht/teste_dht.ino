#include "DHT.h"
#include <WiFi.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <PubSubClient.h>
#define LED_BUILTIN 2
#define PINO_LED 5
#define PINO_DHT 23
DHT dht(PINO_DHT, DHT11);
#define LARGURA_TELA 128
#define ALTURA_TELA 64

const char* ssid = "TOM-TESTE";
const char* password =  "01234567";
const char* mqtt_server = "10.132.183.237";
const int mqtt_port = 1883;

WiFiClient espClient;
PubSubClient mqttClient(espClient);

Adafruit_SSD1306 display(LARGURA_TELA, ALTURA_TELA, &Wire, -1);


void escrever_animado(const char* texto, int tentativa) {
  char caracter = '-';
  int frame = tentativa % 4;
  if (frame == 0) { 
    caracter = '-';
  } else if (frame == 1) { 
    caracter = '/';
  } else if (frame == 2) { 
    caracter = '|';
  } else if (frame == 3) { 
    caracter = '\\';
  }
  display.clearDisplay();
  display.setTextSize(2);
  display.setTextColor(WHITE);
  display.setCursor(0, 0);
  display.print("Conectando");
  display.setCursor(62, 16);
  display.print(caracter);
  display.setTextSize(1);
  display.setCursor(10, 32);
  display.println(texto);
  display.display();
}

void conectar_wifi() {
  int i = 0;
  while (WiFi.status() != WL_CONNECTED) {
    escrever_animado("Wifi...", i);
    Serial.println("Connecting to WiFi..");
    delay(1000);
    i = i + 1;
    if (i >= 10000) { 
      i = 0;
    }
  }
}

void conectar_mqtt() {
  int i = 0;
  while (!mqttClient.connected()) {
    // Attempt to connect with a unique Client ID
    Serial.println("Conectando no MQTT Server");
    escrever_animado("Broker...", i);
    delay(1000);
    if (mqttClient.connect("ESP32Client")) {
      Serial.println("Connected to MQTT Broker");
    } else {
      delay(2000);
    }
    i = i + 1;
    if (i >= 10000) { 
      i = 0;
    }
  }
}

// the setup function runs once when you press reset or power the board
void setup() {
  Serial.begin(9600);
  Wire.begin(21, 22);
  if(!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println(F("Falha ao iniciar o display OLED"));
    for(;;);
  }

  int frame = 0;
  WiFi.begin(ssid, password);
  // Serial.println("Endereço de IP: ");
  // Serial.println(WiFi.localIP());
  mqttClient.setServer( mqtt_server, mqtt_port );
  
  dht.begin();
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(PINO_LED, OUTPUT);
}

// the loop function runs over and over again forever
void loop() { 
  float temp = dht.readTemperature();
  float umd = dht.readHumidity();

  
  if (!isnan(temp) && !isnan(umd)) {
    Serial.printf("Temp: %5.2f\tUmd: %5.2f\n", temp, umd);

    display.setTextSize(1);
    display.setCursor(10, 16);
    display.printf("Temp: %5.2f", temp);
    display.setCursor(10, 32);
    display.printf("Umd: %5.2f", umd);
    display.setCursor(10, 48);
    display.printf("Multiplataforma");
    display.display();

    char buffer[100]; // Buffer to store the result
    sprintf(buffer, "{\"temp\": %5.1f, \"umid\": %5.1f}", temp, umd);
    mqttClient.publish("SensorA", buffer);
    Serial.println("Led Aceso");
    digitalWrite(LED_BUILTIN, HIGH);  // turn the LED on (HIGH is the voltage level)
    digitalWrite(PINO_LED, HIGH);
    delay(1000);                      // wait for a second
    Serial.println("Led Apagado");
    digitalWrite(LED_BUILTIN, LOW);   // turn the LED off by making the voltage LOW
    digitalWrite(PINO_LED, LOW);   // turn the LED off by making the voltage LOW
    delay(1000);                      // wait for a second
  } else { 
    Serial.println("Falha ao ler o sensor DHT11");
  }
  mqttClient.loop();
  conectar_wifi();
  conectar_mqtt();
}
