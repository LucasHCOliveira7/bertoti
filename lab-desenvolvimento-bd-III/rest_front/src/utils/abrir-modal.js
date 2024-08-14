document.addEventListener('DOMContentLoaded', () => {
    const adicionarCarroLink = document.getElementById('adicionar-carro');
    const modal = document.getElementById('modal');
    const closeModal = document.getElementById('close-modal');
    const close = document.getElementById('close');

    adicionarCarroLink.addEventListener('click', () => {
        modal.style.display = 'block';
    });

    closeModal.addEventListener('click', () => {
        modal.style.display = 'none';
    });

    close.addEventListener('click', () => {
        modal.style.display = 'none';
    });

    window.addEventListener('click', (event) => {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
});
