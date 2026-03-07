const inputN     = document.getElementById('numCasos');
const contenedor = document.getElementById('casosContenedor');
const btnVerif   = document.getElementById('btnVerificar');
const resultado  = document.getElementById('resultados');

const pines = n => Array.from({length: 6}, (_, i) => `
  <div class="caso__pin">
    <label class="caso__etiqueta">${i + 1}</label>
    <input class="caso__campo" type="number" min="0" max="1" placeholder="0/1" data-caso="${n}" />
  </div>
`).join('');

const leerFila = fila => [...fila.querySelectorAll('.caso__campo')].map(i => i.value.trim());
const valida   = vals => vals.length === 6 && vals.every(v => v === '0' || v === '1');
const compatible = (a, b) => a.every((v, i) => Number(v) + Number(b[i]) === 1);

document.getElementById('btnGenerar').addEventListener('click', () => {
  const n = parseInt(inputN.value);
  if (isNaN(n) || n < 1 || n > 100) return alert('Ingresa un número entre 1 y 100.');

  contenedor.innerHTML = resultado.innerHTML = '';
  btnVerif.hidden = false;

  for (let i = 1; i <= n; i++) {
    contenedor.insertAdjacentHTML('beforeend', `
      <article class="caso">
        <p class="caso__titulo">Caso ${i}</p>
        <div class="caso__columnas">
          <div class="caso__col">
            <p class="caso__col-titulo">Conector</p>
            <div class="caso__fila">${pines(i)}</div>
          </div>
          <div class="caso__col">
            <p class="caso__col-titulo">Tomacorriente</p>
            <div class="caso__fila">${pines(i)}</div>
          </div>
        </div>
      </article>
    `);
  }
});

btnVerif.addEventListener('click', () => {
  resultado.innerHTML = '';
  const txt = { compatible: 'COMPATIBLE', incompatible: 'INCOMPATIBLE', invalido: 'Entrada inválida — todos los valores deben ser 0 o 1' };

  contenedor.querySelectorAll('.caso').forEach((caso, i) => {
    const [colA, colB] = caso.querySelectorAll('.caso__fila');
    const a = leerFila(colA), b = leerFila(colB);
    const mod = !valida(a) || !valida(b) ? 'invalido' : compatible(a, b) ? 'compatible' : 'incompatible';
    resultado.insertAdjacentHTML('beforeend',
      `<div class="resultado resultado--${mod}">Caso ${i + 1}: ${txt[mod]}</div>`
    );
  });
});