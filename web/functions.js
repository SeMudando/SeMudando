// Get the container element
var btnContainer = document.getElementById("form-unica-bts");

// Get all buttons with class="btn-valor" inside the container
var btns = btnContainer.getElementsByClassName("btn-valor");

// PEGA A REFERENCIA DO BOTÃO QUE VOCE VAI ALTERAR O TEXTO -- milena
var btnDoar = document.getElementsByClassName("btn-doar");

// Loop through the buttons and add the active class to the current/clicked button
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function () {
    var current = document.getElementsByClassName("activebtn");

    // If there's no active class
    if (current.length > 0) {
      current[0].className = current[0].className.replace(" activebtn", "");
    }

    // Add the active class to the current/clicked button
    this.className += " activebtn";

    //Altera o texto do botão de doar -- milena
    btnDoar[0].innerText = "Doar " + this.innerText;
  });
}

// Escolha do tipo de doação
var radios = document.querySelectorAll('#flexRadioDefault1');
var optdoar = document.querySelectorAll('.tab1');
for (var radio of radios) {
  radio.onclick = (e) => {
    console.log(e.target.value);
    
  }
}

function openCity(evt, cityName) {
  var i, tabcontents, tablinkss;
  tabcontent = document.getElementsByClassName("tabcontents");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinkss");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active2", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active2";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("default-open").click();