
window.onload = function () {
    // Variables
    const IMAGENES = [
        'resources/media/img/carousel-1.jpg',
        'resources/media/img/carousel-2.webp',
        'resources/media/img/carousel-3.jpg'
    ];
    const TIEMPO_INTERVALO_MILESIMAS_SEG = 8000;
    let posicionActual = 0;
    let $botonRetroceder = document.querySelector('#retroceder');
    let $botonAvanzar = document.querySelector('#avanzar');
    let $imagen = document.querySelector('#imagen');
    var intervalo;

    // Funciones

    /**
     * Función para cambiar la imagen con efecto de fade
     */
    function cambiarImagen() {
        $imagen.style.opacity = 0; // Fade out
        setTimeout(() => {
            $imagen.style.backgroundImage = `url(${IMAGENES[posicionActual]})`;
            $imagen.style.opacity = 1; // Fade in
        }, 500); // Tiempo para el fade out antes del cambio
    }

    /**
     * Función que cambia la foto a la siguiente posición con efecto fade
     */
    function pasarFoto() {
        if (posicionActual >= IMAGENES.length - 1) {
            posicionActual = 0;
        } else {
            posicionActual++;
        }
        cambiarImagen();
    }

    /**
     * Función que cambia la foto a la posición anterior con efecto fade
     */
    function retrocederFoto() {
        if (posicionActual <= 0) {
            posicionActual = IMAGENES.length - 1;
        } else {
            posicionActual--;
        }
        cambiarImagen();
    }

    function playIntervalo() {
        cambiarImagen(); // Cambia la imagen
        intervalo = setInterval(pasarFoto, TIEMPO_INTERVALO_MILESIMAS_SEG);
    }

    // Eventos
    $botonAvanzar.addEventListener('click', () => {
        pasarFoto(); // Cambia la imagen
    });

    $botonRetroceder.addEventListener('click', () => {
        retrocederFoto(); // Cambia la imagen
    });

    // Iniciar el autoplay al cargar la página
    playIntervalo();


    // Eventos



    // Iniciar
    $imagen.style.transition = "opacity 0.5s ease-in-out"; // Transición suave
    playIntervalo();
};
