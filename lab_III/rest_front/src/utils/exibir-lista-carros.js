document.addEventListener('DOMContentLoaded', async () => {
    const carrosLista = document.getElementById('carros-lista');

    const carregarCarros = async () => {
        try {
            const response = await fetch('http://localhost:8080/carros');
            const data = await response.json();
            console.log(data);
            carrosLista.innerHTML = '';
            data.forEach(carro => {
                const li = document.createElement('li');
                const nomeCarro = document.createElement('p');
                nomeCarro.textContent = `${carro.marca} ${carro.modelo}`;
                li.appendChild(nomeCarro);
                carrosLista.appendChild(li);

                li.addEventListener('click', () => {
                    Swal.fire({
                        title: 'Escolha uma ação',
                        showCancelButton: true,
                        showDenyButton: true,
                        confirmButtonText: 'Editar',
                        denyButtonText: 'Excluir',
                        cancelButtonText: 'Cancelar'
                    }).then((result) => {
                        if (result.isConfirmed) {
                            editarCarro(carro, carregarCarros);
                        } else if (result.isDenied) {
                            excluirCarro(carro.id, carregarCarros);
                        }
                    });
                });
            });
        } catch (error) {
            console.error('Erro ao carregar carros:', error);
        }
    };
});
