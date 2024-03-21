
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

