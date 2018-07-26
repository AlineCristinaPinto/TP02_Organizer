$(function() {
  $("#novaTag").click(function() {
    $("#tagsMenu").modal();
  });
})

// Fazer onclick no modal para inserir

function insereTagMenu(nome){
  let ulTag = document.querySelector('#ulTagMenu');
  let liNome = document.createElement('li');
  let aNome = document.createElement('a');
  let label = document.createElement('label');
  let input = document.createElement('input');
  let span = document.createElement('span');

  aNome.setAttribute('href', '#');
  label.setAttribute('class', 'container');
  input.setAttribute('type', 'checkbox');
  input.setAttribute('name', 'tag');
  input.setAttribute("value", nome);
  span.setAttribute('class', 'checkmark');

  label.innerHTML = nome;

  label.appendChild(input);
  label.appendChild(span);
  aNome.appendChild(label);
  liNome.appendChild(aNome);
  ulTag.appendChild(liNome);
}
