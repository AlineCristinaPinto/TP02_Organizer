class Tag {
    constructor(tag) {
        this.tag = tag;
    }
};

let arrTags = new Array();

arrTags.push(new Tag("Tag 1"), new Tag("Tag 2"), new Tag("Tag 3"), new Tag("Tag 4"),
            new Tag("Tag 5"), new Tag("Tag 6"), new Tag("Tag 7"), new Tag("Tag 8"));

function insereTag(tag) {
	let ulItem = document.querySelector('#ulTags');
  let liTag = document.createElement('li');
  let pEspaco = document.createElement('p');
  let input = document.createElement('input');

  input.setAttribute('type', 'checkbox');
  input.setAttribute('class', 'checkTags');
  input.setAttribute('value', tag.tag);

  liTag.innerHTML = "&nbsp #" + tag.tag;
  liTag.appendChild(input);

  ulItem.appendChild(liTag);
  ulItem.appendChild(pEspaco);
}

arrTags.forEach(insereTag);

let arrCheckTags = document.querySelectorAll(".checkTags");

for(let count =  0; count < arrCheckTags.length; count++) {
    arrCheckTags[count].addEventListener('click', function(e) {
      if($('.checkTags').is(':checked')){
        addTagInputSelecionados(arrCheckTags[count].value);
      }
      confereLista();
    });
}

function addTagInputSelecionados(tagSelecionada){

  let listaTags = $("#tagSelecionada").val();
  listaTags += " #"+tagSelecionada+";";

  document.querySelector('#tagSelecionada').value = listaTags;

}

function confereLista(){
  let listaTags = $("#tagSelecionada").val();
  let arrCheckTagsAtuais = $('.checkTags:checked');
  let listaTagsAtual="";

  for (var i = 0; i < arrCheckTagsAtuais.length; i++) {
    listaTagsAtual += " #"+arrCheckTagsAtuais[i].value+";";
  }

  listaTags = listaTags.split(";");

  // remove o espaço do final
  listaTags.pop();

  if(listaTags.length != arrCheckTagsAtuais.length){
    document.querySelector('#tagSelecionada').value = listaTagsAtual;
  }

}
