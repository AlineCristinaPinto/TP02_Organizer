let arrCheckTags = document.querySelectorAll(".checkTags");

for(let count =  0; count < arrCheckTags.length; count++) {
    arrCheckTags[count].addEventListener('click', function(e) {
      if($('.checkTags').is(':checked')){
        addTagInputSelected(arrCheckTags[count].value);
      }
      checkList();
    });
}

function addTagInputSelected(tagSelected){

  let listTags = $("#tagSelected").val();
  listTags += " "+tagSelected+";";

  document.querySelector('#tagSelected').value = listTags;

}

function checkList(){
  let listTags = $("#tagSelected").val();
  let arrCheckTagsPresents = $('.checkTags:checked');
  let listTagsPresents="";

  for (var i = 0; i < arrCheckTagsPresents.length; i++) {
    listTagsPresents += " "+arrCheckTagsPresents[i].value+";";
  }

  listTags = listTags.split(";");

  // remove o espaço do final
  listTags.pop();

  if(listTags.length != arrCheckTagsPresents.length){
    document.querySelector('#tagSelected').value = listTagsPresents;
  }

}

function insertTagsOnInput(){
  document.querySelector('#tags').value = $("#tagSelected").val();
}

$('#tags').click(function(){
  let mainInput = document.querySelector('#tags').value;
  let selectInput = document.querySelector('#tagSelected').value;

  if(mainInput != '' && selectInput == ''){
    document.querySelector('#tagSelected').value = $("#tags").val();
  }  

  let arrOldTags = mainInput.split(";");
  arrOldTags.pop();

  let allTags = $('.checkTags');
  
  for(let i=0; i<allTags.length; i++){
    for(let j=0; j<arrOldTags.length; j++){
    	if(allTags[i].value == arrOldTags[j].trim()){
	  allTags[i].checked = true;
	}
    }
  }

});
