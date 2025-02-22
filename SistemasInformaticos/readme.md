# Sistemas Informáticos
# Instalación de Windows 10 y Configuración del Servidor Web Local

Este documento detalla el proceso de instalación de Windows 10 en una máquina virtual y la configuración de un servidor web local con XAMPP.

## 📌 Requisitos del sistema

Antes de la instalación, es importante asegurarse de que la maquina virtual cumple con los siguientes requisitos mínimos:

- **Procesador:** 1 GHz o más
- **RAM:** 1 GB (32 bits) o 2 GB (64 bits)
- **Espacio en disco:** 16 GB (32 bits) o 20 GB (64 bits)
- **Tarjeta gráfica:** DirectX 9 o posterior con controlador WDDM 1.0
- **Pantalla:** Resolución mínima de 800x600

Más información en [Soporte de Microsoft](https://support.microsoft.com/es-es/windows/requisitos-del-sistema-de-windows-10-6d4e9a79-66bf-7950-467c-795cf0386715).

---

## 🖥 Instalación de Windows 10 en Máquina Virtual

### 1️⃣ Configuración de la máquina virtual
1. Asignar nombre a la máquina virtual.
2. Seleccionar el sistema operativo Windows 10.
3. Configurar almacenamiento asignado.

### 2️⃣ Instalación del sistema operativo
1. Montar la ISO de Windows 10 en la unidad óptica virtual.
2. Iniciar la máquina virtual y esperar la carga del instalador.
3. Seleccionar idioma, formato de fecha y distribución de teclado.
4. Hacer clic en **"Instalar ahora"**.
5. Omitir la clave de producto si no se tiene una.
6. Elegir la versión de Windows 10 (Ejemplo: Pro X64).
7. Aceptar los términos de licencia.
8. Seleccionar "Instalar solo Windows".
9. Configurar particiones del disco (ejemplo: partición principal para instalación).
10. Esperar la instalación y el reinicio del sistema.

### 3️⃣ Configuración post-instalación
1. Seleccionar región e idioma de teclado.
2. Configurar una cuenta sin conexión.
3. Crear usuario y contraseña.
4. Configurar preguntas de seguridad.
5. Omitir configuraciones adicionales (asistente de voz, navegador, etc.).
6. Ajustar opciones de privacidad.
7. Esperar la carga de Windows.

---

## 🌐 Instalación y Configuración del Servidor Web Local con XAMPP

### 1️⃣ Instalación de XAMPP
1. Descargar el instalador de XAMPP.
2. Seleccionar únicamente Apache y desmarcar el resto de opciones.
3. Elegir el idioma de instalación.
4. Completar la instalación.
5. Permitir las excepciones en el firewall.

### 2️⃣ Configuración y prueba del servidor
1. Abrir el panel de control de XAMPP.
2. Iniciar Apache.
3. Comprobar que el servidor está funcionando.

### 3️⃣ Despliegue del proyecto web
1. Navegar a `C:\xampp\htdocs`.
2. Eliminar el archivo `index.php` predeterminado.
3. Copiar los archivos del proyecto en la carpeta `htdocs`.
4. Acceder desde el navegador a `http://localhost/` para visualizar la web.

---

## ✅ Conclusión
Este proceso permite tener un entorno de desarrollo funcional con Windows 10 y un servidor web local en XAMPP para pruebas y desarrollo de aplicaciones web.

---

📄 **Autor:** _(Tu Nombre)_  
📅 **Fecha:** _(Fecha del documento)_

