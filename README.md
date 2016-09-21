
# BigramsRMI
Contador de Bigramas Cliente-Servidor usando Java RMI.

## Como compilar
* `javac Cliente.java`
* `javac Servidor.java`
* `javac ServidorImplementation.java`
* `rmic ServidorImplementation`

## Como correr
Abrir tres terminales:
  1. `rmiregistry &`
  2. `java ServidorImplementation`
  3. `java Cliente`

## Imagenes

### Resultados
![alt text](/images/rmi.png "RMI")
