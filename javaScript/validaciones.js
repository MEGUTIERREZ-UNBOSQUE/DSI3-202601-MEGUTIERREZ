document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('sendBtn').addEventListener('click', (event) => {

        const nombre = document.getElementById('nombre').value;
        const edad = parseInt(document.getElementById('edad').value, 10);

        const resultado = document.getElementById('resultado');
        const resultText = document.getElementById('resultText');


        if (!nombre) {
            mostrarError('Por favor ingresa tu nombre.');
            return;
        }
        if (isNaN(edad) || edad < 0) {
            mostrarError('Por favor ingresa una edad válida.');
            return;
        }

        console.log(`Hola ${nombre}`);

        if (edad >= 18) {
            resultText.textContent = `${nombre}, eres mayor de edad`;
             setTimeout(() => alert(`${nombre}, eres mayor de edad`), 0);
        } else {
            resultText.textContent = `${nombre}, eres menor de edad`;
            setTimeout(() => alert(`${nombre}, eres menor de edad`), 0);
        }
    });
});

function mostrarError(msg) {
    const resultado = document.getElementById('resultado');
    const resultText = document.getElementById('resultText');

    resultText.textContent = msg;
    resultado.classList.add('error', 'visible');
}