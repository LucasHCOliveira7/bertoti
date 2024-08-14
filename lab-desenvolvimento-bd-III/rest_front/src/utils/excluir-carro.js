async function excluirCarro(carroId, carregarCarros) {
    try {
        const response = await fetch(`http://localhost:8080/carros/${carroId}`, {
            method: 'DELETE'
        });
        if (response.ok) {
            Swal.fire('Carro excluído com sucesso!', '', 'success');
            carregarCarros();
        } else {
            Swal.fire('Erro ao excluir carro!', '', 'error');
        }
    } catch (error) {
        console.error('Erro ao excluir carro:', error);
        Swal.fire('Erro ao excluir carro!', '', 'error');
    }
};
