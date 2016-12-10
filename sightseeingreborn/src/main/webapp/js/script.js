/* global $ */
$(document).ready(function() {
    console.log("Document is ready.");

    // implement DataTable functionality on all sights-tables
    $('.sights-table').DataTable();

    // confirm password validation for createUser.jsp
    $('#submitNewUser').prop('disabled', true);
    $('.passwordMatch').keyup(function(){
        console.log('username: ' + $('#user').val());
        console.log('password: ' + $('#firstPassword').val());
        console.log('confirm: ' + $('#confirmPassword').val());

        if ($('#firstPassword').val() != "" && $('#confirmPassword').val() != ""
            && $('#firstPassword').val() == $('#confirmPassword').val()) {

            console.log('password: [ ' + $('#firstPassword').val() + ' ] == confirm: [ ' + $('#confirmPassword').val() + ' ] :: enabled');
            $('#submitNewUser').prop('disabled', false);

        } else {

            console.log('password: [ ' + $('#firstPassword').val() + ' ] != confirm: [ ' + $('#confirmPassword').val() + ' ] :: disabled');
            $('#submitNewUser').prop('disabled', true);

        }

    });

});