function generarInputs() {
  var n = numCasos.value;

  if (n < 1 || n > 100) {
    alert("Ingresa un número entre 1 y 50");
    return;
  }

  var html = "";

  for (var i = 1; i <= n; i++) {
    html += "<div class='estudiante'>";
    html += "<span class='estudiante__label'>Caso " + i + "</span>";
    html += "<div class='estudiante__notas'>";
    html += "<input class='form__input' type='number' id='b" + i + "' min='0' placeholder='Brasil'>";
    html += "<input class='form__input' type='number' id='c" + i + "' min='0' placeholder='Colombia'>";
    html += "</div>";
    html += "<span class='estudiante__resultado' id='r" + i + "'></span>";
    html += "</div>";
  }

  casosContainer.innerHTML = html;
}

function calcularPartidos() {
  var n = numCasos.value;

  for (var i = 1; i <= n; i++) {
    var brasil = Number(window["b" + i].value);
    var colombia = Number(window["c" + i].value);

    if (brasil < 1 || brasil > 100 || colombia < 1 || colombia > 100) {
      alert("Caso " + i + ": los puntajes deben estar entre 1 y 100");
      return;
    }

    var resultado = "";

    if (colombia > brasil) {
      resultado = "¡Ganamos!";
    } else if (brasil > colombia) {
      resultado = "Perdimos";
    } else {
      resultado = "Casi ganamos";
    }

    window["r" + i].innerHTML = resultado;
  }
}