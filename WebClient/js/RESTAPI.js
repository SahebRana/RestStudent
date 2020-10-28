$(function(){
	var $studentRecord = $('#studentRecord');
	var stTem = $('#stTem').html();
				
	function addStu(stu){
	$studentRecord.append(Mustache.render(stTem, stu));}
	listing();	
	
//Getting
	function listing(){
		$('#studentRecord').empty();
		$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/student/',
		dataType: 'JSON',
		success: function(students){
			$.each(students, function(i, st){
				addStu(st);
				$('#addEmployeeModal').hide();
			});
		},
		error: function(){ alert("Error on loading Student");}
	});
	}
//Deleting
	$studentRecord.delegate('.deleteStu', 'click', function(){
		var deleteId = $(this).attr('data-id');
		$('.deleteStuOk').click(function(){
		$.ajax({
			type: 'DELETE',
			url: 'http://localhost:8080/student/' + deleteId,
			success: function(){
				listing();
				$('.modal').modal('hide');
			}
		});}
		);
	});
	
	//New Registration
	$('#Submit').on('click', function(){
	//var $id = $('#stId');
	var $roll = $('#stRoll');
	var $name = $('#stName');
	var $email = $('#stEmail');
	var st = {
        "studentRoll": $roll.val(),
        "studentName": $name.val(),
        "studentEmail": $email.val()
    };
		$.ajax({
			headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
			type: 'POST',
			url: 'http://localhost:8080/student/',
			data: JSON.stringify(st),
			success: function(){
						addStu(st);
						$('.modal').modal('hide');},
			error: function(){
				alert('Error occurred' );}
			
		});
	});
//  Editting
$studentRecord.delegate('.btEdit', 'click', function(){
	var $item = $(this).closest('tr');
	var $stId = $(this).attr('data-id');
	var $editSec = $('#editStuSub');
	
	var $rolle = $('#stRollEdit');
	var $namee = $('#stNameEdit');
	var $emaile = $('#stEmailEdit');
	$rolle.val($item.find('td.stRoll').html());
	$namee.val($item.find('td.stName').html());
	$emaile.val($item.find('td.stEmail').html());
	
	$('#btEditOk').on('click', function(){
	
	var st = {
		"studentId" : $stId,
        "studentRoll": $rolle.val(),
        "studentName": $namee.val(),
        "studentEmail": $emaile.val()
    };
		$.ajax({
			headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
			type: 'PUT',
			url: 'http://localhost:8080/student/',
			data: JSON.stringify(st),
			success: function(){
						$('.modal').modal('hide');
						listing();},
			error: function(){
				alert('Error occurred' );}
			
		});
	});
	
	});
	
});

