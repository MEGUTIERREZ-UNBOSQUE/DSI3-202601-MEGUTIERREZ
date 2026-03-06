function generarInputs() {
  var n = numEstudiantes.value;

  if (n < 1 || n > 50) {
    alert("Ingresa un número entre 1 y 50");
    return;
  }

  var html = "";

  for (var i = 1; i <= n; i++) {
    html += "<div class='estudiante'>";
    html += "<span class='estudiante__label'>Estudiante " + i + "</span>";
    html += "<div class='estudiante__notas'>";
    html += "<input class='form__input' type='number' id='n" + i + "a' min='0' max='50'>";
    html += "<input class='form__input' type='number' id='n" + i + "b' min='0' max='50'>";
    html += "<input class='form__input' type='number' id='n" + i + "c' min='0' max='50'>";
    html += "</div>";
    html += "<span class='estudiante__resultado' id='r" + i + "'></span>";
    html += "</div>";
  }

  estudiantesContainer.innerHTML = html;
}

function calcularNotas() {
  var n = numEstudiantes.value;

  for (var i = 1; i <= n; i++) {
    var a = Number(window["n" + i + "a"].value);
    var b = Number(window["n" + i + "b"].value);
    var c = Number(window["n" + i + "c"].value);

    if (a < 1 || a > 100 || b < 1 || b > 100 || c < 1 || c > 100) {
      alert("Estudiante " + i + ": las notas deben estar entre 1 y 100");
      return;
    }
    if (a == b || b == c || a == c) {
      alert("Estudiante " + i + ": las 3 notas deben ser diferentes");
      return;
    }


    var notas = [a, b, c];
    notas.sort(function(x, y) { return x - y; });

    window["r" + i].innerHTML = "Nota final: " + notas[1];
  }
}
