# Desarrollo de una aplicación JEE basado en EJB, JSF y JPA para el intercambio de datos en una aplicación empresarial.

Objetivos de la practica

Diseñar y desarrollar modelos de software en diferentes niveles de abstracción y modelos de datos a nivel transaccional y analítico con entornos de desarrollo actuales

DIAGRAMA DE CLASES

![diagrama proyecto plataformas](https://user-images.githubusercontent.com/34014602/88569032-76810b00-cfff-11ea-89b5-e94d91d319fd.png)

DESARROLLO

1. Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 03: EJB, JSF y JPA”

![1](https://user-images.githubusercontent.com/34014602/88570605-f4461600-d001-11ea-949c-d3996bf95a50.png)

2. Desarrollar una aplicación con tecnología JEE para gestionar la facturación de una distribuidora de productos para el hogar en la web

Sección privada

- El sistema debe permitir iniciar sesión y si tiene el rol de administrador puede:

![admi](https://user-images.githubusercontent.com/49315481/88585160-5873d480-d018-11ea-87c2-287bf43eca90.jpg)
- Gestionar bodegas (consulta de inventario general)

![gestionBodegas](https://user-images.githubusercontent.com/49315481/88584464-42b1df80-d017-11ea-88b5-fdfce6554064.jpg)

- Gestionar productos (aumentar stock por bodega)

![gestionProducto](https://user-images.githubusercontent.com/49315481/88584469-45143980-d017-11ea-9066-f5cad3016f14.jpg)
![gestionProducto2](https://user-images.githubusercontent.com/49315481/88584471-46456680-d017-11ea-9eb1-a51dce9a7ef8.jpg)

- Gestionar productos por bodega (consulta de inventario por bodega)

![gestionBodegasProduct](https://user-images.githubusercontent.com/49315481/88584466-43e30c80-d017-11ea-9b80-d6b9dfa4e8df.jpg)
4-fb1f216ebb76.jpg)

- El administrador me permite crear roles.

![roles](https://user-images.githubusercontent.com/49315481/88584486-4b0a1a80-d017-11ea-8ab4-e9c446f37f50.jpg)

- El empleado gestiona clientes 

![EmpleClientes](https://user-images.githubusercontent.com/49315481/88584453-404f8580-d017-11ea-86d1-a72ff494cb57.jpg)
 

- El empleado gestiona facturas

![EmpleFact](https://user-images.githubusercontent.com/49315481/88584461-4180b280-d017-11ea-972c-72e9a8128116.jpg)

Sección pública

- El sistema debe permitir ver el catálogo de productos organizados por categorías y bodegas.

![index](https://user-images.githubusercontent.com/49315481/88584477-48a7c080-d017-11ea-9987-e29562b05cc6.jpg)

- Iniciar Sesión

![iniciarSesion](https://user-images.githubusercontent.com/49315481/88584483-4a718400-d017-11ea-9b39-b7254a534180.jpg)


3. Realizar varios commits en la herramienta GitHub que demuestren el desarrollo de la aplicación

![commit](https://user-images.githubusercontent.com/49315481/88584448-3f1e5880-d017-11ea-9cfb-698bc4e4d800.jpg)

4. Implementar el README del repositorio del proyecto con la misma información del informe de la práctica

Link del repositorio: https://github.com/HenryGuaman/Practica-de-laboratorio-03-EJB-JSF-y-JPA 



5. Alojar una aplicación web que permita presentar servicios web Restful en una plataforma en la nube usando como front-end JSF y Angular.

a. Convertir el proyecto a Maven y colocar las dependencias referentes a la aplicación. 

![ConMaven](https://user-images.githubusercontent.com/49315481/88585753-11d2aa00-d019-11ea-9975-f359d2cee15b.jpg)

b. Luego procedemos a crear una máquina virtual  cdonde tendremos instalado glassfish, jenkins, Java jdk 8, y Maven la máquina fue creada en Google Cloud Platform.

![google](https://user-images.githubusercontent.com/49315481/88587808-2b292580-d01c-11ea-915c-33c2678a6084.jpg)

Podemos observar que se encuentra la practica dentro del servidor glassfish.

![glass](https://user-images.githubusercontent.com/49315481/88588164-bc989780-d01c-11ea-94e8-14b6ebefaaf8.jpg)

c. Configuramos el jenkins.

- La parte de clonar el git.

![jenkis1](https://user-images.githubusercontent.com/49315481/88588308-f1a4ea00-d01c-11ea-9412-f6689e6f8845.jpg)

- Comando para ejecutar el programa.

![jenkis2](https://user-images.githubusercontent.com/49315481/88588428-287b0000-d01d-11ea-8a69-8e6b94a66a68.jpg)

- Mandamos a construir y podemos observar la consola que no da error.

![construir](https://user-images.githubusercontent.com/49315481/88588570-611ad980-d01d-11ea-95d8-2e03db3e74fd.jpg)


d. Luego configuramos el git para que Jenkins pueda escuchar los cambios de push que tenemos en github.

![git2](https://user-images.githubusercontent.com/49315481/88588849-d1c1f600-d01d-11ea-9b57-0fc0acd0fbf3.jpg)

e. Configuración de la base de datos.

- Creamos una base de datos en google cloud.

![sql](https://user-images.githubusercontent.com/49315481/88588975-0b92fc80-d01e-11ea-955c-66f63411b678.jpg)

- Luego configuramos el glassfish local es decir de eclipse (view admin console), donde colocamos la ip de la base de datos creada en google cloud.

![sql2](https://user-images.githubusercontent.com/49315481/88589311-8e1bbc00-d01e-11ea-8b62-66e8176c8117.jpg)

f. Finalmente se despliega la aplicación.

![despliegue](https://user-images.githubusercontent.com/49315481/88589489-dc30bf80-d01e-11ea-8e4e-870001d1173d.jpg)



RESULTADOS OBTENIDOS:

• Manejo de diferentes formatos para el intercambio de datos entre aplicaciones.

• Diseño y desarrollo de aplicaciones en capas con nuevas tecnologías.

• Despliegue del proyecto en google cloud.

CONCLUSIONES:

•	En el desarrollo de esta practica se presento muchos problemas con el servidor debido a que es muy delicado el mínimo cambio empieza a fallar sin embargo se pudo solucionar y concluir con la práctica.

•	El uso de EJB, JSF, JPA son muy importantes y necesario para el desarrollo de las páginas web.

• Existian diferentes problemas al momento de realizar el despliegue ya sea con el servidor glassfhis o con jenkins, sin embargo al final se pudo solucionar y poder concluir con la practica. 

RECOMENDACIONES:

•	Aplicar los conocimientos en uso y manejo de EJB, JSF, JPA.

•	Observar las diapositivas indicadas en clases.

• Crear máquina virtual en google cloud o alguna otra herramienta.

INTEGRANTES

- Jonnathan Matute

- Javier Yunga 

- Henry Guamán

- Marcelo Durazno.





