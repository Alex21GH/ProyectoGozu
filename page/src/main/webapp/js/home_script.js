// JavaScript para mostrar y ocultar detalles
document.querySelectorAll('.read-more').forEach(function (button) {
    button.addEventListener('click', function () {
        const cardId = this.closest('.card').id;
        const detailContent = document.querySelector('#detail-content');
        detailContent.innerHTML = obtenerContenido(cardId);
        document.querySelector('#details').classList.add('show-details');
    });
});

document.querySelector('.close').addEventListener('click', function () {
    document.querySelector('#details').classList.remove('show-details');
});

// Función para obtener el contenido detallado según la tarjeta seleccionada
function obtenerContenido(cardId) {
    switch (cardId) {
        case 'oracle-card':
            return 'Detalles sobre Oracle Database.';
        case 'golden-gate-card':
            return 'Detalles sobre GoldenGate.';
        // Agrega más casos para otras tarjetas aquí
        default:
            return 'Detalles no disponibles.';
    }
}
