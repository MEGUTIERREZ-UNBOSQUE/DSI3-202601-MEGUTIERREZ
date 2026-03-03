function mostrarMensaje(mensaje, segundos) {
  setTimeout(function () {
    alert(mensaje);
  }, segundos * 1000);
}

function crearPromesa(nombre, tiempo) {
  return new Promise(function(resolve, reject) {
    var variacion = Math.floor(Math.random() * 1000);
    console.log(variacion);     
    var tiempoFinal = (tiempo * 1000) + variacion;
    setTimeout(function() {
      var ok = Math.random() > 0.5;
      if (ok) resolve(nombre + " gano en " + tiempoFinal + "ms");
      else     reject(new Error(nombre + " fallo en " + tiempoFinal + "ms"));
    }, tiempoFinal);
  });
}

function ejecutar(segundos) {
  var p1 = crearPromesa("Promesa 1", segundos);
  var p2 = crearPromesa("Promesa 2", segundos);
  var p3 = crearPromesa("Promesa 3", segundos);

  Promise.race([p1, p2, p3])
    .then(function(resultado) {
      alert(resultado);
    })
    .catch(function(error) {
      alert(error.message);
    });
}