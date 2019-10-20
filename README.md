# Transformación Digital y a Arquitectura Empresarial.
## Laboratorio 

### Prerequisitos

* Java 1.8
* Maven 3.6.0 
* Spring-Boot
* Spring Security

## Ejecutar
### Descagar proyecto y descargar sus dependencias y compilar
```console
arep@arep:~$ git clone https://github.com/CrkJohn/AREM-SECURITY.git
arep@arep:~$ cd AREM-SECURITY/Security 
arep@arep:~/AREM-SECURITY/Security$ mvn package
arep@arep:~/AREM-SECURITY/Security$ cd ... 
arep@arep:~$ cd calc
arep@arep:~/AREM-SECURITY/calc$ mvn package
```

### Abrir dos terminales diferente
```console
arep@arep:~/AREM-SECURITY/Security$ mvn spring-boot:run

arep@arep:~/AREM-SECURITY/calc$ mvn spring-boot:run
```
 ### Cargar los certificados *.p12 al browser
[Certificado del cliente](https://github.com/CrkJohn/AREM-SECURITY/tree/master/Security/src/main/resources) psw nt-gateway

[Certificado del server](https://github.com/CrkJohn/AREM-SECURITY/tree/master/calc/src/main/resources) psw nt-service


### Licence 

AREM-SECURITY está licenciado  por GNU General Public License v3.0, ver [licencia](https://github.com/CrkJohn/Lab3AREP/blob/master/LICENCE) para más detalles.

### Autor

John David Ibañez - [CrkJohn](https://github.com/CrkJohn)

Escuela colombina de ingenieria Julio Garavito. 
