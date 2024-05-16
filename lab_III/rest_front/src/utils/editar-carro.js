async function editarCarro(carro, carregarCarros) {
    const { value: formValues } = await Swal.fire({
        title: 'Editar Carro',
        html:
            `<input id="swal-marca" class="swal2-input" value="${carro.marca}" placeholder="Marca">` +
            `<input id="swal-modelo" class="swal2-input" value="${carro.modelo}" placeholder="Modelo">`,
        focusConfirm: false,
        showCancelButton: true,
        confirmButtonText: 'Salvar',
        cancelButtonText: 'Cancelar',
        
        preConfirm: () => {
            const marcaInput = document.getElementById('swal-marca').value.trim();
            const modeloInput = document.getElementById('swal-modelo').value.trim();

            // Verificar se os campos estão vazios
            if (!marcaInput || !modeloInput) {
                Swal.showValidationMessage('Por favor, preencha todos os campos');
                return false;
            }

            return { marca: marcaInput, modelo: modeloInput };
        }
    });

    if (formValues) {
        const { marca, modelo } = formValues;
        try {
            const response = await fetch(`http://localhost:8080/carros/${carro.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ 
                    id: carro.id, 
                    marca: marca, 
                    modelo: modelo 
                })
            });
            if (response.ok) {
                Swal.fire('Carro atualizado com sucesso!', '', 'success');
                carregarCarros();
            } else {
                Swal.fire('Erro ao atualizar carro!', '', 'error');
            }
        } catch (error) {
            console.error('Erro ao atualizar carro:', error);
            Swal.fire('Erro ao atualizar carro!', '', 'error');
        }
    }
};
