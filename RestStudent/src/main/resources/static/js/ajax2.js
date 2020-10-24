$(function (){
	var $studentRecord = $('#studentRecord');
	var $roll = $('#roll');
	var $name = $('#name');
	var $email = $('#email');
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/student/all/',
		success: function(students){
			$.each(students, function(i, st){
				$studentRecord.append(
				'<tr>' +
				'<th class = "studentId">' + st.studentId + '</th>' +
				'<td class = "stRoll">' + st.studentRoll + '</td>' +
				'<td class = "stName">' + st.studentName + '</td>' +
				'<td class = "stEmail">' + st.studentEmail + '</td>' +
				'<td class = "edit">' + 'e' + '</td>' +
				'<td>' + 'd' + '</td>' +
				'</tr>'
				);
				
			    
			});
		}
	});
});




$(document).ready(function () {
    //tootip
    $('[data-toggle="tooltip"]').tooltip()

    //when click on edit icon
    $('.edit').click(function () {
        $(this).hide().parent().find('.supress_icon').show();
        var name_td = $(this).parent().siblings('.stName');
        var mail_td = $(this).parent().siblings('.stEmail');
        var stname = name_td.text();
        var stmail = mail_td.text();
        var username_input = '<input class="form-control username_box" name="username" value="' + stname + '"/>';
        var mail_input = '<input class="form-control email_box" name="email" value="' + stmail + '"/>';
        $(this).parent().find('.usernamed').val(username);
        $(this).parent().find('.maild').val(email);
        name_td.html(username_input);
        mail_td.html(mail_input);
    });

    $('.cancel').click(function () {
        $(this).parent().find('.supress_icon').hide();
        $(this).parent().find('.edit').show();
        var username = $(this).parent().find('.usernamed').val();
        var email = $(this).parent().find('.maild').val();
        var user_td = $(this).parent().siblings('.username');
        var mail_td = $(this).parent().siblings('.email');
        user_td.html(username);
        mail_td.html(email);
    });

    $('.save').click(function () {
        var base_url = $('#base_url').val();
        var site_url = $('#site_url').val();
        var username = $(this).parent().siblings('.username').find('.username_box').val();
        var email = $(this).parent().siblings('.email').find('.email_box').val();
        var user_id = $(this).parent().find('.user_id').val();
        $.ajax({
            context: this,
            url: site_url + '/users/save',
            type: 'post',
            dataType: 'text',
            data: {
                username: username,
                email: email,
                user_id: user_id
            },
            beforeSend: function () {
                $(this).parent().append('<img id="loader" src="' + base_url + 'assets/images/loader.gif" alt="loading"/>');
            },
            success: function (response) {
                if (response !== 'problem') {
                    var info = response.split('|');
                    $(this).parent().find('.supress_icon').hide();
                    $(this).parent().find('.edit').show();
                    var user_td = $(this).parent().siblings('.username');
                    var mail_td = $(this).parent().siblings('.email');
                    user_td.html(info[0]);
                    mail_td.html(info[1]);
                } else {
                    alert('There ais a problem');
                }
                $('#loader').remove();
            }
        });
    });
});