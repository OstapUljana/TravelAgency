var target = $('input')
var valid = false

target.on('change', function(){
  if (valid) {
    // ok, register user
  } else {
    $(this).addClass('animated');
    $(this).addClass('shake');
  };  
})