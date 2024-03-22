// Verificar los parámetros de la URL para mostrar la alerta correspondiente
const urlParams = new URLSearchParams(window.location.search);
const success = urlParams.has('success');
const error = urlParams.has('error');

if (success) {
    Swal.fire({
        icon: 'success',
        title: '¡Registro exitoso!',
        text: 'El usuario se ha registrado correctamente.',
    }).then(() => {
        history.replaceState(null, null, window.location.pathname);
    });
}

if (error) {
    Swal.fire({
        icon: 'error',
        title: '¡Error!',
        text: 'Ocurrió un error al registrar el usuario. Por favor, intenta nuevamente.',
    }).then(() => {
        history.replaceState(null, null, window.location.pathname);
    });
}

// Función para iniciar sesión
function iniciarSesion(event) {
    // Detener el envío predeterminado del formulario
    event.preventDefault();

    // Obtener los valores de email y contraseña del formulario
    var formData = new FormData(document.querySelector('form'));

// Realizar la solicitud POST al servidor
    fetch('/usuario/acceder', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            // Mostrar una alerta según la respuesta del servidor

            if (data !== undefined && data.codigo === "200" && data.mensaje !== undefined) {
                // Mostrar una alerta de éxito
                Swal.fire({
                    icon: 'success',
                    title: data.mensaje,
                    showConfirmButton: false,
                    timer: 1500
                });

                // Redireccionar si el mensaje indica éxito
                if (data.redireccion !== undefined) {
                    setTimeout(function () {
                        window.location.href = data.redireccion;
                    }, 1500); // Redirigir después de 1.5 segundos
                }
            }
            // Mostrar una alerta de error si el mensaje es incorrecto
            else {
                // Mostrar una alerta de error genérica si el mensaje está indefinido
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text:data.mensaje
                });
            }
        })
        .catch(error => {
            console.error('Error:', error);
            // Mostrar una alerta de error en caso de error en la solicitud
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Error al iniciar sesión. Por favor, intenta de nuevo más tarde.'
            });
        });
}









