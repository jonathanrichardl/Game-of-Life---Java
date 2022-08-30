# GameOfLife

The Game of Life implementation in Java

## Prerequisite

- JDK version 18.0.2

## How to build

```bash
./gradlew build
```

## How to use

To run, pass the text file that you want to use as the initial state as the argument

```bash
./gradlew run --args='*text-file*'
```

for example

```bash
./gradlew run --args='resources/gospel-gun.txt'
```

This package comes with predefined scenario:

1. Blinker (resources/blinker.txt)
2. Gospel Glider Gun (resources/gospel-gun.txt)
3. Pulsar (resources/pulsar.txt)
4. Simking Glider Gun (resources/simkingglidergun.txt)

## How to test

```bash
./gradlew test
``` 
