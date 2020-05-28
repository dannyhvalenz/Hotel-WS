var mysql = require('mysql');
var connection = mysql.createConnection({
	host:'54.162.225.248',
	user:'hotel',
	password:'U.qr8-rdTrsp!7HhpkJ7',
	database:'hotelbd'
});
connection.connect(function(error){
	if(!!error) {
		console.log(error);
	} else {
		console.log('Connected..!');
	}
});

module.exports = connection;