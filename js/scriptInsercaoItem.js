class Item {
    constructor(tipo, nome, descricao, data, arrTags) {
        this.tipo = tipo;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.arrTags = arrTags;
    }
};

function insereItem(item) {
  let ulItem = document.querySelector('#ulItens');
  let liNome = document.createElement('li');
  let pEspaco = document.createElement('p');

  let divDropDown = document.createElement('div');
  let ulDesc = document.createElement('ul');
  let liDesc = document.createElement('li');
  let liTags = document.createElement('li');
  let liData = document.createElement('li');
  let botaoOp = document.createElement('button');
  let iBotao = document.createElement('i');

  ulDesc.setAttribute('class', 'submenuItems');
  liDesc.setAttribute('id', 'subItem');
  liDesc.setAttribute('class', 'liDescricao');
  liTags.setAttribute('class', 'liDescricao');
  liData.setAttribute('class', 'liDescricao');
  liData.setAttribute('style', 'text-align: right');
  divDropDown.setAttribute('class', 'dropdownlink');
  botaoOp.setAttribute('class', 'opcoesItem');
  botaoOp.setAttribute('data-toggle', 'modal');
  iBotao.setAttribute('class', 'fa fa-ellipsis-v');

  botaoOp.appendChild(iBotao);

  if(item.tipo == 'tarefa'){
    liNome.setAttribute('id', 'liTarefa');
    botaoOp.setAttribute('data-target', '#btaoOpcaoModalTarefa');

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
    liNome.appendChild(botaoOp);
    liNome.appendChild(divDropDown);

  } else if(item.tipo == 'lembrete'){
    botaoOp.setAttribute('data-target', '#btaoOpcaoModalLembrete');

    liNome.setAttribute('id', 'liLembrete');
    divDropDown.innerHTML = item.nome;
    liNome.appendChild(botaoOp);
    liNome.appendChild(divDropDown);
  } else {
    botaoOp.setAttribute('data-target', '#btaoOpcaoModalSimples');

    liNome.setAttribute('id', 'liSimples');
    divDropDown.innerHTML = item.nome;
    liNome.appendChild(botaoOp);
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
