# Interview Mercado Libre Dna Mutants v1

Detecta si un humano es mutante, basado en la secuencia del ADN.

# Pre requisitos

Siga las instrucciones  para  ejecutar  el programa 

#### Configuración

Plugins que debe tener instalados en el IDE que vaya a utilizar

* [Lombok]

Herramientas que debe tener instalados

* [Github]
* [Postman o Insomnia]

# Configuración del ambiente local

### Consideraciones: 
* Se tiene otro repositorio con el config-server, para el servidor de registro. Ya que esto esto funciona 
  como un microservicio.
  Se utilizo postgress en el despliegue productivo, porque es la etapa gratutia en Heroku.
  
  Adjunto enlance:
  https://github.com/DanielaVergara/config-server -> la rama es config-server
  
   Para la ejecución en ambiente local, deshabilitar la conexión por config server en el bootstrap.yml, enable false
  y conectarse mediante mysql. 
  
  * Para conectarse en ambiente local, se adjunta el application.properties en la carpeta resources, con la configuración
  de los datasource para mysql
  Esto solo se adjunta, para que puedan subir la aplicación en local.De igual forma,
  tener contemplado que debería ir en el .gitignore
  

* Importar el proyecto y ejecutar el comando "mvn clean install" (Esto con el fin de descargar las dependencias)
* Mediante el comando "mvn clean test" se ejecutarán las pruebas unitarias
* En base al IDE que utilice ingrese a la clase MAIN y dar click en run



# URL del API

* https://dna.herokuapp.com/stats/
* https://dna.herokuapp.com/mutant/

# Nota importante 

* Ya que se desplegó en un entorno gratuito, tener en consideración la  politica de Heroku.
También la primera petición será algo lenta, por esa misma restricción que se especifica en el enlace.
https://devcenter.heroku.com/articles/free-dyno-hours.

* Aparte, que se tiene restricciones en la base de datos. 
https://elements.heroku.com/addons/heroku-postgresql
* Limite de filas: 10.000 
* Capacidad de almacenamiento: 1GB




