$(document).ready(function() {
	var columns=[];
	$.ajax({
    	async:		false, 
        url:		"column",
        type:		'GET',
        dataType: 	'json',
        contentType:'application/json',
        mimeType:	'application/json',
        success: function(data, textStatus, jqXHR) {
        	buildsKanban(data);
        },error: function(jqXHR, textStatus, errorThrown){
        }          
    });	
	
	var kanbanCol = $('.panel-body');
	kanbanCol.css('max-height', (window.innerHeight - 150) + 'px');

	var kanbanColCount = parseInt(kanbanCol.length);
	$('.container-fluid').css('min-width', (kanbanColCount * 350) + 'px');

	draggableInit();

	$('.panel-heading').click(function() {
		var $panelBody = $(this).parent().children('.panel-body');
		$panelBody.slideToggle();
	});
});

function draggableInit() {
	var sourceId;

	$('[draggable=true]').bind('dragstart', function (event) {
		sourceId = $(this).parent().attr('id');
		event.originalEvent.dataTransfer.setData("text/plain", event.target.getAttribute('id'));
	});

	$('.panel-body').bind('dragover', function (event) {
		event.preventDefault();
	});

	$('.panel-body').bind('drop', function (event) {
		var children = $(this).children();
		var targetId = children.attr('id');
		if (sourceId != targetId) {
			var elementId = event.originalEvent.dataTransfer.getData("text/plain");
			$('#processing-modal').modal('toggle'); //before post
			setTimeout(function () {
				var element = document.getElementById(elementId);
				children.prepend(element);
				$('#processing-modal').modal('toggle'); // after post
			}, 1000);
		}
		event.preventDefault();
	});
}

function buildsKanban(data){
	var columns = data.columns;
	var varArticle = null;
	for(var i=0;i<columns.length;i++){
		varColumna ="<div class=\"panel panel-primary kanban-col\">";
        varColumna+="	<div class=\"panel-heading\">"+columns[i].titulo+" <i class=\"fa fa-2x fa-plus-circle pull-right\"></i></div>";
        varColumna+="   <div class=\"panel-body\">";
        varColumna+="   	<div id=\""+columns[i].titulo+"\" class=\"kanban-centered\">";
        varColumna+="		</div>";
        varColumna+="   </div>";
        varColumna+="   <div class=\"panel-footer\">";
        varColumna+="   	<a href=\"#\">Add a card...</a>";
        varColumna+="   </div>";
        varColumna+="</div>";
		$("#sortableKanbanBoards").append(varColumna);
		
		varArticle	= "";
		for(var j=0;j<columns[i].article.length;j++){					
			varArticle	+=  "<article class=\"kanban-entry grab\" id=\"item"+String(i)+String(j)+"\" draggable=\"true\">";
			varArticle	+=  "  <div class=\"kanban-entry-inner\">";
			varArticle	+=  "      <div class=\"kanban-label\">";
			varArticle	+=  "          <h2><a href=\"#\">"+columns[i].article[j].nombre+"</a> <span>"+columns[i].article[j].titulo+"</span></h2>";
			varArticle	+=  "          <p>"+columns[i].article[j].descripcion+"</p>";
			varArticle	+=  "      </div>";
			varArticle	+=  "</div>";
			varArticle	+=  "</article>";
		}
		$("#"+columns[i].titulo).append(varArticle);
	}
}
