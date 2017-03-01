/**
 * TIPOS DE DATOS
1;"Text"
2;"Select"
3;"Radio"
4;"Multiple"
5;"Checkbox"

 */
$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: 'GetJSON',
        dataType: "Json",
        success: function(Json) {
            $.each(Json,function (i,item){
                $id = $(this).attr('questionsId');
               
                    if(Json[i].questionsIdType.typesId==2) {
                     
                          $("#preguntas").append("<div id=quest"+i+" class="+'form-group'+ " ><p class="+'lead'+">"+Json[i].questionsTitle+"</p></br>");
                         $("#quest"+i).append("<select class="+'form-control'+" id="+Json[i].questionsId+" name="+Json[i].questionsId+" value="+">");
                          for (var v = 0; v < Json[i].optionsList.length; v++) {
                              
                        $("#"+Json[i].questionsId).append("<option name="+$id+" value="+Json[i].optionsList[v].optionsOption+" > "+Json[i].optionsList[v].optionsOption.toString()+"</option>");
                    }
                    $("#quest"+i).append( "</select></div></br> ");
                
                }
                //TIPO Radio
                    if(Json[i].questionsIdType.typesId==3) {
                        
                     $("#preguntas").append("<div id=quest"+i+" class="+'form-group'+ " ><p class="+'lead'+">"+Json[i].questionsTitle+"</p></br>");
                          for (var v = 0; v < Json[i].optionsList.length; v++) {
                        //      alert(Json[i].optionsList[v].optionsOption)
                        $("#quest"+i).append("<input type="+'radio'+"  name="+$id+" value="+'"'+Json[i].optionsList[v].optionsOption+'"'+" required>"+Json[i].optionsList[v].optionsOption.toString()+"</div></br> ");
                    } } 
//                //TIPO multiple
                    if(Json[i].questionsIdType.typesId==4) {
                     
                          $("#preguntas").append("<div id=quest"+i+" class="+'form-group'+ " ><p class="+'lead'+">"+Json[i].questionsTitle+"</p></br>");
                         $("#quest"+i).append("<select class="+'form-control'+" id="+$id+" multiple=true  name="+Json[i].questionsId+" >");
                         
                          for (var v = 0; v < Json[i].optionsList.length; v++) {
                        $("#"+Json[i].questionsId).append("<option name="+$id+" value="+'"'+Json[i].optionsList[v].optionsOption+'"'+">"+Json[i].optionsList[v].optionsOption.toString()+"</option>");
                    }
                    $("#quest"+i).append( "</select></div></br> ");
                       }

                //TIPO texto
                 if(Json[i].questionsIdType.typesId==1) {
                     $("#preguntas").append("<div id=quest"+i+" class="+'form-group'+ " ><p class="+'lead'+">"+Json[i].questionsTitle+"</p></br>");
                         
                        $("#quest"+i).append("<input type="+'text'+" class="+'form-control'+" name="+$id+" required></div></br> ");
                    } 

                //TIPO checkbox
                    if(Json[i].questionsIdType.typesId==5) {
                          $("#preguntas").append("<div id=quest"+i+" class="+'form-group'+  " ><p class="+'lead'+">"+Json[i].questionsTitle+"</p></br>");
                          
                          for (var v = 0; v < Json[i].optionsList.length; v++) {
                        $("#quest"+i).append("<input type="+'checkbox'+" name="+Json[i].questionsId+" value="+'"'+Json[i].optionsList[v].optionsOption+'"'+">"+Json[i].optionsList[v].optionsOption.toString()+"</div></br> ");
                    } } 
              
            });
//$("#preguntas").append(" <button type="+'submit'+" id="+'send'+" class="+'btn btn-primary btn-block'+" >Enviar formulario</button>");
   
$("#send").click(function(){
         $.ajax({
       
           type: "POST",
           url: "SaveJson",
           dataType: "json",
           data: {company:JSON.stringify($("#preguntas").serializeArray())}
           
       });
       $("#send").attr(":disabled","true");
    });

        }
        
        });
});

//
//$("#send").click(function(){
//       var data = $("#preguntas").serializeArray();
//        alert("holaaaaa");
//         $.ajax({
//           type: "POST",
//           url: "SaveJson",
//           dataType: "json",
//           data: JSON.stringify(data),
//           contentType: 'application/json',
//           mimeType: 'application/json',
//       });
//
//    });
//
//
//function showErrorDiv(){
//    $(".alert-warning").fadeIn('slow').delay(3000).fadeOut('slow');
//}
//function showSendDiv(){
//    $(".alert-success").fadeIn('slow').delay(3000).fadeOut('slow');
//}