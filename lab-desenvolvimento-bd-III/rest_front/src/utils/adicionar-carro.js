let nextId = 11; // Valor inicial

async function fetchNextId() {
    try {
        const response = await fetch('http://localhost:8080/carros');
        const data = await response.json();

        if (response.ok) {
            const ids = data.map(car => car.id);
            nextId = Math.max(...ids) + 1;
        } else {
            console.error('Erro ao buscar a lista de carros:', data.mensagem);
            nextId = 11; // Fallback caso ocorra um erro
        }
    } catch (error) {
        console.error('Erro ao buscar a lista de carros:', error);
        nextId = 11; // Fallback caso ocorra um erro
    }
}

async function carregarCarros() {
    try {
        const response = await fetch('http://localhost:8080/carros');
        const data = await response.json();
        const carrosLista = document.getElementById('carros-lista');
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
}

async function adicionarCarro(event) {
    event.preventDefault();

    const marca = document.getElementById('marca').value;
    const modelo = document.getElementById('modelo').value;

    const formData = {
        id: nextId,
        marca: marca,
        modelo: modelo,
    }

    try {
        const response = await fetch('http://localhost:8080/carros', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData),
        });
        const data = await response.json();
        console.log(data);

        if (response.ok) {
            Swal.fire({
                icon: 'success',
                title: 'Sucesso!',
                text: data.mensagem
            }).then(() => {
                const modal = document.getElementById('modal');
                modal.style.display = 'none'; // Fecha o modal após o sucesso
                carregarCarros(); // Recarrega a lista de carros
                nextId++;
                // Limpa os campos do modal
                document.getElementById('marca').value = '';
                document.getElementById('modelo').value = '';
            });
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Erro!',
                text: data.mensagem
            });
        }
    } catch (error) {
        console.error(error);
        Swal.fire({
            icon: 'error',
            title: 'Erro!',
            text: 'Erro ao processar a requisição'
        });
    }
}

document.addEventListener('DOMContentLoaded', async () => {
    await fetchNextId(); // Busca o próximo ID ao carregar a página
    await carregarCarros(); // Carrega a lista de carros ao carregar a página

    const adicionarCarroBtn = document.getElementById('adicionarCarro');
    if (adicionarCarroBtn) {
        adicionarCarroBtn.addEventListener('click', adicionarCarro);
    } else {
        console.error('Botão "Adicionar Carro" não encontrado.');
    }
});
