function generarSelects() {
  const t = parseInt(document.getElementById("numJuegos").value);
  const container = document.getElementById("selects-container");
  container.innerHTML = "";

  if (isNaN(t) || t < 1 || t > 100) {
    alert("Ingresa un número entre 1 y 100.");
    return;
  }

  for (let i = 1; i <= t; i++) {
    const fila = document.createElement("div");
    fila.className = "fila-ronda";

    const etiqueta = document.createElement("span");
    etiqueta.textContent = "Ronda " + i + ":";

    const select = document.createElement("select");
    select.id = "ronda-" + i;

    const opciones = ["ALICE", "BOB", "EMPATE"];
    opciones.forEach(function(op) {
      const option = document.createElement("option");
      option.value = op;
      option.textContent = op;
      select.appendChild(option);
    });

    fila.appendChild(etiqueta);
    fila.appendChild(select);
    container.appendChild(fila);
  }

  const btnCalcular = document.createElement("button");
  btnCalcular.id = "btn-calcular";
  btnCalcular.textContent = "Calcular";
  btnCalcular.onclick = calcular;
  container.appendChild(btnCalcular);
}

function calcular() {
  const t = parseInt(document.getElementById("numJuegos").value);
  let puntosAlice = 0;
  let puntosBob = 0;

  for (let i = 1; i <= t; i++) {
    const resultado = document.getElementById("ronda-" + i).value;

    if (resultado === "ALICE") {
      puntosAlice += 2;
    } else if (resultado === "BOB") {
      puntosBob += 2;
    } else {
      puntosAlice += 1;
      puntosBob += 1;
    }
  }

  let ganador;
  if (puntosAlice > puntosBob) {
    ganador = "ALICE";
  } else if (puntosBob > puntosAlice) {
    ganador = "BOB";
  } else {
    ganador = "EMPATE";
  }
console.log("Alice: " + puntosAlice + " puntos | Bob: " + puntosBob + " puntos");
  alert(ganador);
}