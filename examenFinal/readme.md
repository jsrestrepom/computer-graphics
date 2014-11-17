Examen Final
============

0. Estructura del proyecto
--------------------------
La arquitectura de la implemetacion es modular. Asi, el modulo **punto-uno** indica que contiene el codigo especifico para la solucion del punto uno del examen, el modulo **computer-graphics-core**, indica es el *core* de los temas tratados en el curso; por ultimo el modulo **examenFinal-builder** es el orquestador de todo el proyecto, se crea debido a la relacion de dependencia que existe entre los modulos.


La estructura de directorios debe ser la siguiente:

>\.<br />
>|<br />
>\+ computer-graphics-core<br />
>>|<br />
>>\+ src<br />
>>\+ pom.xml<br />
>
>\+ examenFinal-builder<br />
>>|<br />
>>\+ src<br />
>>\+ pom.xml<br />
>
>\+ examenFinal-captures<br />
>\+ punto-uno<br />
>>|<br />
>>\+ src<br />
>>\+ pom.xml<br />
>
>\+ final20142.pdf<br />
>\+ readme.md<br />


1. Ray Tracing
--------------
Se utilizan los modulos **punto-uno**, **computer-graphics-core** y **examenFinal-builder**. Para su compilacion se puede optar por dos alternativas, la primera utilizando el IDE de preferencia es importar los modulos **punto-uno** y **computer-graphics-core** como proyectos; la opcion para usuario de [maven](http://maven.apache.org) es ejecutar los siguientes comandos desde la base del proyecto:


``cd examenFinal-builder`` para acceder al pom.xml del proyecto orquestador, seguido de ``mvn clean package`` para dar inicio a la ejecucion de los modulos.


La clase principal es ``Main.java`` que esta en el modulo **punto-uno**

