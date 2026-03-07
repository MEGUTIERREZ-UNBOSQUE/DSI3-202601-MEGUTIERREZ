const PESOS = [0.050, 0.100, 0.100, 0.100, 0.150, 0.150, 0.150, 0.200];

const bromas = {
  perfecto: [
    `Profe, por ser usted le invito una empanada `,
    `Profe usted es el mejor, siempre lo he dicho `,
    `Profe ya ve que sí estudié, le debo una gaseosa `,
  ],
  aprobado: [
    `Profe no se arrepienta, usted tomó la decisión correcta `,
    `Profe gracias, prometo que el próximo semestre también paso `,
    `Profe si me sube una décima quedo en 5.0, piénselo `,
  ],
  borde: [
    `Profe no sea malito, súbame aunquito `,
    `Profe con ese 3.0 me salvó la vida, le regalo un café `,
    `Profe usted tiene cara de buena persona, me lo confirma el 3.0 `,
  ],
  reprobado: [
    `Profe no sea así, súbame alguito por favor `,
    `Profe yo asistí casi siempre, eso no vale algo? `,
    `Profe si me pasa le juro que el próximo semestre sí estudio `,
    `Profe usted no va a dejar perder a un pelado con tanto potencial `,
  ]
};

const aleatorio = arr => arr[Math.floor(Math.random() * arr.length)];

const bromaClave = nota => {
  if (nota >= 5.0) return 'perfecto';
  if (nota >= 3.5) return 'aprobado';
  if (nota >= 3.0) return 'borde';
  return 'reprobado';
};

// Generar inputs
const inputsEl = document.getElementById('inputs');
PESOS.forEach((p, i) => {
  inputsEl.insertAdjacentHTML('beforeend', `
    <div class="input-grupo">
      <label class="input-grupo__label" for="nota${i}">Nota ${i + 1}</label>
      <span class="input-grupo__ponder">${p * 100}%</span>
      <input class="input-grupo__campo" type="number" id="nota${i}"
             min="0" max="5" step="0.1" placeholder="0 – 5" />
    </div>
  `);
});

document.getElementById('btnCalcular').addEventListener('click', () => {
  const notas = PESOS.map((_, i) => {
    const v = parseFloat(document.getElementById(`nota${i}`).value);
    return isNaN(v) ? 0 : Math.min(5, Math.max(0, v));
  });

  const final     = notas.reduce((s, n, i) => s + n * PESOS[i], 0);
  const clave     = bromaClave(final);
  const aprobado  = final >= 3.0;
  const mod       = clave === 'borde' ? 'borde' : aprobado ? 'aprobado' : 'reprobado';

  const parcial   = notas.slice(0, 7).reduce((s, n, i) => s + n * PESOS[i], 0);
  const necesaria = (3.0 - parcial) / PESOS[7];

  document.getElementById('notaFinal').textContent = final.toFixed(3);
  document.getElementById('notaFinal').className   = `resultado__nota resultado__nota--${mod}`;

  document.getElementById('estado').textContent = aprobado ? '✓ Aprobado' : '✗ Reprobado';
  document.getElementById('estado').className   = `resultado__estado resultado__estado--${mod}`;

  document.getElementById('broma').innerHTML = aleatorio(bromas[clave]);

  document.getElementById('minima').textContent = necesaria <= 5
    ? `Para aprobar necesitabas un ${necesaria.toFixed(2)} en la nota 8.`
    : `Ni con 5.0 en la nota 8 pasabas. Eso ya es talento.`;

  const resEl = document.getElementById('resultado');
  resEl.hidden = false;
  resEl.scrollIntoView({ behavior: 'smooth', block: 'start' });
});