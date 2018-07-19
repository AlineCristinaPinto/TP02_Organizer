class Item {
    constructor(tipo, nome, descricao, data, arrTags) {
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.arrTags = arrTags;
    }
};

let arrItens = new Array();
let arrT = ["Tag 1", "Tag 2", "Tag 3"];

arrItens.push(new Item("tarefa", "Tarefa 1", "Tarefa 1 de teste", "", arrT),
              new Item("lembrete", "Lembrete 1", "Lembrete 1 de teste", "20/07/2018", ""),
              new Item("simples", "Simples 1", "Simples 1 de teste", "", ""));

function insereItem(item) {
	let ulItem = document.querySelector('#ulItens');
  let liNome = document.createElement('li');
  let pEspaco = document.createElement('p');

  let divDropDown = document.createElement('div');
  let ulDesc = document.createElement('ul');
  let liDesc = document.createElement('li');
  let liTags = document.createElement('li');
  let liData = document.createElement('li');

  ulDesc.setAttribute('class', 'submenuItems');
  liDesc.setAttribute('id', 'subItem');
  liDesc.setAttribute('class', 'liDescricao');
  liTags.setAttribute('class', 'liDescricao');
  liData.setAttribute('class', 'liDescricao');
  liData.setAttribute('style', 'text-align: right');
  divDropDown.setAttribute('class', 'dropdownlink');

  if(item.tipo == 'tarefa'){
    liNome.setAttribute('id', 'liTarefa');

    let label = document.createElement('label');
    let input = document.createElement('input');
    let span = document.createElement('span');

    label.setAttribute('class', 'container');
    input.setAttribute('type', 'checkbox');
    input.setAttribute('name', 'tarefa');
    input.setAttribute("value", trim(item.nome));
    span.setAttribute('class', 'checkmark');

    divDropDown.innerHTML = item.nome;
    label.setAttribute('style', 'float:left');

    label.appendChild(input);
    label.appendChild(span);
    liNome.appendChild(label);
    liNome.appendChild(divDropDown);

  } else if(item.tipo == 'lembrete'){
    liNome.setAttribute('id', 'liLembrete');
    divDropDown.innerHTML = item.nome;
    liNome.appendChild(divDropDown);
  } else {
    liNome.setAttribute('id', 'liSimples');
    divDropDown.innerHTML = item.nome;
    liNome.appendChild(divDropDown);
  }

  liDesc.innerHTML = item.descricao;

  if(item.data != ""){
    liData.innerHTML = item.data;
  }

  if(item.arrTags != ""){
    let tags = "";
    let vetTags = item.arrTags;
    for (let count = 0; count < vetTags.length; count++){
      tags += "#" + vetTags[count] + " | ";
    }
    liTags.innerHTML = tags;
  }

  ulDesc.appendChild(liDesc);
  if(item.arrTags != ""){
    ulDesc.appendChild(liTags);
  }
  if(item.data != ""){
    ulDesc.appendChild(liData);
  }
  liNome.appendChild(ulDesc);

  ulItem.appendChild(liNome);
  ulItem.appendChild(pEspaco);
}

function trim(str) {
	return str.replace(' ', '');
}

arrItens.forEach(insereItem);
